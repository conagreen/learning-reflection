package com.github.conagreen;

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
