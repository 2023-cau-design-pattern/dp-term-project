package com.holub.application.presentation.payment;

import java.time.LocalDate;

public class Payment {
    private PaymentMethod method;
    private double totalPrice;
    private LocalDate paymentDate;

    public Payment(PaymentMethod method, double totalPrice, LocalDate paymentDate) {
        this.method = method;
        this.totalPrice = totalPrice;
        this.paymentDate = paymentDate;
    }
}
