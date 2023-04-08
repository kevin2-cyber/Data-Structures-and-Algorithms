package com.kimikevin

import java.util.LinkedList

fun bfs(graph: Array<MutableList<Int>>, start: Int) {
    val visited = BooleanArray(graph.size)
    val queue = LinkedList<Int>()
    visited[start] = true
    queue.offer(start)
    while (!queue.isEmpty()) {
        val current = queue.poll()
        print("$current")
        for (neighbor in graph[current]) {
            if (!visited[neighbor]) {
                visited[neighbor] = true
                queue.offer(neighbor)
            }
        }
    }
}

fun main() {
    val squares = MutableList(5) { (it + 1) * (it + 1) }
    val square = MutableList(4) {it + 2}
    bfs((square, squares), 5)
}


