package com.holub.application.sandwich;

import com.holub.application.service.PriceManager;

public class HoneyOatBreadSandwich implements Sandwich {
    String name = "honey_oat";

    @Override
    public String getDescription() {
        return "Honey Oat Bread Sandwich";
    }

    @Override
    public double getCost() {
        return PriceManager.getInstance().getPrice(this.name);
    }
}
