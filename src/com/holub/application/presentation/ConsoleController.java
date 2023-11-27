package com.holub.application.presentation;

import com.holub.application.presentation.message.ConsoleMessage;
import com.holub.application.presentation.payment.Payment;
import java.util.List;

public class ConsoleController {
    private static final String OPTION_BREAD = "빵";
    private static final String OPTION_SAUCE = "소스";
    private static final String OPTION_TOPPINGS = "토핑";
    private static final String OPTION_BEVERAGE = "음료";
    private static final String OPTION_NONE = "없음";
    private final InputView inputView = new InputView();

    public Payment readPayment(double totalPrice) {
        return inputView.readPayment(totalPrice);
    }

    public Order readOrder() {
        inputView.greeting();

        String bread = null;
        String sauce = null;
        List<String> toppings = null;
        String beverage = null;

        while (true) {
            bread = chooseBread(bread);
            sauce = chooseSauce(sauce);
            toppings = chooseToppings(toppings);
            beverage = chooseBeverage(beverage);

            String modificationChoice = askForModification();
            if (modificationChoice.equals(OPTION_NONE)) {
                return new Order(bread, sauce, toppings, beverage);
            }
            showCurrentChoice(bread, sauce, toppings, beverage);

            if (modificationChoice.equals(OPTION_BREAD)) {
                bread = null;
            }
            else if (modificationChoice.equals(OPTION_SAUCE)) {
                sauce = null;
            }
            else if (modificationChoice.equals(OPTION_TOPPINGS)) {
                toppings = null;
            }
            else if (modificationChoice.equals(OPTION_BEVERAGE)) {
                beverage = null;
            }
        }
    }
    private String chooseBread(String bread) {
        if (bread == null) {
            return inputView.readBread();
        }
        return bread;
    }
    private String chooseSauce(String sauce) {
        if (sauce == null) {
            return inputView.readSauce();
        }
        return sauce;
    }
    private List<String> chooseToppings(List<String> toppings) {
        if (toppings == null) {
            return inputView.readToppings();
        }
        return toppings;
    }

    private String chooseBeverage(String beverage) {
        if (beverage == null) {
            return inputView.readBeverage();
        }
        return beverage;
    }

    private void showCurrentChoice(String bread, String sauce, List<String> toppings, String beverage) {
        System.out.println("현재 선택하신 메뉴: 빵 - " + bread + ", 소스 - " + sauce + ", 토핑 - " + String.join(", ", toppings) + ", 음료 - " + beverage);
    }

    private String askForModification() {
        System.out.println(ConsoleMessage.ASK_FOR_CHANGE.getMessage());
        String choice = Console.readLine();

        return choice;
    }
}
