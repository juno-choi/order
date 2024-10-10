package com.simol.homework.application.io;

import com.simol.homework.cart.model.OrderInfo;
import com.simol.homework.product.model.Product;

import java.util.List;

public interface OutputHandler {
    void userInputOrder();

    void orderEnd();

    void printProductList(List<Product> productList);

    void inputProductId();

    void inputQuantity();

    void invalidProductId();

    void printOrderInfo(List<OrderInfo> orderList);
}
