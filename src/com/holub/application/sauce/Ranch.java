package com.holub.application.sauce;

import com.holub.application.sandwich.Sandwich;
import com.holub.application.sandwich.SandwichDecorator;

public class Ranch extends SandwichDecorator {

    public Ranch(Sandwich decoratedSandwich) {
        super(decoratedSandwich);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", with ranch";
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.50;
    }
}
