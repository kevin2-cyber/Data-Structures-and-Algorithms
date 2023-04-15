package com.kimikevin.kt



interface HasBreadthFirstSearchA<T, TNode : GraphNode<T, TNode>> {
    fun findUsingBFS(value: T): TNode?

    val strategyName: String
}

/**
 * If the order of neighbors is not important,
 * neighborsMutableCollectionStrategy = [hashSetOf] / [HashSet]
 * otherwise neighborsMutableCollectionStrategy = [mutableSetOf] / [LinkedHashSet]
 *
 * neighborsMutableCollectionStrategy is a GOF.Strategy, which collection to leverage for neighborsMutable
 * addCurrentNodeNeighborsOrderStrategy is a GOF.Strategy, that defines the order how to add currentNode.neighborsMutable to queue. This order will define the order,
 * how neighbors will be traversed.
 *
 * [neighborsMutableCollection] and [addAllCurrentNodeNeighborsOrder] are mutually dependent.
 * Hence, [NeighborsMutableCollectionStrategyA] is leveraged instead of separate
 * neighborsMutableCollectionStrategy: () -> MutableSet<TNode>,
 * private val addAllCurrentNodeNeighborsOrderStrategy: ArrayDeque<TNode>.(currentNodeNeighbors: Collection<TNode>) -> Unit
 */

interface NeighborsMutableCollectionStrategyA<T, TNode : GraphNode<T, TNode>> {
    val neighborsMutableCollection: MutableSet<TNode>
    fun ArrayDeque<TNode>.addAllCurrentNodeNeighborsOrder(currentNodeNeighbors: Collection<TNode>)

}

sealed class NeighborsMutableCollectionStandardStrategy<T, TNode: GraphNode<T, TNode>> : NeighborsMutableCollectionStrategyA<T, TNode> {

    class NotOrdered<T, TNode : GraphNode<T, TNode>> : NeighborsMutableCollectionStandardStrategy<T, TNode>() {
        override val neighborsMutableCollection get() = hashSetOf<TNode>()

        override fun ArrayDeque<TNode>.addAllCurrentNodeNeighborsOrder(currentNodeNeighbors: Collection<TNode>) {
            addAll(currentNodeNeighbors)
        }
    }

    class LeftToRightOrdered<T, TNode : GraphNode<T, TNode>> : NeighborsMutableCollectionStandardStrategy<T, TNode>() {
        override val neighborsMutableCollection get() = mutableSetOf<TNode>()

        override fun ArrayDeque<TNode>.addAllCurrentNodeNeighborsOrder(currentNodeNeighbors: Collection<TNode>) {
            addAll(currentNodeNeighbors)
        }

    }

    class RightToLeftOrdered<T, TNode : GraphNode<T, TNode>> : NeighborsMutableCollectionStandardStrategy<T, TNode>() {
        override val neighborsMutableCollection get() = mutableSetOf<TNode>()

        override fun ArrayDeque<TNode>.addAllCurrentNodeNeighborsOrder(currentNodeNeighbors: Collection<TNode>) {
            addAll(currentNodeNeighbors.reversed())
        }
    }
}

sealed class GraphNode<T, TNode : GraphNode<T, TNode>>(
    protected val neighborMutableCollectionStrategy: NeighborsMutableCollectionStrategyA<T, TNode>
) : HasBreadthFirstSearchA<T, TNode> {

    abstract val value: T

    /**
     * Order of neighbors is not important, Hence, [hashSetOf] / [HashSet] is leveraged instead of [mutableSetOf] / [LinkedHashSet]
     * [MutableSet] ... that does not support duplicate elements .... Hence, [GraphNode] can't be connected with the same neighbor more than one time.
     */

    protected val neighborsMutable: MutableSet<TNode> = neighborMutableCollectionStrategy.neighborsMutableCollection

    // GOF.TemplateMethod.VariantPart
    protected abstract fun ArrayDeque<TNode>.addRoot()

    protected abstract fun MutableSet<TNode>.addCurrentNode(node: TNode)
    protected abstract fun ArrayDeque<TNode>.removeAlreadyVisitedSet(alreadyVisitedSet: Set<TNode>)

    // GOF.TemplateMethod.InvariantPart
    override fun findUsingBFS(value: T): TNode? {
        val queue = ArrayDeque<TNode>()
        queue.addRoot()

        val alreadyVisitedSet: MutableSet<TNode> = hashSetOf()
        var currentNode: TNode?

        while (!queue.isEmpty()) {
            currentNode = queue.remove()
            println("Visited node with value: ${currentNode.value}")
            if (currentNode.value == value)
                return currentNode
            else {
                alreadyVisitedSet.addCurrentNode(currentNode)
                // queue.addAll(currentNode.neighborsMutable)
                neighborMutableCollectionStrategy.run {
                    queue.addAllCurrentNodeNeighborsOrder(currentNode.neighborsMutable)
                }
                queue.removeAlreadyVisitedSet(alreadyVisitedSet)
            }

        }
        return null
    }

    override val strategyName: String
        get() = neighborMutableCollectionStrategy.javaClass.kotlin.simpleName!!

}

