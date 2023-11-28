package com.holub.application;

import com.holub.application.presentation.ConsoleController;

public class main {
    public static void main(String[] args) {
        // DB init


        // Controller init
        ConsoleController consoleController = new ConsoleController();

        // Run

        SandwichMachine.run(consoleController);
    }
}