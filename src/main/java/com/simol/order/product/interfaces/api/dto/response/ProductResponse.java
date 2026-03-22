package com.simol.order.product.interfaces.api.dto.response;

import com.simol.order.product.application.dto.response.ProductResult;
import lombok.Builder;

import java.math.BigDecimal;

@Builder(access = lombok.AccessLevel.PRIVATE)
public record ProductResponse(
    Long id,
    String name,
    BigDecimal price,
    Long stock
) {
    public static ProductResponse from(final ProductResult productResult) {
        return ProductResponse.builder()
            .id(productResult.id())
            .name(productResult.name())
            .price(productResult.price())
            .stock(productResult.stock())
            .build();
    }
}
