package com.simol.homework.application.console.service;

import com.simol.homework.application.io.InputHandler;
import com.simol.homework.application.io.OutputHandler;
import com.simol.homework.application.console.enums.OrderApplicationType;
import com.simol.homework.cart.model.OrderInfo;
import com.simol.homework.product.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ConsoleServiceImpl implements ConsoleService{
    private final OutputHandler outputHandler;
    private final InputHandler inputHandler;
    public ConsoleServiceImpl(OutputHandler outputHandler, InputHandler inputHandler) {
        this.outputHandler = outputHandler;
        this.inputHandler = inputHandler;
    }

    @Override
    public OrderApplicationType orderInit() {
        OrderApplicationType orderInitUserInput = getUserInput();
        if (orderInitUserInput == OrderApplicationType.QUITE) {
            // 프로그램 종료
            outputHandler.orderEnd();
            return orderInitUserInput;
        }
        return orderInitUserInput;
    }

    @Override
    public void printProductList(List<Product> productList) {
        outputHandler.printProductList(productList);
    }

    @Override
    public List<OrderInfo> getOrderInfoList(List<Product> productList) {
        List<OrderInfo> orderInfoList = new ArrayList<>();
        while (true) {
            outputHandler.inputProductId();
            String productIdAsString = inputHandler.userInput();
            outputHandler.inputQuantity();
            String quantityAsString = inputHandler.userInput();

            if (" ".equals(productIdAsString) && " ".equals(quantityAsString)) {
                break;
            }

            Long productId = Long.valueOf(productIdAsString);
            int quantity = Integer.valueOf(quantityAsString);

            Optional<Product> optionalProduct = productList.stream()
                    .filter(p -> p.getProductId().equals(productId))
                    .findFirst();

            if (optionalProduct.isEmpty()) {
                outputHandler.invalidProductId();
                continue;
            }

            Product product = optionalProduct.get();
            OrderInfo orderInfo = OrderInfo.of(productId, quantity, product.getProductName(), product.getProductPrice());
            orderInfoList.add(orderInfo);
        }
        return orderInfoList;
    }

    @Override
    public void printOrderList(List<OrderInfo> orderList) {
        outputHandler.printOrderInfo(orderList);
        // todo 주문 결과 가격 노출
    }

    private OrderApplicationType getUserInput() {
        outputHandler.userInputOrder();
        String userInput = inputHandler.userInput();
        return OrderApplicationType.getTypeByUserInput(userInput);
    }

}
