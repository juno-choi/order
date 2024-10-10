package com.simol.homework.application.io;

import com.simol.homework.product.model.Product;

import java.util.List;

public interface OutputHandler {
    void userInputOrder();

    void orderEnd();

    void productListPrint(List<Product> productList);

    void inputProductId();

    void inputQuantity();
}
