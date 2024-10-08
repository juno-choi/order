package com.simol.homework.global.config;

import com.simol.homework.global.io.InputHandler;
import com.simol.homework.global.io.OutputHandler;
import com.simol.homework.product.service.ProductService;

public class MainConfig {
    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;
    private final ProductService productService;

    public MainConfig(InputHandler inputHandler, OutputHandler outputHandler, ProductService productService) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
        this.productService = productService;
    }

    public InputHandler getInputHandler() {
        return inputHandler;
    }

    public OutputHandler getOutputHandler() {
        return outputHandler;
    }

    public ProductService getProductService() {
        return productService;
    }
}
