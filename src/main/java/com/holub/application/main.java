package com.holub.application;

import com.holub.application.presentation.Console;
import com.holub.application.presentation.ConsoleController;

public class main {

    public static void main(String[] args) {
        // Controller init
        ConsoleController consoleController = new ConsoleController();

        // Run
        while (true) {
            System.out.println("1. 주문하기, 2. 주문내역 보기, 3. 종료");
            String choice = Console.readLine();
            if (choice.equals("1")) {
                SandwichMachine.run(consoleController);
            } else if (choice.equals("2")) {
                SandwichMachine.showOrder();
            } else if (choice.equals("3")) {
                break;
            } else {
                System.out.println("잘못된 입력입니다.");
            }
        }
    }
}