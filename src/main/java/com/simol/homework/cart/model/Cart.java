package com.simol.homework.cart.model;

import com.simol.homework.product.model.Product;

import java.util.List;
import java.util.Stack;

public class Cart {
    private Stack<OrderInfo> cart;

    public static Cart create() {
        return new Cart();
    }
    Cart() {
        this.cart = new Stack<>();
    }

    public List<OrderInfo> getCartList() {
        return cart.stream().toList();
    }

    public void addAll(List<OrderInfo> orderInfoList) {

        cart.addAll(orderInfoList);
    }
}
