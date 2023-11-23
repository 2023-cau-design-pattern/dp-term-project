package com.holub.application.presentation;

import java.util.List;

public class Order {
    private final String bread;
    private final String patty;
    private final String sauce;
    private final List<String> toppings;
    private final String beverage;

    public Order(String bread, String patty, String sauce, List<String> toppings, String beverage) {
        this.bread = bread;
        this.patty = patty;
        this.sauce = sauce;
        this.toppings = toppings;
        this.beverage = beverage;
    }

    public String getSauce() {
        return sauce;
    }

    public String getBeverage() {
        return beverage;
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
