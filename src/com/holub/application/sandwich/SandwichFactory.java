package com.holub.application.sandwich;

import com.holub.application.sauce.Chili;
import com.holub.application.sauce.Mustard;
import com.holub.application.sauce.Ranch;
import com.holub.application.topping.Cheese;
import com.holub.application.topping.Ham;
import com.holub.application.topping.Tomato;

public class SandwichFactory {
    public static Sandwich createSandwich(String breadType, String[] ingredients) {
        Sandwich sandwich = getBreadType(breadType);
        for (String ingredient : ingredients) {
            sandwich = addIngredient(sandwich, ingredient);
        }
        return sandwich;
    }

    private static Sandwich getBreadType(String breadType) {
        return switch (breadType) {
            case "wheat" -> new WheatBreadSandwich();
            case "white" -> new WhiteBreadSandwich();
            case "honey_oat" -> new HoneyOatBreadSandwich();
            case "oat" -> new OatBreadSandwich();
            case "flatbread" -> new FlatbreadSandwich();
            default -> throw new IllegalArgumentException("Unknown bread type: " + breadType);
        };
    }

    private static Sandwich addIngredient(Sandwich sandwich, String ingredient) {
        return switch (ingredient) {
            case "mustard" -> new Mustard(sandwich);
            case "chili" -> new Chili(sandwich);
            case "ranch" -> new Ranch(sandwich);
            case "tomato" -> new Tomato(sandwich);
            case "cheese" -> new Cheese(sandwich);
            case "ham" -> new Ham(sandwich);
            default -> throw new IllegalArgumentException("Unknown ingredient: " + ingredient);
        };
    }
}
