package com.kimikevin;

public class Node {
    int value;
    Node left;
    Node right;

    Node(int value) {
        this.value = value;
        left = null;
        right = null;
    }

    private Node addRecursive(Node current, int value) {
        if (current == null)
            return new Node(value);

        if (value < current.value)
            current.left = addRecursive(current.left, value);
        else if (value > current.value)
            current.right = addRecursive(current.right, value);
        else
            return current;

        return current;
    }

    private boolean containsNodeRecursive(Node current, int value) {
        if (current == null)
            return false;

        if (value == current.value)
            return true;
        return value < current.value
                ? containsNodeRecursive(current.left, value)
                : containsNodeRecursive(current.right, value);
    }
}
