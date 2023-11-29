package com.holub.application.sandwich;

import com.holub.application.beverage.Coffee;
import com.holub.application.beverage.Coke;
import com.holub.application.beverage.Tea;
import com.holub.application.constant.BeverageType;
import com.holub.application.constant.BreadType;
import com.holub.application.constant.SauceType;
import com.holub.application.constant.ToppingType;
import com.holub.application.sauce.Chili;
import com.holub.application.sauce.Mustard;
import com.holub.application.sauce.Ranch;
import com.holub.application.topping.Cheese;
import com.holub.application.topping.Ham;
import com.holub.application.topping.Tomato;

public class SandwichFactory {
    public static Sandwich createSandwich(BreadType breadType, ToppingType[] toppings, SauceType[] sauces, BeverageType[] beverages) {
        Sandwich sandwich = getBreadType(breadType);
        for (ToppingType topping: toppings) {
            sandwich = addTopping(sandwich, topping);
        }
        for (SauceType sauce: sauces) {
            sandwich = addSauce(sandwich, sauce);
        }
        for (BeverageType beverage: beverages) {
            sandwich = addBeverage(sandwich, beverage);
        }
        return sandwich;
    }

    private static Sandwich addBeverage(Sandwich sandwich, BeverageType beverage) {
        return switch (beverage) {
            case COKE -> new Coke(sandwich);
            case COFFEE -> new Coffee(sandwich);
            case TEA -> new Tea(sandwich);
        };
    }

    private static Sandwich getBreadType(BreadType breadType) {
        return switch (breadType) {
            case WHEAT -> new WheatBreadSandwich();
            case WHITE -> new WhiteBreadSandwich();
            case HONEY_OAT -> new HoneyOatBreadSandwich();
            case OAT -> new OatBreadSandwich();
            case FLATBREAD -> new FlatbreadSandwich();
        };
    }

    private static Sandwich addTopping(Sandwich sandwich, ToppingType toppingType) {
        return switch (toppingType) {
            case TOMATO -> new Tomato(sandwich);
            case CHEESE -> new Cheese(sandwich);
            case HAM -> new Ham(sandwich);
        };
    }

    private static Sandwich addSauce(Sandwich sandwich, SauceType sauceType) {
        return switch (sauceType) {
            case MUSTARD -> new Mustard(sandwich);
            case CHILI -> new Chili(sandwich);
            case RANCH -> new Ranch(sandwich);
        };
    }
}
