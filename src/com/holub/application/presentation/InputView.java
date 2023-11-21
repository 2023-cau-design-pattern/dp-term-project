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

    public List<String> readToppings() {
        System.out.println(ConsoleMessage.TOPPINGS_SELECTION.getMessage());
        String toppings = Console.readLine();

        return Arrays.stream(toppings.split(",")).toList();
    }
}
