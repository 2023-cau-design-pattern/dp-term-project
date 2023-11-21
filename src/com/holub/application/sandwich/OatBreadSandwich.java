package com.holub.application.sandwich;

import com.holub.application.service.PriceManager;

public class OatBreadSandwich implements Sandwich {

    public String name = "oat";

    @Override
    public String getDescription() {
        return "Oat Bread Sandwich";
    }

    @Override
    public double getCost() {
        return PriceManager.getInstance().getPrice(this.name);
    }
}
