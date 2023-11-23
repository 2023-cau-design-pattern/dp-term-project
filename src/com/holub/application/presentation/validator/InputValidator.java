package com.holub.application.presentation.validator;

import com.holub.application.constant.BeverageType;
import com.holub.application.constant.BreadType;
import com.holub.application.constant.SauceType;
import com.holub.application.constant.ToppingType;
import com.holub.application.presentation.message.ErrorMessage;
import java.util.Arrays;
import java.util.List;

public class InputValidator {

    public void validateBreadType(String bread) {
        if(!isValidBread(bread)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BREAD_TYPE.getMessage());
        }
    }

    private boolean isValidBread(String bread) {
        return BreadType.OAT.getName().equals(bread) || BreadType.WHEAT.getName().equals(bread) ||
            BreadType.WHITE.getName().equals(bread) || BreadType.HONEY_OAT.getName().equals(bread) ||
            BreadType.FLATBREAD.getName().equals(bread);
    }

    public void validateSauceType(String sauce) {
        if(!isValidSauce(sauce)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_SAUCE_TYPE.getMessage());
        }
    }

    private boolean isValidSauce(String sauce) {
        return SauceType.CHILI.getName().equals(sauce) || SauceType.MUSTARD.getName().equals(sauce) ||
            SauceType.RANCH.getName().equals(sauce);
    }

    public void validateToppingsType(String toppings) {
        List<String> topping = Arrays.stream(toppings.split(",")).toList();
        if(!isValidToppings(topping)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_TOPPINGS_TYPE.getMessage());
        }
    }

    private boolean isValidToppings(List<String> toppings) {
        return toppings.stream()
            .filter(topping -> !topping.isEmpty())
            .allMatch(topping -> ToppingType.CHEESE.getName().equals(topping) ||
                ToppingType.HAM.getName().equals(topping) ||
                ToppingType.TOMATO.getName().equals(topping));
    }

    public void validateBeverageType(String beverage) {
        if(!isValidBeverage(beverage)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BEVERAGE_TYPE.getMessage());
        }
    }

    private boolean isValidBeverage(String beverage) {
        return BeverageType.COFFEE.getName().equals(beverage) || BeverageType.COKE.getName().equals(beverage) ||
            BeverageType.TEA.getName().equals(beverage);
    }
}
