package com.simol.homework.product.repository;

import com.simol.homework.product.model.Product;

import java.util.Map;

public interface ProductRepositoryInit {
    Map<Long, Product> init();
}
