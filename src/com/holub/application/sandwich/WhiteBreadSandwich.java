package com.holub.application.sandwich;

public class WhiteBreadSandwich implements Sandwich {
    @Override
    public String getDescription() {
        return "White Bread Sandwich";
    }

    @Override
    public double getCost() {
        return 5.00;
    }
}

