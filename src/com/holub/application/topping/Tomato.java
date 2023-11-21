package com.holub.application.topping;

import com.holub.application.sandwich.Sandwich;
import com.holub.application.sandwich.SandwichDecorator;

public class Tomato extends SandwichDecorator {
    public Tomato(Sandwich decoratedSandwich) {
        super(decoratedSandwich);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", with tomato";
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.25;
    }
}

