package com.holub.application.sandwich;

public class HoneyOatBreadSandwich implements Sandwich {

    @Override
    public String getDescription() {
        return "Honey Oat Bread Sandwich";
    }

    @Override
    public double getCost() {
        return 6.00;
    }
}
