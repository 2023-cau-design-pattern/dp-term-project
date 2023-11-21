package com.holub.application.topping;

import com.holub.application.sandwich.Sandwich;
import com.holub.application.sandwich.SandwichDecorator;

public class Cheese extends SandwichDecorator {

    public Cheese(Sandwich decoratedSandwich) {
        super(decoratedSandwich);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", with cheese";
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.75;
    }
}
