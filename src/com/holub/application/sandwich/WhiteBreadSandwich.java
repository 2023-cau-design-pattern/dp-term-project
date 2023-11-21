package com.holub.application.sandwich;

import com.holub.application.service.PriceManager;

public class WhiteBreadSandwich implements Sandwich {

    public String name = "white";

    @Override
    public String getDescription() {
        return "White Bread Sandwich";
    }

    @Override
    public double getCost() {
        return PriceManager.getInstance().getPrice(this.name);
    }
}

