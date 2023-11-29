package com.holub.application.sandwich;

// BasicSandwich 클래스
class BasicSandwich implements Sandwich {

    @Override
    public String getDescription() {
        return "Basic Sandwich";
    }

    @Override
    public double getCost() {
        return 5.00;
    }
}
