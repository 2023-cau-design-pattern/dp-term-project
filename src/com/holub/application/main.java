package com.holub.application;

import com.holub.application.sandwich.Sandwich;
import com.holub.application.sandwich.SandwichFactory;

public class main {
    public static void main(String[] args) {
        String[] ingredients = {"mustard", "tomato", "ham"};
        Sandwich sandwich = SandwichFactory.createSandwich("honey_oat", ingredients);
        System.out.println(sandwich.getDescription() + " Cost: $" + sandwich.getCost());
    }
}
