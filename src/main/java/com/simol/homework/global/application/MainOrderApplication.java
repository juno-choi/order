package com.simol.homework.global.application;

import com.simol.homework.global.config.MainConfig;
import com.simol.homework.global.io.InputHandler;
import com.simol.homework.global.io.OutputHandler;

public class MainOrderApplication implements MainApplication, MainInitApplication {
    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;

    public MainOrderApplication(MainConfig mainConfig) {
        this.inputHandler = mainConfig.getInputHandler();
        this.outputHandler = mainConfig.getOutputHandler();
    }

    @Override
    public void run() {

    }
}
