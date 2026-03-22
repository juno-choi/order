package com.simol.order.product.application.dto.response;

import com.simol.order.product.domain.Product;
import lombok.Builder;

import java.math.BigDecimal;

@Builder(access = lombok.AccessLevel.PRIVATE)
public record ProductResult(
    Long id,
    String name,
    BigDecimal price,
    Long stock
) {
    public static ProductResult of(final Product product) {
        return ProductResult.builder()
            .id(product.getId())
            .name(product.getName())
            .price(product.getPrice())
            .stock(product.getStock())
            .build();
    }
}
