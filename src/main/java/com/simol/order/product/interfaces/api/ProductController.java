package com.simol.order.product.interfaces.api;

import com.simol.order.product.application.ProductService;
import com.simol.order.product.application.dto.request.CreateProductCommand;
import com.simol.order.product.application.dto.response.ProductResult;
import com.simol.order.product.interfaces.api.dto.request.CreateProductRequest;
import com.simol.order.product.interfaces.api.dto.response.ProductResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ProductResponse createProduct(@RequestBody @Valid final CreateProductRequest request) {
        final CreateProductCommand command = request.toCommand();
        final ProductResult productResult = productService.createProduct(command);
        return ProductResponse.from(productResult);
    }
}
