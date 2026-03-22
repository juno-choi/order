package com.simol.order.common.exception.dto;

import lombok.Builder;

@Builder(access = lombok.AccessLevel.PRIVATE)
public record ErrorResponse (
    String code,
    String message
) {
    public static ErrorResponse of(final String errorCode, final String message) {
        return ErrorResponse.builder()
            .code(errorCode)
            .message(message)
            .build();
    }
}
