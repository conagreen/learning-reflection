# 1. Java Reflection API

클래스 가지고 오는 방법

```java
final Class<?> clazz = Class.forName("com.github.conagreen.Dummy");
final Class<?> clazz2 = Dummy.class;
```

## 1.1. class

- Class 클래스는 클래스에 대한 정보를 얻을 수 있다.

```java
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
```

## 1.2. constructor

```java
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
```

## 1.3. fields

- Field 클래스는 클래스에 있는 변수들의 정보를 제공하기 위해 사용한다.

```java
final Field[] fields = clazz.getDeclaredFields();
for (Field field : fields) {
    System.out.println("---------------------------");
    System.out.println(field.getName());
    System.out.println(field.getModifiers());
}
```

## 1.4. methods

- Method 클래스를 이용하여 메소드에 대한 정보를 얻을 수 있다.

```java
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
```