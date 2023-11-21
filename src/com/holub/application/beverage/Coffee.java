package com.holub.application.beverage;

import com.holub.application.constant.BeverageType;
import com.holub.application.sandwich.Sandwich;
import com.holub.application.sandwich.SandwichDecorator;
import com.holub.application.service.PriceManager;

public class Coffee extends SandwichDecorator {

    public String name = BeverageType.COFFEE.getName();

    public Coffee(Sandwich decoratedSandwich) {
        super(decoratedSandwich);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", with coke";
    }

    @Override
    public double getCost() {
        return super.getCost() + PriceManager.getInstance().getPrice(this.name);
    }
}

