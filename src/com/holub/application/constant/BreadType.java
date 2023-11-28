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

    public static BreadType getBreadType(String bread_name) {
        for (BreadType bread : BreadType.values()) {
            if (bread.getName().equals(bread_name)) {
                return bread;
            }
        }
        return null;
    }

    public String getName() {
        return this.name;
    }
}

