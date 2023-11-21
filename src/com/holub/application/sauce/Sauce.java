package com.holub.application.sauce;

import com.holub.application.sandwich.Sandwich;
import com.holub.application.sandwich.SandwichDecorator;

// 구체적인 데코레이터 클래스들
public class Sauce extends SandwichDecorator {

    public Sauce(Sandwich decoratedSandwich) {
        super(decoratedSandwich);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", with extra sauce";
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.50;
    }
}
