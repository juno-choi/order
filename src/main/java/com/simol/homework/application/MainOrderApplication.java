package com.simol.homework.application;

import com.simol.homework.application.config.MainConfig;
import com.simol.homework.application.console.service.ConsoleService;
import com.simol.homework.cart.service.CartService;
import com.simol.homework.application.console.enums.OrderApplicationType;
import com.simol.homework.cart.model.Cart;
import com.simol.homework.cart.model.OrderInfo;
import com.simol.homework.product.model.Product;
import com.simol.homework.product.service.ProductService;

import java.util.List;

public class MainOrderApplication implements MainApplication, MainInitApplication {
    private final ConsoleService consoleService;
    private final ProductService productService;
    private final CartService cartService;

    public MainOrderApplication(MainConfig mainConfig) {
        this.consoleService = mainConfig.getConsoleService();
        this.productService = mainConfig.getProductService();
        this.cartService = mainConfig.getCartService();
    }

    @Override
    public void run() {
        OrderApplicationType orderApplicationType = OrderApplicationType.ORDER;
        while (true) {
            orderApplicationType = consoleService.orderInit();
            if (orderApplicationType == OrderApplicationType.QUITE) {
                break;
            }

            // 서비스 시작
            List<Product> productList = productService.getProductList();
            consoleService.printProductList(productList);

            List<OrderInfo> orderInfoList = consoleService.getOrderInfoList(productList);
            Cart cart = Cart.create();
            cart.addAll(orderInfoList);
            List<OrderInfo> orderList = cart.getCartList();
            consoleService.printOrderList(orderList);
        }
    }
}
