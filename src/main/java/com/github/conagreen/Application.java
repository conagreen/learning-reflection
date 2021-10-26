package com.github.conagreen;

import java.lang.reflect.Constructor;

public class Application {

    public static void main(String[] args) throws ClassNotFoundException {
        final Class clazz = Class.forName("com.github.conagreen.Dummy");
        System.out.println("clazz = " + clazz);

        // 생성자 API
        for (Constructor<?> constructor : clazz.getConstructors()) {
            System.out.println(constructor);
            System.out.println(constructor.getDeclaringClass());
            System.out.println(constructor.getModifiers());
            System.out.println("-----------------------------");
            for (Class<?> parameterType : constructor.getParameterTypes()) {
                System.out.println("parameterType = " + parameterType);
            }
            System.out.println("-----------------------------");
        }
    }
}
