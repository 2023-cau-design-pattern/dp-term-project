package com.holub.application.sandwich;

public class FlatbreadSandwich implements Sandwich {

    @Override
    public String getDescription() {
        return "Flatbread Sandwich";
    }

    @Override
    public double getCost() {
        return 6.50;
    }
}
