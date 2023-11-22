package com.holub.application.presentation;

import java.util.List;

public class Order {
    private final String bread;
    private final String patty;
    private final List<String> toppings;

    public Order(String bread, String patty, List<String> toppings) {
        this.bread = bread;
        this.patty = patty;
        this.toppings = toppings;
    }

    public String getBread() {
        return bread;
    }

    public String getPatty() {
        return patty;
    }

    public List<String> getToppings() {
        return toppings;
    }
}
