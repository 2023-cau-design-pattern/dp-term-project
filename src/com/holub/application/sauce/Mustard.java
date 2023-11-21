package com.holub.application.sauce;

import com.holub.application.sandwich.Sandwich;
import com.holub.application.sandwich.SandwichDecorator;

// 소스 데코레이터
public class Mustard extends SandwichDecorator {

    public Mustard(Sandwich decoratedSandwich) {
        super(decoratedSandwich);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", with mustard";
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.30;
    }
}
