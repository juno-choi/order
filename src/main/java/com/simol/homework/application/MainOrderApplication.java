package com.simol.homework.application;

import com.simol.homework.application.config.MainConfig;
import com.simol.homework.application.io.InputHandler;
import com.simol.homework.application.io.OutputHandler;
import com.simol.homework.order.enums.OrderApplicationType;
import com.simol.homework.product.model.Product;
import com.simol.homework.product.service.ProductService;

import java.util.List;

public class MainOrderApplication implements MainApplication, MainInitApplication {
    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;
    private final ProductService productService;

    public MainOrderApplication(MainConfig mainConfig) {
        this.inputHandler = mainConfig.getInputHandler();
        this.outputHandler = mainConfig.getOutputHandler();
        this.productService = mainConfig.getProductService();
    }

    @Override
    public void run() {
        while (true) {
            OrderApplicationType orderInitUserInput = orderInit();
            if (orderInitUserInput == OrderApplicationType.QUITE) {
                // 프로그램 종료
                outputHandler.orderEnd();
                return ;
            }

            // 서비스 시작
            List<Product> productList = productService.getProductList();
            outputHandler.productListPrint(productList);

            while (true) {
                String productIdAsString = getProductId();
                String quantityAsString = getQuantity();
                if (" ".equals(productIdAsString) && " ".equals(quantityAsString)) {
                    break;
                }
            }
        }
    }

    private String getQuantity() {
        outputHandler.inputQuantity();
        return inputHandler.userInput();
    }

    private String getProductId() {
        outputHandler.inputProductId();
        return inputHandler.userInput();
    }

    private OrderApplicationType orderInit() {
        outputHandler.userInputOrder();
        String userInput = inputHandler.userInput();
        return OrderApplicationType.getTypeByUserInput(userInput);
    }
}
