package com.holub.application.presentation.payment;

public enum PaymentMethod {
    CREDIT_CARD("신용카드");
    private final String method;

    PaymentMethod(String method) {
        this.method = method;
    }

    public String getMethod() {
        return method;
    }
}
