package com.holub.application.presentation.payment;

import com.holub.application.sandwich.Sandwich;
import java.time.LocalDate;

public class Payment {
    private Sandwich sandwich;
    private double totalPrice;
    private LocalDate paymentDate;

    public Payment(Sandwich sandwich, double totalPrice, LocalDate paymentDate) {
        this.sandwich = sandwich;
        this.totalPrice = totalPrice;
        this.paymentDate = paymentDate;
    }

    @Override
    public String toString() {
        return "<결제 내역>" + "\n"
            + "주문 명: " + sandwich.getDescription() + "\n"
            + "가격: " + totalPrice + "\n"
            + "결제 일자: " + paymentDate + "\n";
    }
}
