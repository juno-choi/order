package com.simol.homework.global.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleInputHandler implements InputHandler{
    private final BufferedReader reader;

    public ConsoleInputHandler() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public String userInputOrder() {
        String input;
        try {
            input = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return input;
    }
}
