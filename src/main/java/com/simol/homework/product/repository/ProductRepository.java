package com.simol.homework.product.repository;

import com.simol.homework.product.model.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAllOrderByProductIdDesc();
}
