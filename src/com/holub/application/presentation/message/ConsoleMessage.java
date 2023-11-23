package com.holub.application.presentation.message;

public enum ConsoleMessage {
    GREETING("xx 햄버거입니다."),
    BREAD_SELECTION("빵의 종류를 선택해주세요."),
    PATTY_SELECTION("패티의 종류를 선택해주세요."),
    SAUCE_SELECTION("소스의 종류를 선택해주세요."),
    TOPPINGS_SELECTION("토핑의 종류를 선택해주세요."),
    BEVERAGE_SELECTION("음료의 종류를 선택해주세요."),
    ASK_FOR_CHANGE("선택한 메뉴에 수정하고 싶은 카테고리가 있나요? (빵/패티/소스/토핑/음료/없음)");
    
    private final String message;

    ConsoleMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
