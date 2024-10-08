package com.simol.homework.global.config;

import com.simol.homework.global.io.InputHandler;
import com.simol.homework.global.io.OutputHandler;

public class MainConfig {
    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;

    public MainConfig(InputHandler inputHandler, OutputHandler outputHandler) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
    }

    public InputHandler getInputHandler() {
        return inputHandler;
    }

    public OutputHandler getOutputHandler() {
        return outputHandler;
    }
}
