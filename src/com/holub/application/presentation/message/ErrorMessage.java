package com.holub.application.presentation.message;

public enum ErrorMessage {
    INVALID_BREAD_TYPE("존재하지 않는 빵의 종류입니다. 다시 골라 주세요."),
    INVALID_SAUCE_TYPE("존재하지 않는 소스의 종류입니다. 다시 골라 주세요."),
    INVALID_TOPPINGS_TYPE("존재하지 않는 토핑의 종류입니다. 다시 골라 주세요."),
    INVALID_BEVERAGE_TYPE("존재하지 않는 음료의 종류입니다. 다시 골라 주세요."),
    INVALID_SELECTION("타당하지 않은 선택입니다. 다시 골라 주세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
