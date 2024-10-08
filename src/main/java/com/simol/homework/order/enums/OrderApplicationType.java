package com.simol.homework.order.enums;

public enum OrderApplicationType {
    ORDER("주문"),
    QUITE("주문종료"),
    WRONG_REQUEST("잘못된 입력"),
    ;
    private final String description;

    OrderApplicationType(String description) {
        this.description = description;
    }

    public static OrderApplicationType getTypeByUserInput(String input) {
        if ("q".equals(input) || "quite".equals(input)) {
            return QUITE;
        }
        if ("o".equals(input) || "order".equals(input)) {
            return ORDER;
        }
        return WRONG_REQUEST;
    }
}
