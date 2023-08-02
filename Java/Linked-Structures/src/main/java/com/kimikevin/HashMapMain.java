package com.kimikevin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HashMapMain {
    public static void main(String[] args) {

        // create a HashMap dictionary
        HashMap<String, List<String>> countries = new HashMap<>();

        // create a list of countries
        List<String> G = new ArrayList<>() {
            {
                add("Ghana");
                add("Greenland");
                add("Greece");
            }
        };

        List<String> I = new ArrayList<>() {
            {
                add("India");
                add ("Ireland"); add ("Iran");
                add ("Iraq");
                add("Italy");
            }
        };

        List<String> U = new ArrayList<>() {
            {
                add ("United States");
                add("United Kingdom");
                add ("Uruguay");
            }
        };

        // initialize hashmap
        countries.put("G", G);
        countries.put("I", I);
        countries.put("U", U);

        // get list of I's
        List<String> result = countries.get("I");

        for (String country : result) {
            System.out.println(country);
        }

        // remove key/value
        countries.remove("I");
        System.out.println();

        // try to get I
        System.out.println("Try to get value after deleting");
        System.out.println(countries.get("I"));
    }
}
