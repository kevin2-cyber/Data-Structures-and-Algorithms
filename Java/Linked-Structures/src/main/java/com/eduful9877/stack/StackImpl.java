package com.eduful9877.stack;

/**
 * Author = Kelvin Eduful
 * StudentId = 10889877
 */

public class StackImpl {
    public static void main(String[] args) {
        Stack<Integer> test = new Stack<> ();
        test.push ( 2 );
        test.push ( 3 );
        test.push ( 4 );
        test.push ( 5 );
        test.push ( 6 );
        test.push ( 7 );
        test.push ( 8 );

        for (int i = 0; i < test.list.size ( ); i++) {
            System.out.println ( test.list.get(i) );
        }

        test.pop ();
        test.pop ();
        System.out.println ("Remove some" );

        for (int i = 0; i < test.list.size ( ); i++) {
            System.out.println ( test.list.get(i) );
        }

        System.out.println (test.isEmpty () );
    }
}