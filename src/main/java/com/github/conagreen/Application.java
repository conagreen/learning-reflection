package com.github.conagreen;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Application {

    public static void main(String[] args) throws ClassNotFoundException {
        final Class clazz = Class.forName("com.github.conagreen.Dummy");
        System.out.println("clazz = " + clazz);

        final Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println("=======================================");
            System.out.println(method.getName());
            final Class<?>[] parameterTypes = method.getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {
                System.out.println("-------------------------------");
                System.out.println("parameterType = " + parameterType);
                System.out.println("-------------------------------");
            }
            System.out.println(method.getReturnType().getName());
            System.out.println("=======================================");
        }
    }
}
