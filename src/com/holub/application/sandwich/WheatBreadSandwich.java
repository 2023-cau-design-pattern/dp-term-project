package com.holub.application.sandwich;

public class WheatBreadSandwich implements Sandwich {

    @Override
    public String getDescription() {
        return "Wheat Bread Sandwich";
    }

    @Override
    public double getCost() {
        return 5.50;
    }
}
