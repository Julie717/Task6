package com.buyalskaya.bookstorage.controller.command.impl;

import com.buyalskaya.bookstorage.controller.command.Command;

import java.util.HashMap;
import java.util.Map;

public class EmptyCommand implements Command {
    private static final String RESPONSE_PARAM_NAME = "response";
    private static final String RESPONSE_PARAM_MESSAGE = "message";
    private static final String ERROR = "error";
    private static final String ERROR_MESSAGE = "Incorrect command";

    @Override
    public Map<String, String> execute(Map<String, String> parameters) {
        Map<String, String> response = new HashMap<>();
        response.put(RESPONSE_PARAM_NAME, ERROR);
        response.put(RESPONSE_PARAM_MESSAGE, ERROR_MESSAGE);
        return response;
    }
}
