package com.github.conagreen;

import java.lang.reflect.*;

public class Application {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
//        final Class<?> clazz = Class.forName("com.github.conagreen.TestCaseByJunit3");
        // 해보기 1 - 클래스 정보 출력
//        System.out.println("clazz = " + clazz);

        // 해보기 2 -  "test"로 시작하는 이름을 가진 메서드만 실행
//        Object object = clazz.newInstance();
//        final Method[] methods = clazz.getDeclaredMethods();
//        for (Method method : methods) {
//            if (method.getName().startsWith("test"))
//            method.invoke(object);
//        }

        // 해보기 3 - 어노테이션 걸려있는 메소드만 실행
//        final Class<?> clazz2 = TestCaseByJunit4.class;
//        System.out.println("clazz2 = " + clazz2);
//
//        Object object2 = clazz2.newInstance();
//        for (Method method : clazz2.getDeclaredMethods()) {
//            if (method.isAnnotationPresent(RunTest.class)){
//                method.invoke(object2);
//            }
//        }

        // 해보기 4 - private field에 접근하기
//        Dog dog = new Dog();
//        final Field[] fields = dog.getClass().getDeclaredFields();
//        for (Field field : fields) {
//            field.setAccessible(true);
//            if (field.getType().equals(String.class)) field.set(dog, "토토");
//            else if (field.getType().equals(long.class)) field.set(dog, 12);
//
//            System.out.println(field.get(dog));
//        }

        // 해보기 5 - 생성자가 파라미터를 가지고 있는 경우에 인스턴스 생성
        final Class<?> clazz4 = DumbDumb.class;
        final Constructor<?> constructor = clazz4.getConstructor(String.class, long.class);
        DumbDumb dumbDumb = (DumbDumb) constructor.newInstance("dumb", 1234);
        System.out.println("name = " + dumbDumb.getName());
        System.out.println("amount = " + dumbDumb.getAmount());
    }
}