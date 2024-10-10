package com.simol.homework.application.console.service;

import com.simol.homework.application.console.enums.OrderApplicationType;
import com.simol.homework.cart.model.OrderInfo;
import com.simol.homework.product.model.Product;

import java.util.List;

public interface ConsoleService {
    OrderApplicationType orderInit();

    void printProductList(List<Product> productList);

    List<OrderInfo> getOrderInfoList(List<Product> productList);

    void printOrderList(List<OrderInfo> orderList);
}
