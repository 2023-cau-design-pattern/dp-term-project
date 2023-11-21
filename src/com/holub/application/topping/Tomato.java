package com.holub.application.topping;

import com.holub.application.sandwich.Sandwich;
import com.holub.application.sandwich.SandwichDecorator;
import com.holub.application.service.PriceManager;

public class Tomato extends SandwichDecorator {

    public String name = "tomato";

    public Tomato(Sandwich decoratedSandwich) {
        super(decoratedSandwich);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", with tomato";
    }

    @Override
    public double getCost() {
        return super.getCost() + PriceManager.getInstance().getPrice(this.name);
    }
}

