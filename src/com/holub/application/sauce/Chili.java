package com.holub.application.sauce;

import com.holub.application.sandwich.Sandwich;
import com.holub.application.sandwich.SandwichDecorator;

public class Chili extends SandwichDecorator {

    public Chili(Sandwich decoratedSandwich) {
        super(decoratedSandwich);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", with chili";
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.45;
    }
}
