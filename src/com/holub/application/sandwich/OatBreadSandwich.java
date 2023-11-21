package com.holub.application.sandwich;

public class OatBreadSandwich implements Sandwich {

    @Override
    public String getDescription() {
        return "Oat Bread Sandwich";
    }

    @Override
    public double getCost() {
        return 5.75;
    }
}
