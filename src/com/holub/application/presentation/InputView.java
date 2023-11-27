package com.holub.application.presentation;

import com.holub.application.presentation.message.ConsoleMessage;
import com.holub.application.presentation.payment.Payment;
import com.holub.application.presentation.payment.PaymentMethod;
import com.holub.application.presentation.validator.InputValidator;
import java.time.LocalDate;
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

    public Payment readPayment(double totalPrice) {
        while (true) {
            System.out.println(ConsoleMessage.PAYMENT_TYPE.getMessage());
            System.out.println(ConsoleMessage.PAYMENT_SELECTION.getMessage());
            String methodInput = Console.readLine();

            try {
                inputValidator.validatePaymentMethod(methodInput);

                PaymentMethod method = Arrays.stream(PaymentMethod.values())
                    .filter(m -> m.getMethod().equals(methodInput))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Invalid payment method"));

                if (PaymentMethod.CASH.equals(method)) {
                    System.out.println(totalPrice + ConsoleMessage.CASH_PAYMENT.getMessage());
                }
                else {
                    System.out.println(ConsoleMessage.CREDIT_CARD_PAYMENT.getMessage());
                    System.out.println(ConsoleMessage.CREDIT_CARD_PROCESSING.getMessage());

                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        System.out.println("An interruption occurred during payment processing.");
                    }
                }
                System.out.println(ConsoleMessage.RESULT_MESSAGE.getMessage());
                return new Payment(method, totalPrice, LocalDate.now());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
