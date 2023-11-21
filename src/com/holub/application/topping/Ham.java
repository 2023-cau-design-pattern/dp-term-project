package com.holub.application.topping;

import com.holub.application.sandwich.Sandwich;
import com.holub.application.sandwich.SandwichDecorator;
import com.holub.application.service.PriceManager;

public class Ham extends SandwichDecorator {

    public String name = "ham";

    public Ham(Sandwich decoratedSandwich) {
        super(decoratedSandwich);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", with ham";
    }

    @Override
    public double getCost() {
        return super.getCost() + PriceManager.getInstance().getPrice(this.name);
    }
}
