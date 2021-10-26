package com.github.conagreen;

public class Dummy {

    private String name;
    private long value;

    public Dummy(String name, long value) {
        this.name = name;
        this.value = value;
    }

    public Dummy() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }
}
