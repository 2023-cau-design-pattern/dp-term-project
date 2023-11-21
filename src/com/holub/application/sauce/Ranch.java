package com.holub.application.sauce;

import com.holub.application.sandwich.Sandwich;
import com.holub.application.sandwich.SandwichDecorator;
import com.holub.application.service.PriceManager;

public class Ranch extends SandwichDecorator {

    public String name = "ranch";

    public Ranch(Sandwich decoratedSandwich) {
        super(decoratedSandwich);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", with ranch";
    }

    @Override
    public double getCost() {
        return super.getCost() + PriceManager.getInstance().getPrice(this.name);
    }
}
