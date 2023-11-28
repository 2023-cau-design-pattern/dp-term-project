package com.holub.application.presentation;

import com.holub.application.presentation.message.ConsoleMessage;
import com.holub.application.presentation.validator.InputValidator;
import java.util.Arrays;
import java.util.List;

public class InputView {
    private final InputValidator inputValidator = new InputValidator();
    public void greeting() {
        System.out.println(ConsoleMessage.GREETING.getMessage());
    }

    public String readBread() {
        while (true) {
            System.out.println(ConsoleMessage.BREAD_TYPE.getMessage());
            System.out.println(ConsoleMessage.BREAD_SELECTION.getMessage());
            String bread = Console.readLine();

            try {
                inputValidator.validateBreadType(bread);
                return bread;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String readSauce() {
        while (true) {
            System.out.println(ConsoleMessage.SAUCE_TYPE.getMessage());
            System.out.println(ConsoleMessage.SAUCE_SELECTION.getMessage());
            String sauce = Console.readLine();

            try {
                inputValidator.validateSauceType(sauce);
                return sauce;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<String> readToppings() {
        while (true) {
            System.out.println(ConsoleMessage.TOPPINGS_TYPE.getMessage());
            System.out.println(ConsoleMessage.TOPPINGS_SELECTION.getMessage());
            String toppings = Console.readLine();

            try {
                inputValidator.validateToppingsType(toppings);
                return Arrays.stream(toppings.split(",")).toList();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String readBeverage() {
        while (true) {
            System.out.println(ConsoleMessage.BEVERAGE_TYPE.getMessage());
            System.out.println(ConsoleMessage.BEVERAGE_SELECTION.getMessage());
            String beverage = Console.readLine();

            try {
                inputValidator.validateBeverageType(beverage);
                return beverage;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String readPayment() {
        while (true) {
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
