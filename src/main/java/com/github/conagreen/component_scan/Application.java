package com.github.conagreen.component_scan;

import org.reflections.Reflections;
import org.reflections.scanners.*;

import java.util.Set;

public class Application {

    public Set<Class<?>> getClassWithControllerAnnotation() {
        Reflections reflections = new Reflections(
                "com.github.conagreen.component_scan",
                new SubTypesScanner(),
                new TypeAnnotationsScanner());
        return reflections.getTypesAnnotatedWith(Controller.class);
    }

    public Set<Class<?>> getClassWithRepositoryAnnotation() {
        Reflections reflections = new Reflections(
                "com.github.conagreen.component_scan",
                new SubTypesScanner(),
                new TypeAnnotationsScanner());
        return reflections.getTypesAnnotatedWith(Repository.class);
    }

    public Set<Class<?>> getClassWithServiceAnnotation() {
        Reflections reflections = new Reflections(
                "com.github.conagreen.component_scan",
                new SubTypesScanner(),
                new TypeAnnotationsScanner());
        return reflections.getTypesAnnotatedWith(Service.class);
    }


    public static void main(String[] args) {
        Application application = new Application();
        final Set<Class<?>> classWithControllerAnnotation = application.getClassWithControllerAnnotation();
        System.out.println("----------------------------- @Controller -----------------------------");
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
