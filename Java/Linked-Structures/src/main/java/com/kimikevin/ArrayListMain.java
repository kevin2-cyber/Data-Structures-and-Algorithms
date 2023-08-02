package com.kimikevin;

import java.util.ArrayList;
import java.util.List;

public class ArrayListMain {
    public static void main(String[] args) {

        // initialize a list
        List<String> groceries = new ArrayList<>();
        groceries.add("apple");
        groceries.add("banana");
        groceries.add("carrots");
        groceries.add("olive oil");
        groceries.add("avocado");

        // print size of groceries
        System.out.println("The Number of groceries: " + groceries.size());

        // print out all groceries
        for(String item : groceries) {
            System.out.print(item + ", ");
        }

        System.out.println();

        // retrieve element in constant time
        System.out.println("grocery item at index 3: " + groceries.get(3));

        // remove element
        groceries.remove(0);

        // check size
        System.out.println("The number of groceries: " + groceries.size());

        // print out elements again
        for (String item : groceries) {
            System.out.print(item + ", ");
        }
    }
}
