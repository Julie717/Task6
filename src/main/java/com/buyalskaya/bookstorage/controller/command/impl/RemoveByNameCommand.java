package com.buyalskaya.bookstorage.controller.command.impl;

import com.buyalskaya.bookstorage.controller.command.Command;
import com.buyalskaya.bookstorage.exception.ServiceException;
import com.buyalskaya.bookstorage.service.BookService;

import java.util.HashMap;
import java.util.Map;

public class RemoveByNameCommand implements Command {
    private static final String PARAM_NAME = "name";
    private static final String RESPONSE_PARAM_NAME = "response";
    private static final String RESPONSE_PARAM_MESSAGE = "message";
    private static final String ERROR = "error";
    private static final String CORRECT = "correct";
    private static final String CORRECT_MESSAGE = "The book(-s) was removed";

    @Override
    public Map<String, String> execute(Map<String, String> parameters) {
        String name = parameters.get(PARAM_NAME);
        BookService bookService = new BookService();
        Map<String, String> response = new HashMap<>();
        try {
            bookService.removeByName(name);
            response.put(RESPONSE_PARAM_NAME, CORRECT);
            response.put(RESPONSE_PARAM_MESSAGE, CORRECT_MESSAGE);
        } catch (ServiceException ex) {
            response.put(RESPONSE_PARAM_NAME, ERROR);
            response.put(RESPONSE_PARAM_MESSAGE, ex.getMessage());
        }
        return response;
    }
}