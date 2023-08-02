package com.eduful9877.stack;

import java.util.ArrayList;

// push and pop, isEmpty using LinkedList
public class Stack<T> {

    private ArrayList<T> list;

    public Stack() {
        list = new ArrayList<>();
    }

    public ArrayList<T> getList() {
        return list;
    }

    public void push(T element) {
        list.add(list.size(), element);
    }

    public void pop() {
        list.remove(list.size() - 1);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}
