package com.simol.order.product.interfaces.api.dto.request;

import com.simol.order.product.application.dto.request.CreateProductCommand;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record CreateProductRequest(
    @NotNull(message = "name 필수값 입니다")
    String name,
    @NotNull(message = "price 필수값 입니다")
    BigDecimal price,
    @NotNull(message = "stock 필수값 입니다")
    Long stock
) {
    public CreateProductCommand toCommand() {
        return CreateProductCommand.of(name, price, stock);
    }
}
