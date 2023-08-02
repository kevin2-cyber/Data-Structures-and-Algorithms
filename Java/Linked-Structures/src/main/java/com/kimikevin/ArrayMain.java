package com.kimikevin;

public class ArrayMain {
    public static void main(String[] args) {
        // initialize groceries
        String[] groceries = {"apple","banana","carrots","olive oil", "avocados"};

        // print length of array
        System.out.println("Number of groceries: " + groceries.length);

        // print out all groceries
        for (String item : groceries) {
            System.out.print(item + ", ");
        }
        System.out.println();

        // retrieve element in constant time
        System.out.println("grocery item at index 3: " + groceries[3]);

        // remove element
        groceries[3] = null;

        // check length
        System.out.println("Number of groceries: " + groceries.length);

        // print out elements again
        for (String item : groceries) {
            System.out.print(item + ", ");
        }
    }
}
