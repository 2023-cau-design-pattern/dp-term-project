package com.holub.application.sandwich;

// SandwichDecorator 추상 클래스
public abstract class SandwichDecorator implements Sandwich {

    protected Sandwich decoratedSandwich;

    public SandwichDecorator(Sandwich decoratedSandwich) {
        this.decoratedSandwich = decoratedSandwich;
    }

    @Override
    public String getDescription() {
        return decoratedSandwich.getDescription();
    }

    @Override
    public double getCost() {
        return decoratedSandwich.getCost();
    }
}
