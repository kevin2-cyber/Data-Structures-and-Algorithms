package com.eduful9877;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Result {

    public static void solve(double meal_cost, int tip_percent, int tax_percent) {
        tip_percent = (int) (0.15 * meal_cost);
        tax_percent = (int) (0.08 * meal_cost);

        meal_cost = tip_percent + tax_percent + meal_cost;
        System.out.println(meal_cost);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader (new InputStreamReader (System.in));

        double meal_cost = Double.parseDouble(bufferedReader.readLine().trim());

        int tip_percent = Integer.parseInt(bufferedReader.readLine().trim());

        int tax_percent = Integer.parseInt(bufferedReader.readLine().trim());

        Result.solve(meal_cost, tip_percent, tax_percent);

        bufferedReader.close();
    }
}
