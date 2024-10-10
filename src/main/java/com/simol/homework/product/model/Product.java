package com.simol.homework.product.model;

public class Product {
    private Long productId;
    private String productName;
    private int productPrice;
    private int productStock;

    private Product(Long productId, String productName, int price, int stock) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = price;
        this.productStock = stock;
    }

    public static Product of(Long productId, String productName, int price, int stock) {
        return new Product(productId, productName, price, stock);
    }

    public Long getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public int getProductStock() {
        return productStock;
    }
}
