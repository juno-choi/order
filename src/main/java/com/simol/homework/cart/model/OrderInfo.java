package com.simol.homework.cart.model;

public class OrderInfo {
    private Long productId;
    private int quantity;
    private String productName;
    private int price;

    public static OrderInfo of(Long productId, int quantity, String productName, int price) {
        return new OrderInfo(productId, quantity, productName, price);
    }

    OrderInfo(Long productId, int quantity, String productName, int price) {
        this.productId = productId;
        this.quantity = quantity;
        this.productName = productName;
        this.price = price;
    }

    public Long getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getProductName() {
        return productName;
    }
}
