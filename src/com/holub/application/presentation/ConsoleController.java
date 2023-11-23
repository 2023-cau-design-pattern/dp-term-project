package com.holub.application.presentation;

import com.holub.application.presentation.message.ConsoleMessage;
import com.holub.application.presentation.message.ErrorMessage;
import java.util.List;

public class ConsoleController {
    private static final String OPTION_BREAD = "빵";
    private static final String OPTION_PATTY = "패티";
    private static final String OPTION_SAUCE = "소스";
    private static final String OPTION_TOPPINGS = "토핑";
    private static final String OPTION_BEVERAGE = "음료";
    private static final String OPTION_NONE = "없음";
    private final InputView inputView = new InputView();
    private Order order;

    public Order readOrder() {
        inputView.greeting();

        String bread = null;
        String patty = null;
        String sauce = null;
        List<String> toppings = null;
        String beverage = null;

        while (true) {
            bread = chooseBread(bread);
            patty = choosePatty(patty);
            sauce = chooseSauce(sauce);
            toppings = chooseToppings(toppings);
            beverage = chooseBeverage(beverage);

            String modificationChoice = askForModification();
            if (modificationChoice.equals(OPTION_NONE)) {
                return new Order(bread, patty, sauce, toppings, beverage);
            }
            showCurrentChoice(bread, patty, toppings);

            if (modificationChoice.equals(OPTION_BREAD)) {
                bread = null;
            }
            else if (modificationChoice.equals(OPTION_PATTY)) {
                patty = null;
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

    private String choosePatty(String patty) {
        if (patty == null) {
            return inputView.readPatty();
        }
        return patty;
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

    private void showCurrentChoice(String bread, String patty, List<String> toppings) {
        System.out.println("현재 선택하신 메뉴: 빵 - " + bread + ", 패티 - " + patty + ", 토핑 - " + String.join(", ", toppings));
    }

    private String askForModification() {
        System.out.println(ConsoleMessage.ASK_FOR_CHANGE.getMessage());
        String choice = Console.readLine();

        return choice;
    }
}
