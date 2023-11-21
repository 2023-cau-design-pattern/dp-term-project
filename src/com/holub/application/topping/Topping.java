package com.holub.application.topping;

import com.holub.application.sandwich.Sandwich;
import com.holub.application.sandwich.SandwichDecorator;

class Topping extends SandwichDecorator {
    public Topping(Sandwich decoratedSandwich) {
        super(decoratedSandwich);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", with topping";
    }

    @Override
    public double getCost() {
        return super.getCost() + 1.00;
    }
}
