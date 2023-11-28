package com.holub.application;

import com.holub.application.presentation.ConsoleController;
import com.holub.application.presentation.Order;
import com.holub.application.presentation.payment.Payment;
import com.holub.application.sandwich.Sandwich;
import com.holub.application.sandwich.SandwichFactory;
import java.time.LocalDate;

public class SandwichMachine {
    public static void run(ConsoleController consoleController) {
        Order order = consoleController.readOrder();
        Sandwich sandwich = SandwichFactory.createSandwich(order.getBread(), order.getToppings(), order.getSauce(), order.getBeverage());
        Payment payment = new Payment(sandwich, sandwich.getCost(), LocalDate.now());
        consoleController.payment(payment);
    }
}
