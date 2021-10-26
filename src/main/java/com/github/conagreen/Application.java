package com.github.conagreen;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Application {

    public static void main(String[] args) throws ClassNotFoundException {
        final Class clazz = Class.forName("com.github.conagreen.Dummy");
        System.out.println("clazz = " + clazz);
        // java reflection api - Class
        System.out.println(clazz.getCanonicalName());
        System.out.println(clazz.getName());
        System.out.println(clazz.getModifiers());
        System.out.println("------------------------------");
        for (Field field : clazz.getFields()) {
            System.out.println("field = " + field);
        }
        System.out.println("------------------------------");
        for (Field declaredField : clazz.getDeclaredFields()) {
            System.out.println("declaredField = " + declaredField);
        }
        System.out.println("------------------------------");
        for (Constructor constructor : clazz.getConstructors()) {
            System.out.println("constructor = " + constructor);
        }
        System.out.println("------------------------------");
        for (Constructor declaredConstructor : clazz.getDeclaredConstructors()) {
            System.out.println("declaredConstructor = " + declaredConstructor);
        }
        System.out.println("------------------------------");
        for (Method method : clazz.getMethods()) {
            System.out.println("method = " + method);
        }
        System.out.println("------------------------------");
        for (Method declaredMethod : clazz.getDeclaredMethods()) {
            System.out.println("declaredMethod = " + declaredMethod);
        }
        System.out.println("------------------------------");
    }
}
