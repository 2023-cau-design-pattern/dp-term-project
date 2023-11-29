package com.holub.application.constant;

public enum BeverageType {
    COKE("coke"),
    COFFEE("coffee"),
    TEA("tea");

    private final String name;

    BeverageType(String name) {
        this.name = name;
    }

    public static BeverageType[] getBeverageType(String beverage){
        String[] beverage_names = beverage.split(",");
        BeverageType[] beverages = new BeverageType[beverage_names.length];
        for (int i = 0; i < beverage_names.length; i++) {
            for (BeverageType beverageType : BeverageType.values()) {
                if (beverageType.getName().equals(beverage_names[i])) {
                    beverages[i] = beverageType;
                }
            }
        }
        return beverages;
    }

    public String getName() {
        return this.name;
    }
}
