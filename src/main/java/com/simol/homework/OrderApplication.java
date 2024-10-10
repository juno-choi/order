package com.simol.homework;

import com.simol.homework.application.MainApplication;
import com.simol.homework.application.MainOrderApplication;
import com.simol.homework.application.config.MainConfig;
import com.simol.homework.application.console.service.ConsoleServiceImpl;
import com.simol.homework.application.io.ConsoleInputHandler;
import com.simol.homework.application.io.ConsoleOutputHandler;
import com.simol.homework.cart.service.CartServiceImpl;
import com.simol.homework.product.repository.ProductRepositoryImpl;
import com.simol.homework.product.service.ProductServiceImpl;

public class OrderApplication {
    public static void main(String[] args) {
        // application 필요 설정 세팅
        MainConfig mainConfig = new MainConfig(
                new ConsoleServiceImpl(new ConsoleOutputHandler(), new ConsoleInputHandler()),
                new ProductServiceImpl(new ProductRepositoryImpl()),
                new CartServiceImpl()
        );

        MainApplication mainApplication = new MainOrderApplication(mainConfig);
        mainApplication.run();
    }
}