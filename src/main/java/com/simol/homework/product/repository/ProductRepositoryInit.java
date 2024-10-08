package com.simol.homework.product.repository;

import com.simol.homework.product.entity.Product;

import java.util.Map;

public interface ProductRepositoryInit {
    Map<Long, Product> init();
}
