package com.holub.application;

import com.holub.application.constant.BreadType;
import com.holub.application.constant.SauceType;
import com.holub.application.constant.ToppingType;
import com.holub.application.sandwich.Sandwich;
import com.holub.application.sandwich.SandwichFactory;

public class main {
    public static void main(String[] args) {
        ToppingType[] toppings = {ToppingType.CHEESE, ToppingType.HAM, ToppingType.TOMATO};
        SauceType[] sauces = {SauceType.MUSTARD};
        Sandwich sandwich = SandwichFactory.createSandwich(BreadType.HONEY_OAT, toppings, sauces);
        System.out.println(sandwich.getDescription() + " Cost: $" + sandwich.getCost());
    }
}
