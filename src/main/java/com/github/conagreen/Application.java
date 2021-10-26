package com.github.conagreen;

import java.lang.reflect.Field;

public class Application {

    public static void main(String[] args) throws ClassNotFoundException {
        final Class clazz = Class.forName("com.github.conagreen.Dummy");
        System.out.println("clazz = " + clazz);

        final Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("---------------------------");
            System.out.println(field.getName());
            System.out.println(field.getModifiers());
        }
    }
}
