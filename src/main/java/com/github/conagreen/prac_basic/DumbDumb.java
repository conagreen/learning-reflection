package com.github.conagreen.prac_basic;

public class DumbDumb {

    private String name;
    private long amount;

    public DumbDumb() {
    }

    // 요걸로 생성하기
    public DumbDumb(String name, long amount) {
        this.name = name;
        this.amount = amount;
    }

    public DumbDumb(String name) {
        this.name = name;
    }

    public DumbDumb(long amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public long getAmount() {
        return amount;
    }
}
