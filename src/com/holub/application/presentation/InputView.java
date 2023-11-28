package com.holub.application.presentation;

import com.holub.application.constant.BeverageType;
import com.holub.application.constant.BreadType;
import com.holub.application.constant.SauceType;
import com.holub.application.constant.ToppingType;
import com.holub.application.presentation.message.ConsoleMessage;
import com.holub.application.presentation.validator.InputValidator;
import java.util.Arrays;
import java.util.List;

public class InputView {
    private final InputValidator inputValidator = new InputValidator();
    public void greeting() {
        System.out.println(ConsoleMessage.GREETING.getMessage());
    }

    public BreadType readBread() {
        while (true) {
            System.out.println();
            System.out.println(ConsoleMessage.BREAD_TYPE.getMessage());
            System.out.println(ConsoleMessage.BREAD_SELECTION.getMessage());
            String bread = Console.readLine();

            try {
                inputValidator.validateBreadType(bread);
                return BreadType.getBreadType(bread);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public SauceType[] readSauce() {
        while (true) {
            System.out.println();
            System.out.println(ConsoleMessage.SAUCE_TYPE.getMessage());
            System.out.println(ConsoleMessage.SAUCE_SELECTION.getMessage());
            String sauce = Console.readLine();


            try {
                inputValidator.validateSauceType(sauce);
                return SauceType.getSauceType(sauce);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public ToppingType[] readToppings() {
        while (true) {
            System.out.println();
            System.out.println(ConsoleMessage.TOPPINGS_TYPE.getMessage());
            System.out.println(ConsoleMessage.TOPPINGS_SELECTION.getMessage());
            String toppings = Console.readLine();

            try {
                inputValidator.validateToppingsType(toppings);
                return ToppingType.getToppings(toppings);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public BeverageType[] readBeverage() {
        while (true) {
            System.out.println();
            System.out.println(ConsoleMessage.BEVERAGE_TYPE.getMessage());
            System.out.println(ConsoleMessage.BEVERAGE_SELECTION.getMessage());
            String beverage = Console.readLine();

            try {
                inputValidator.validateBeverageType(beverage);
                return BeverageType.getBeverageType(beverage);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String readPayment() {
        while (true) {
            System.out.println();
            System.out.println(ConsoleMessage.PAYMENT_TYPE.getMessage());
            System.out.println(ConsoleMessage.REQUEST_PAYMENT.getMessage());
            String input = Console.readLine();

            try {
                inputValidator.validatePaymentMethod(input);
                return input;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
