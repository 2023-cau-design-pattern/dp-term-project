package com.holub.application.constant;

public enum SauceType {
    CHILI("chili"),
    MUSTARD("mustard"),
    RANCH("ranch");

    private final String name;

    SauceType(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
