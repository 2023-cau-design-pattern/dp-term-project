package com.holub.application.constant;

public enum ToppingType {
    CHEESE("cheese"),
    HAM("ham"),
    TOMATO("tomato");

    private final String name;

    ToppingType(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
