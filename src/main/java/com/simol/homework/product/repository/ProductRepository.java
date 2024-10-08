package com.simol.homework.product.repository;

import com.simol.homework.product.entity.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAllOrderByProductIdDesc();
}
