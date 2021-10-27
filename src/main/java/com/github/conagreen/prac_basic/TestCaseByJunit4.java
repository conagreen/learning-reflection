package com.github.conagreen.prac_basic;

import com.github.conagreen.prac_basic.RunTest;

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
