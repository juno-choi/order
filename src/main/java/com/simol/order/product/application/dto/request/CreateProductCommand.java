package com.simol.order.product.application.dto.request;

import lombok.Builder;

import java.math.BigDecimal;

@Builder(access = lombok.AccessLevel.PRIVATE)
public record CreateProductCommand(
    String name,
    BigDecimal price,
    Long stock
) {
    public static CreateProductCommand of(final String name, final BigDecimal price, final Long stock) {
        return CreateProductCommand.builder()
            .name(name)
            .price(price)
            .stock(stock)
            .build();
    }
}
