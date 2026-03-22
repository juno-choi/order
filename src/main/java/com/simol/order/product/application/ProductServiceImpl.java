package com.simol.order.product.application;

import com.simol.order.product.application.dto.request.CreateProductCommand;
import com.simol.order.product.application.dto.response.ProductResult;
import com.simol.order.product.domain.Product;
import com.simol.order.product.infrastructure.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Transactional
    @Override
    public ProductResult createProduct(final CreateProductCommand command) {
        final Product product = Product.of(command.name(), command.price(), command.stock());
        productRepository.save(product);
        return ProductResult.of(product);
    }
}
