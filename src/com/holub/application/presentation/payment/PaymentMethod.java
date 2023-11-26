package com.holub.application.presentation.payment;

public enum PaymentMethod {
    CASH("cash"),
    CREDIT_CARD("credit_card");
    private final String method;

    PaymentMethod(String method) {
        this.method = method;
    }

    public String getMethod() {
        return method;
    }
}
