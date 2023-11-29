package com.holub.application.constant;

public enum ToppingType {
    CHEESE("cheese"),
    HAM("ham"),
    TOMATO("tomato");

    private final String name;

    ToppingType(String name) {
        this.name = name;
    }

    public static ToppingType[] getToppings(String toppings){
        String[] topping_names = toppings.split(",");
        ToppingType[] topping = new ToppingType[topping_names.length];
        for (int i = 0; i < topping_names.length; i++) {
            for (ToppingType toppingType : ToppingType.values()) {
                if (toppingType.getName().equals(topping_names[i])) {
                    topping[i] = toppingType;
                }
            }
        }
        return topping;
    }

    public String getName() {
        return this.name;
    }
}
