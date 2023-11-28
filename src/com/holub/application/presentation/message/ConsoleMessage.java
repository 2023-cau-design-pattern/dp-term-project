package com.holub.application.presentation.message;

import com.holub.application.constant.BeverageType;
import com.holub.application.constant.BreadType;
import com.holub.application.constant.SauceType;
import com.holub.application.constant.ToppingType;
import com.holub.application.presentation.payment.PaymentMethod;

public enum ConsoleMessage {
    GREETING("xx 샌드위치입니다."),
    BREAD_TYPE(BreadType.WHEAT.getName() + ", " + BreadType.WHITE.getName() + ", " + BreadType.HONEY_OAT.getName() +
        ", " + BreadType.OAT.getName() + ", " + BreadType.FLATBREAD.getName()),
    BREAD_SELECTION("빵의 종류를 선택해주세요. "),
    SAUCE_TYPE(SauceType.CHILI.getName() + ", " + SauceType.MUSTARD.getName() + ", " + SauceType.RANCH.getName()),
    SAUCE_SELECTION("소스의 종류를 선택해주세요."),
    TOPPINGS_TYPE(ToppingType.CHEESE.getName() + ", " + ToppingType.HAM.getName() + ", " + ToppingType.TOMATO.getName()),
    TOPPINGS_SELECTION("토핑의 종류를 선택해주세요. (예시 - cheese,ham)"),
    BEVERAGE_TYPE(BeverageType.COFFEE.getName() + ", " + BeverageType.COKE.getName() + ", " + BeverageType.TEA.getName()),
    BEVERAGE_SELECTION("음료의 종류를 선택해주세요."),
    ASK_FOR_CHANGE("선택한 메뉴에 수정하고 싶은 카테고리가 있나요? (빵/소스/토핑/음료/없음)"),
    PAYMENT_TYPE(PaymentMethod.CREDIT_CARD.getMethod() + "로 결제해주세요"),
    REQUEST_PAYMENT("결제하시겠습니까? (y/n)"),
    CREDIT_CARD_PAYMENT("신용카드를 투입구에 끝까지 넣어주세요."),
    CREDIT_CARD_PROCESSING("결제 처리중입니다."),
    RESULT_MESSAGE("주문이 성공적으로 진행되었습니다."),
    ENDING("이용해주셔서 감사합니다.");

    private final String message;

    ConsoleMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
