package com.eduful9877.stack;

import java.util.ArrayList;

// push and pop, isEmpty using LinkedList
public class Stack<T> {

    public ArrayList<T> list;

    public Stack() {
        list = new ArrayList<>();
    }

    public void push(T element) {
        list.add(list.size(), element);
    }

    public void pop() {
        list.remove(list.size () - 1 );
    }
}
