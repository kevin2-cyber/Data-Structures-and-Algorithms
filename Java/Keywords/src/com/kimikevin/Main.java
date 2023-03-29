package com.kimikevin;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Main {
    public static void main(String[] args) {
        Field[] fields = Modifier.class.getDeclaredFields();
        System.out.println("Java Reserved keywords");
        for (Field field : fields) {
            int modifiers = field.getModifiers();
            if (Modifier.isFinal(modifiers) && Modifier.isStatic(modifiers)) {
                try {
                    System.out.println(field.getName());
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        }
    }
}