## [ INDEX ]

- [01. Java Reflection API](#01-java-reflection-api)
  - [1-1. class](#1-1-class)
  - [1-2. constructor](#1-2-constructor)
  - [1-3. fields](#1-3-fields)
  - [1-4. methods](#1-4-methods)
  - [1-5. 해보기](#1-5-해보기)
     - [1. 클래스 정보 출력](#1-클래스-정보-출력)
     - [2. test로 시작하는 이름을 가진 메서드만 실행](#2-test로-시작하는-이름을-가진-메서드만-실행)
     - [3. 어노테이션 걸려있는 메서드만 실행](#3-어노테이션-걸려있는-메서드만-실행)
     - [4. private field에 접근한 후 값 변경하기](#4-private-field에-접근한-후-값-변경하기)
     - [5. 파라미터를 2개 가지고 있는 생성자로 인스턴스 생성](#5-파라미터를-2개-가지고-있는-생성자로-인스턴스-생성)
     - [6. 최종 코드](#6-최종-코드)
  - [1-6. 참고](#1-6-참고)

- [02. reflections 이용해서 컴포넌트 스캔 만들기](#02-reflections-이용해서-컴포넌트-스캔-만들기)
  - [2-1. 과정](#2-1-과정)
    - [1. 스캔 대상이 될 어노테이션 정의](#1-스캔-대상이-될-어노테이션-정의)
    - [2. 클래스에 정의한 어노테이션 적용](#2-클래스에-정의한-어노테이션-적용)
    - [3. URL 및 Scanner 설정](#3-URL-및-Scanner-설정)
    - [4. getTypesAnnotatedWith 메서드로 클래스 가져오기](#4-getTypesAnnotatedWith-메서드로-클래스-가져오기)
    - [5. 최종 전체 코드](#5-최종-전체-코드)
  - [2-2. 참고](#2-2-참고)



# 01. Java Reflection API
#### Java Reflection이란?
>- 객체를 통해 클래스의 정보를 분석해 내는 프로그램 기법
>- 리플렉션은 구체적인 클래스 타입을 알지 못해도, 그 클래스의 메서드, 타입, 필드 등에 접근할 수 있도록 해주는 Java API 

**클래스 가지고 오는 방법**

```java
final Class<?> clazz = Class.forName("com.github.conagreen.prac_basic.Dummy");
final Class<?> clazz2 = Dummy.class;
```

## 1-1. class

- Class 클래스는 클래스에 대한 정보를 얻을 수 있다.

```java
public class Application {
    
    public static void main(String[] args) throws ClassNotFoundException {
        final Class clazz = Class.forName("com.github.conagreen.prac_basic.Dummy");
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

## 1-2. constructor

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

## 1-3. fields

- Field 클래스는 클래스에 있는 변수들의 정보를 제공하기 위해 사용한다.

```java
final Field[] fields = clazz.getDeclaredFields();
for (Field field : fields) {
    System.out.println("---------------------------");
    System.out.println(field.getName());
    System.out.println(field.getModifiers());
}
```

## 1-4. methods

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

## 1-5. 해보기

### 1. 클래스 정보 출력

### 2. test로 시작하는 이름을 가진 메서드만 실행

```java
public class TestCaseByJunit3 {
    public void testDummy() {
        System.out.println("test dummy executed");
    }
    
    public void test2() {
        System.out.println("test2");
    }
    
    public void nothing() {
        System.out.println("Can not be executed");
    }
}
```

- 클래스 생성
  - clazz.newInstance()
  - method.invoke(clazz.newInstance())

### 3. 어노테이션 걸려있는 메서드만 실행

```java
public class TestCaseByJunit4 {
    
    @RunTest
    public void uno() {
        System.out.println("uno");
    }
    
    @RunTest
    public void dos() {
        System.out.println("dos");
    }
    
    public void tres() {
        System.out.println("tres");
    }
}
```

- method. isAnnotationPresent(RunTest.class)

### 4. private field에 접근한 후 값 변경하기
- fields = getDeclaredFields()
- field.setAccessible(true)
- 생성
  - dog = new Dog()
  - field.set(dog, 값);
- getter

### 5. 파라미터를 2개 가지고 있는 생성자로 인스턴스 생성
- 기본 생성자가 없으면 clazz.newInstance() 불가
- clazz.get

### 6. 최종 코드
[해보기 결과 코드 보러가기](src/main/java/com/github/conagreen/prac_basic)

## 1-6. 참고
>- [위키피디아](https://en.wikipedia.org/wiki/Reflective_programming)


# 02. reflections 이용해서 컴포넌트 스캔 만들기

## 2-1. 과정

### 1. 스캔 대상이 될 어노테이션 정의
- @Controller
- @Repository
- @Service

**[ 어노테이션 속성 설정 ]**  
- @Retention(RetentionPolicy.RUNTIME) : 어노테이션의 라이프 사이클 설정
- @Target(ElementType.TYPE) : 어노테이션 적용할 위치 설정

```java
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Controller {
}
```

### 2. 클래스에 정의한 어노테이션 적용
```java
@Controller
public class AController {
}
```

### 3. URL 및 Scanner 설정
- url과 scanner를 설정하는 방법은 Reflections 생성자 또는 ConfigurationBuilder를 이용하는 방법이 있음.

**[방법1. 생성자의 파라미터로 설정하는 방법 ]**
```java
Reflections reflections = new Reflections(
        "com.github.conagreen.component_scan",
        new SubTypesScanner(),
        new TypeAnnotationsScanner());
```

**[방법2. ConfigurationBuilder를 이용하는 방법 ]**
```java
Reflections reflections = new Reflections( new ConfigurationBuilder()
        .setUrls(ClasspathHelper.forPackage("com.github.conagreen.component_scaㅅ"))
        .setScanners(new SubTypesScanner(), new TypeAnnotationsScanner()));
```

### 4. getTypesAnnotatedWith 메서드로 클래스 가져오기

```java
public Set<Class<?>> getClassWithControllerAnnotation() {
        Reflections reflections = new Reflections(
                "com.github.conagreen.component_scan",
                new SubTypesScanner(),
                new TypeAnnotationsScanner());
        return reflections.getTypesAnnotatedWith(Controller.class);
    }
```
- getTypesAnnotatedWith의 매개변수로 주어진 어노테이션을 기준으로 클래스를 가져온다.
- 클래스의 런타임 어노테이션을 찾는 스캐너는 TypeAnnotationsScanner이고, 
- TypeAnnotationsScanner는 따로 설정하지 않으면 기본으로 설정되는 스캐너이므로 코드를 줄일 수 있다.

### 5. 최종 전체 코드

```java
public class Application {
    private final Reflections reflections = new Reflections("com.github.conagreen.component_scan");

    public Set<Class<?>> getClassWithControllerAnnotation() {
        return reflections.getTypesAnnotatedWith(Controller.class);
    }

    public Set<Class<?>> getClassWithRepositoryAnnotation() {
        return reflections.getTypesAnnotatedWith(Repository.class);
    }

    public Set<Class<?>> getClassWithServiceAnnotation() {
        return reflections.getTypesAnnotatedWith(Service.class);
    }


    public static void main(String[] args) {
        Application application = new Application();

        System.out.println("----------------------------- @Controller -----------------------------");
        final Set<Class<?>> classWithControllerAnnotation = application.getClassWithControllerAnnotation();
        for (Class<?> controllerClass : classWithControllerAnnotation) {
            System.out.println("controllerClass = " + controllerClass);
        }

        System.out.println("----------------------------- @Repository -----------------------------");
        final Set<Class<?>> classWithRepositoryAnnotation = application.getClassWithRepositoryAnnotation();
        for (Class<?> repositoryClass : classWithRepositoryAnnotation) {
            System.out.println("repositoryClass = " + repositoryClass);
        }

        System.out.println("----------------------------- @Service -----------------------------");
        final Set<Class<?>> classWithServiceAnnotation = application.getClassWithServiceAnnotation();
        for (Class<?> serviceClass : classWithServiceAnnotation) {
            System.out.println("serviceClass = " + serviceClass);
        }

    }
}
```

## 2-2. 참고
- 하단 링크의 문서를 참고해 실습해 보았다. 간혹 오타가 존재하긴 하지만 실습하는 데에 어려움은 없음.
>- https://www.baeldung.com/reflections-library
