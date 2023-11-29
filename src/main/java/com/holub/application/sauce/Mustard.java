package com.holub.application.sauce;

import com.holub.application.constant.SauceType;
import com.holub.application.sandwich.Sandwich;
import com.holub.application.sandwich.SandwichDecorator;
import com.holub.application.service.PriceManager;

// 소스 데코레이터
public class Mustard extends SandwichDecorator {

    public String name = SauceType.MUSTARD.getName();

    public Mustard(Sandwich decoratedSandwich) {
        super(decoratedSandwich);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", with mustard";
    }

    @Override
    public double getCost() {
        return super.getCost() + PriceManager.getInstance().getPrice(this.name);
    }
}
