package com.kimikevin;

import java.util.LinkedList;

public class Graph {

    private int vertex; // number of vertices

    private LinkedList<Integer>[] adjacent; // adjacency list

    public Graph(int vertex) {
        this.vertex = vertex;
        adjacent = new LinkedList[vertex];
        for (int i = 0; i < vertex; i++) {
            adjacent[i] = new LinkedList<>();
        }
    }

    public void addEdge(int v, int w) {
        adjacent[v].add(w);
    }

    public void breadthFirstSearch(int state) {

        boolean[] visited = new boolean[vertex];

        LinkedList<Integer> queue = new LinkedList<>();

        visited[state] = true;
        queue.add(state);

        while (queue.size() != 0) {
            state = queue.poll();
            System.out.println(state + " ");

            for (int number : adjacent[state]) {
                if (!visited[number]) {
                    visited[number] = true;
                    queue.add(number);
                }
            }

            // Using the while loop
//            Iterator<Integer> integerIterator = adjacent[state].listIterator();
//            while (integerIterator.hasNext()) {
//                int number = integerIterator.next();
//                if (!visited[number]) {
//                    visited[number] = true;
//                    queue.add(number);
//                }
//            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(4);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        System.out.println("Following is Breadth First Traversal " + "(starting from vertex 2)");

        graph.breadthFirstSearch(2);
    }
}
