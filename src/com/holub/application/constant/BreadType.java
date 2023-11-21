package com.holub.application.constant;

public enum BreadType {
    WHEAT("wheat"),
    WHITE("white"),
    HONEY_OAT("honey_oat"),
    OAT("oat"),
    FLATBREAD("flatbread");

    private final String name;

    BreadType(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}

