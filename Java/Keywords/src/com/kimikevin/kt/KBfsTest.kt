package com.kimikevin.kt

import org.junit.Test



/**
 * https://github.com/eugenp/tutorials/tree/master/algorithms-miscellaneous-3/src/main/java/com/baeldung/algorithms/breadthfirstsearch
 * 6.1 BinaryTree: A Basic Binary Tree http://opendatastructures.org/versions/edition-0.1e/ods-java/6_1_BinaryTree_Basic_Binary.html#sec:bintree:traversal
 */
class KBfsTest {

    private fun <T, TNode : GraphNode<T, TNode>> printFindUsingBFS(searchValue: T, hasBreadthFirstSearch: HasBreadthFirstSearchA<T, TNode>) {
        with(hasBreadthFirstSearch) {
            println("--${strategyName}--")
            findUsingBFS(searchValue)
            println()
        }
    }

    private fun <T, TNode: GraphNode<T, TNode>> printFindUsingBFS(title: String, searchValue: T, vararg elements: HasBreadthFirstSearchA<T, TNode>) {
        println("< $title>")
        println()

        sequenceOf(*elements).forEach {
            printFindUsingBFS(searchValue, it)
        }
    }

    /**
     * Breadth-First Search Algorithm in Java https://www.baeldung.com/java-breadth-first-search
     * The basic approach of the Breadth-First Search (BFS) algorithm is to search for a node into a tree or graph structure
     * by exploring neighbors before children.
     */
    @Test
    fun findUsingBFSTreeBaeldung() {

        fun Tree<Int>.populateTree() {
            addChild(2) {
                addChild(3)
            }
            addChild(4)
        }

        val rootValue = 10
        printFindUsingBFS("Tree",4,
            treeWithNotOrderedChildrenOf(rootValue, Tree<Int>::populateTree),
            treeWithLeftToRightOrderedChildrenOf(rootValue, Tree<Int>::populateTree),
            treeRightToLeftOrderedChildrenOf(rootValue, Tree<Int>::populateTree)
        )
    }

    @Test
    fun findUsingBFSGraphBaeldung() {

        fun populateGraph(neighborsMutableCollectionStrategy: NeighborsMutableCollectionStrategyA<Int, Graph<Int>>) : Graph<Int> {

            val start = Graph(10, neighborsMutableCollectionStrategy)
            val firstNeighbor = Graph(2, neighborsMutableCollectionStrategy)
            start.connect(firstNeighbor)

            val firstNeighborNeighbor = Graph(3, neighborsMutableCollectionStrategy)
            firstNeighbor.connect(firstNeighborNeighbor)
            firstNeighborNeighbor.connect(start)

            val secondNeighbor = Graph(4, neighborsMutableCollectionStrategy)
            start.connect(secondNeighbor)

            return firstNeighborNeighbor
        }

        printFindUsingBFS("Graph", 4,
            graphWithNotOrderedChildrenOf(::populateGraph),
            graphWithLeftToRightChildrenOf(::populateGraph),
            graphWithRightToLeftOrderedChildrenOf(::populateGraph)
            )
    }
}