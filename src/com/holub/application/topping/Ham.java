package com.holub.application.topping;

import com.holub.application.sandwich.Sandwich;
import com.holub.application.sandwich.SandwichDecorator;

public class Ham extends SandwichDecorator {

    public Ham(Sandwich decoratedSandwich) {
        super(decoratedSandwich);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", with ham";
    }

    @Override
    public double getCost() {
        return super.getCost() + 1.00;
    }
}
