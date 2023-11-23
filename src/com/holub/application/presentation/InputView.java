package com.holub.application.presentation;

import com.holub.application.presentation.message.ConsoleMessage;
import java.util.Arrays;
import java.util.List;

public class InputView {
    public void greeting() {
        System.out.println(ConsoleMessage.GREETING.getMessage());
    }

    public String readBread() {
        System.out.println(ConsoleMessage.BREAD_SELECTION.getMessage());
        String bread = Console.readLine();

        return bread;
    }

    public String readPatty() {
        System.out.println(ConsoleMessage.PATTY_SELECTION.getMessage());
        String patty = Console.readLine();

        return patty;
    }

    public String readSauce() {
        System.out.println(ConsoleMessage.SAUCE_SELECTION.getMessage());
        String sauce = Console.readLine();

        return sauce;
    }

    public List<String> readToppings() {
        System.out.println(ConsoleMessage.TOPPINGS_SELECTION.getMessage());
        String toppings = Console.readLine();

        return Arrays.stream(toppings.split(",")).toList();
    }

    public String readBeverage() {
        System.out.println(ConsoleMessage.BEVERAGE_SELECTION.getMessage());
        String beverage = Console.readLine();

        return beverage;
    }
}
