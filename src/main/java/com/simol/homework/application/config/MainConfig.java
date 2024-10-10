package com.simol.homework.application.config;

import com.simol.homework.application.console.service.ConsoleService;
import com.simol.homework.application.io.InputHandler;
import com.simol.homework.application.io.OutputHandler;
import com.simol.homework.cart.service.CartService;
import com.simol.homework.product.service.ProductService;

public class MainConfig {
    private final ConsoleService consoleService;
    private final ProductService productService;
    private final CartService cartService;

    public MainConfig(ConsoleService consoleService,ProductService productService, CartService cartService) {
        this.consoleService = consoleService;
        this.productService = productService;
        this.cartService = cartService;
    }

    public ProductService getProductService() {
        return productService;
    }

    public CartService getCartService() {
        return cartService;
    }

    public ConsoleService getConsoleService() {
        return consoleService;
    }
}
