package com.simol.homework;

import com.simol.homework.application.MainApplication;
import com.simol.homework.application.MainOrderApplication;
import com.simol.homework.application.config.MainConfig;
import com.simol.homework.application.io.ConsoleInputHandler;
import com.simol.homework.application.io.ConsoleOutputHandler;
import com.simol.homework.product.repository.ProductRepositoryImpl;
import com.simol.homework.product.service.ProductServiceImpl;

public class OrderApplication {
    public static void main(String[] args) {
        // application 필요 설정 세팅
        MainConfig mainConfig = new MainConfig(
                new ConsoleInputHandler(),
                new ConsoleOutputHandler(),
                new ProductServiceImpl(new ProductRepositoryImpl())
        );

        MainApplication mainApplication = new MainOrderApplication(mainConfig);
        mainApplication.run();
    }
}