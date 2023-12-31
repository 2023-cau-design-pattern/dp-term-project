package com.holub.application.sandwich;

import com.holub.application.constant.BreadType;
import com.holub.application.service.PriceManager;

public class FlatbreadSandwich implements Sandwich {

    public String name = BreadType.FLATBREAD.getName();

    @Override
    public String getDescription() {
        return "Flatbread Sandwich";
    }

    @Override
    public double getCost() {
        return PriceManager.getInstance().getPrice(this.name);
    }
}
