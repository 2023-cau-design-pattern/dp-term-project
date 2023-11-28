package com.holub.application.presentation;

import com.holub.application.constant.BeverageType;
import com.holub.application.constant.BreadType;
import com.holub.application.constant.SauceType;
import com.holub.application.constant.ToppingType;
import java.util.List;

public class Order {
    private final BreadType bread;
    private final SauceType[] sauce;
    private final ToppingType[] toppings;
    private final BeverageType[] beverage;

    public Order(BreadType bread, SauceType[] sauce, ToppingType[] toppings, BeverageType[] beverage) {
        this.bread = bread;
        this.sauce = sauce;
        this.toppings = toppings;
        this.beverage = beverage;
    }

    public SauceType[] getSauce() {
        return sauce;
    }

    public BeverageType[] getBeverage() {
        return beverage;
    }

    public BreadType getBread() {
        return bread;
    }

    public ToppingType[] getToppings() {
        return toppings;
    }
}
