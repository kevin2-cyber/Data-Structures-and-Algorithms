package com.eduful9877.stack;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

// push and pop, isEmpty using LinkedList
public class Stack<T> implements Collection<T> {

    private ArrayList<T> list;

    public Stack() {
        list = new ArrayList<>();
    }


    public void push(T element) {
        list.add(list.size(), element);
    }

    public void pop() {
        list.remove(list.size() - 1);
    }

    @Override
    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return list.contains(o);
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }
}
