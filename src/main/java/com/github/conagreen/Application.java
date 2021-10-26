package com.github.conagreen;

public class Application {

    public static void main(String[] args) throws ClassNotFoundException {
        final Class clazz = Class.forName("com.github.conagreen.Dummy");
        final Class clazz2 = Dummy.class;

        System.out.println("clazz = " + clazz);
        System.out.println("clazz2 = " + clazz2);
    }
}
