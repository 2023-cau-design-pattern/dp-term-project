package com.holub.application;

import com.holub.application.presentation.ConsoleController;
import com.holub.application.presentation.Order;
import com.holub.application.presentation.payment.Payment;
import com.holub.application.sandwich.Sandwich;
import com.holub.application.sandwich.SandwichFactory;
import com.holub.application.setting.SetUp;

import java.time.LocalDate;

public class SandwichMachine {
    public static void run(ConsoleController consoleController) {
        Order order = consoleController.readOrder();
        Sandwich sandwich = SandwichFactory.createSandwich(order.getBread(), order.getToppings(), order.getSauce(), order.getBeverage());
        Payment payment = new Payment(sandwich, sandwich.getCost(), LocalDate.now());
        SetUp setup = new SetUp();
        consoleController.payment(payment);
        setup.order.insert(new Object[]{sandwich.getDescription(), sandwich.getCost(), LocalDate.now()});
    }
}
