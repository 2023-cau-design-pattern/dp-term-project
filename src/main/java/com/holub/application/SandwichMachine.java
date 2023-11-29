package com.holub.application;

import com.holub.application.presentation.ConsoleController;
import com.holub.application.presentation.Order;
import com.holub.application.presentation.payment.Payment;
import com.holub.application.sandwich.Sandwich;
import com.holub.application.sandwich.SandwichFactory;
import com.holub.application.service.OrderService;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class SandwichMachine {
    private static final OrderService orderService = OrderService.getInstance();

    public static void run(ConsoleController consoleController) {
        Order order = consoleController.readOrder();
        Sandwich sandwich = SandwichFactory.createSandwich(order.getBread(), order.getToppings(), order.getSauce(), order.getBeverage());
        Payment payment = new Payment(sandwich, sandwich.getCost(), LocalDate.now());
        consoleController.payment(payment);
        orderService.insert(sandwich.getDescription(), sandwich.getCost(), LocalDateTime.now().toString());
    }

    public static void showOrder() {
        String result = orderService.selectOrderBy("totalPrice");
        System.out.println(result);
    }
}
