package com.simol.homework.application.config;

import com.simol.homework.application.io.InputHandler;
import com.simol.homework.application.io.OutputHandler;
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
