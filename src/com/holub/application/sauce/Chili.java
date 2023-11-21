package com.holub.application.sauce;

import com.holub.application.constant.SauceType;
import com.holub.application.sandwich.Sandwich;
import com.holub.application.sandwich.SandwichDecorator;
import com.holub.application.service.PriceManager;

public class Chili extends SandwichDecorator {

    public String name = SauceType.CHILI.getName();

    public Chili(Sandwich decoratedSandwich) {
        super(decoratedSandwich);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", with chili";
    }

    @Override
    public double getCost() {
        return super.getCost() + PriceManager.getInstance().getPrice(this.name);
    }
}