class Tree<T>(override val value: T, neighborsMutableCollectionStrategy: NeighborsMutableCollectionStrategyA<T, Tree<T>>) : GraphNode<T, Tree<T>>(neighborsMutableCollectionStrategy) {

    private val childrenMutable get() = neighborsMutable

    val children: Set<Tree<T>> get() = childrenMutable

    infix fun addChild(value: T) = Tree(value, neighborMutableCollectionStrategy).also {
        childrenMutable += it
    }

    /**
     * Execution termination is ensured by the absence of cycles
     */
    override fun ArrayDeque<Tree<T>>.addRoot() {
        add(this@Tree)
    }

    override fun MutableSet<Tree<T>>.addCurrentNode(node: Tree<T>) {}
    override fun ArrayDeque<Tree<T>>.removeAlreadyVisitedSet(alreadyVisitedSet: Set<Tree<T>>) {}
}

class Graph<T>(override val value: T, neighborsMutableCollectionStrategy: NeighborsMutableCollectionStrategyA<T, Graph<T>>) : GraphNode<T, Graph<T>>(neighborsMutableCollectionStrategy) {

    val neighbors: Set<Graph<T>> get() = neighborsMutable

    infix fun connect(node: Graph<T>) {
        require(this != node) {
            "Can't connect node to itself"
        }
        this.neighborsMutable += node
        node.neighborsMutable += node
    }

    override fun ArrayDeque<Graph<T>>.addRoot() {
        add(this@Graph)
    }

    override fun MutableSet<Graph<T>>.addCurrentNode(node: Graph<T>) {
        add(node)
    }

    override fun ArrayDeque<Graph<T>>.removeAlreadyVisitedSet(alreadyVisitedSet: Set<Graph<T>>) {
        removeAll(alreadyVisitedSet)
    }
}

@Target(AnnotationTarget.CLASS, AnnotationTarget.TYPE, AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY)
@DslMarker
annotation class GraphNodeDSL

@GraphNodeDSL
fun <T> Tree<T>.addChild(value: T, block: Tree<T>.() -> Unit) = addChild(value).block()

@GraphNodeDSL
fun <T> treeOf(root: Tree<T>, block: Tree<T>.() -> Unit): Tree<T> = root.apply { block() }

@GraphNodeDSL
fun <T> treeWithNotOrderedChildrenOf(value: T, block: Tree<T>.() -> Unit): Tree<T> = treeOf(Tree(value, NeighborsMutableCollectionStandardStrategy.NotOrdered()), block)
@GraphNodeDSL
fun <T> treeWithLeftToRightOrderedChildrenOf(value: T, block: Tree<T>.() -> Unit): Tree<T> = treeOf(Tree(value, NeighborsMutableCollectionStandardStrategy.LeftToRightOrdered()), block)
@GraphNodeDSL
fun <T> treeRightToLeftOrderedChildrenOf(value: T, block: Tree<T>.() -> Unit): Tree<T> = treeOf(Tree(value, NeighborsMutableCollectionStandardStrategy.RightToLeftOrdered()), block)

@GraphNodeDSL
fun <T> graphWithNotOrderedChildrenOf(initBlock: (NeighborsMutableCollectionStrategyA<Int, Graph<Int>>) -> Graph<T>): Graph<T> = initBlock(NeighborsMutableCollectionStandardStrategy.NotOrdered())
@GraphNodeDSL
fun <T> graphWithLeftToRightChildrenOf(initBlock: (NeighborsMutableCollectionStrategyA<Int, Graph<Int>>) -> Graph<T>): Graph<T> = initBlock(NeighborsMutableCollectionStandardStrategy.LeftToRightOrdered())
@GraphNodeDSL
fun <T> graphWithRightToLeftOrderedChildrenOf(initBlock: (NeighborsMutableCollectionStrategyA<Int, Graph<Int>>) -> Graph<T>): Graph<T> = initBlock(NeighborsMutableCollectionStandardStrategy.RightToLeftOrdered())

