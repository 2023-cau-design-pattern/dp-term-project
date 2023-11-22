package com.holub.application.presentation.message;

public enum ErrorMessage {
    INVALID_CHOICE("타당하지 않은 선택입니다. 다시 골라 주세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
