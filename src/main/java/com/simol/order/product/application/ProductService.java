package com.simol.order.product.application;

import com.simol.order.product.application.dto.request.CreateProductCommand;
import com.simol.order.product.application.dto.response.ProductResult;

public interface ProductService {
    ProductResult createProduct(final CreateProductCommand command);
}
