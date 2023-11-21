package com.holub.application.constant;

public enum BeverageType {
    COKE("coke"),
    COFFEE("coffee"),
    TEA("tea");

    private final String name;

    BeverageType(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
