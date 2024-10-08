package com.simol.homework;

import com.simol.homework.global.application.MainApplication;
import com.simol.homework.global.application.MainOrderApplication;
import com.simol.homework.global.config.MainConfig;
import com.simol.homework.global.io.ConsoleInputHandler;
import com.simol.homework.global.io.ConsoleOutputHandler;

public class OrderApplication {
    public static void main(String[] args) {
        // application 필요 설정 세팅
        MainConfig mainConfig = new MainConfig(
                new ConsoleInputHandler(),
                new ConsoleOutputHandler()
        );

        MainApplication mainApplication = new MainOrderApplication(mainConfig);
        mainApplication.run();
    }
}