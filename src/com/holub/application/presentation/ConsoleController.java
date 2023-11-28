package com.holub.application.presentation;

import com.holub.application.constant.BeverageType;
import com.holub.application.constant.BreadType;
import com.holub.application.constant.SauceType;
import com.holub.application.constant.ToppingType;
import com.holub.application.presentation.message.ConsoleMessage;
import com.holub.application.presentation.payment.Payment;
import java.util.Arrays;
import java.util.List;

public class ConsoleController {
    private static final String OPTION_BREAD = "빵";
    private static final String OPTION_SAUCE = "소스";
    private static final String OPTION_TOPPINGS = "토핑";
    private static final String OPTION_BEVERAGE = "음료";
    private static final String OPTION_NONE = "없음";
    private final InputView inputView = new InputView();

    public void payment(Payment payment) {
        String input = inputView.readPayment();
        if (input.equals("y")) {
            System.out.println(ConsoleMessage.CREDIT_CARD_PAYMENT.getMessage());
            System.out.println(ConsoleMessage.CREDIT_CARD_PROCESSING.getMessage());

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println(payment.toString());
            System.out.println(ConsoleMessage.RESULT_MESSAGE.getMessage());
        }
        System.out.println(ConsoleMessage.ENDING.getMessage());
    }

    public Order readOrder() {
        inputView.greeting();

        BreadType bread = null;
        SauceType[] sauce = null;
        ToppingType[] toppings = null;
        BeverageType[] beverage = null;

        while (true) {
            bread = chooseBread(bread);
            sauce = chooseSauce(sauce);
            toppings = chooseToppings(toppings);
            beverage = chooseBeverage(beverage);

            String modificationChoice = askForModification();
            showCurrentChoice(bread, sauce, toppings, beverage);
            if (modificationChoice.equals(OPTION_NONE)) {
                return new Order(bread, sauce, toppings, beverage);
            }
            else if (modificationChoice.equals(OPTION_BREAD)) {
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
    private BreadType chooseBread(BreadType bread) {
        if (bread == null) {
            return inputView.readBread();
        }
        return bread;
    }
    private SauceType[] chooseSauce(SauceType[] sauce) {
        if (sauce == null) {
            return inputView.readSauce();
        }
        return sauce;
    }
    private ToppingType[] chooseToppings(ToppingType[] toppings) {
        if (toppings == null) {
            return inputView.readToppings();
        }
        return toppings;
    }

    private BeverageType[] chooseBeverage(BeverageType[] beverage) {
        if (beverage == null) {
            return inputView.readBeverage();
        }
        return beverage;
    }

    private void showCurrentChoice(BreadType bread, SauceType[] sauce, ToppingType[] toppings, BeverageType[] beverage) {
        String breadName = bread == null ? OPTION_NONE : bread.getName();
        String sauceName = sauce == null ? OPTION_NONE : String.join(", ", Arrays.stream(sauce).map(SauceType::getName).toArray(String[]::new));
        String toppingsName = toppings == null ? OPTION_NONE : String.join(", ", Arrays.stream(toppings).map(ToppingType::getName).toArray(String[]::new));
        String beverageName = beverage == null ? OPTION_NONE : String.join(", ", Arrays.stream(beverage).map(BeverageType::getName).toArray(String[]::new));

        System.out.println("현재 선택하신 메뉴: 빵 - " + breadName + ", 소스 - " + sauceName + ", 토핑 - " + toppingsName + ", 음료 - " + beverageName);
    }

    private String askForModification() {
        System.out.println();
        System.out.println(ConsoleMessage.ASK_FOR_CHANGE.getMessage());
        String choice = Console.readLine();

        return choice;
    }
}
