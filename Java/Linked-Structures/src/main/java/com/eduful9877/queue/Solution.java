package com.eduful9877.queue;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        int i = 4;
        double d = 4.0;
        String s = "HackerRank ";
        Scanner scan = new Scanner ( System.in );

        /* Declare second integer, double, and String variables. */
        int inputInteger;
        double inputDouble;
        String inputString;

        /* Read and save an integer, double, and String to your variables.*/
        // Note: If you have trouble reading the entire String, please go back and review the Tutorial closely.
        inputString = scan.nextLine();
        inputInteger = scan.nextInt();
        inputDouble = scan.nextDouble();

        /* Print the sum of both integer variables on a new line. */
        System.out.println(i + inputInteger);

        /* Print the sum of the double variables on a new line. */
        System.out.printf("%,.1f\n",(d + inputDouble));

        /** Concatenate and print the String variables on a new line;
         the 's' variable above should be printed first. */
        String concat = s + inputString;
        System.out.println ( concat );

//        scan.close();
    }
}
