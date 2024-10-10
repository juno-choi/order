package com.simol.homework.product.service;

import com.simol.homework.product.model.Product;
import com.simol.homework.product.repository.ProductRepository;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getProductList() {
        return productRepository.findAllOrderByProductIdDesc();
    }
}
