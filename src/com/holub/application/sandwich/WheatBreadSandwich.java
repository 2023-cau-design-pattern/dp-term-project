package com.holub.application.sandwich;

import com.holub.application.service.PriceManager;

public class WheatBreadSandwich implements Sandwich {

    public String name = "wheat";

    @Override
    public String getDescription() {
        return "Wheat Bread Sandwich";
    }

    @Override
    public double getCost() {
        return PriceManager.getInstance().getPrice(this.name);
    }
}
