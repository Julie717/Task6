package com.buyalskaya.bookstorage.controller.command.impl;

import com.buyalskaya.bookstorage.controller.command.Command;
import com.buyalskaya.bookstorage.exception.ServiceException;
import com.buyalskaya.bookstorage.model.entity.CustomBook;
import com.buyalskaya.bookstorage.service.BookService;

import java.util.HashMap;
import java.util.Map;

public class FindByIdCommand implements Command {
    private static final String PARAM_ID = "id";
    private static final String RESPONSE_PARAM_NAME = "response";
    private static final String RESPONSE_PARAM_MESSAGE = "message";
    private static final String ERROR = "error";
    private static final String CORRECT = "correct";

    @Override
    public Map<String, String> execute(Map<String, String> parameters) {
        String id = parameters.get(PARAM_ID);
        BookService bookService = new BookService();
        Map<String, String> response = new HashMap<>();
        try {
            CustomBook book = bookService.findById(id);
            response.put(RESPONSE_PARAM_NAME, CORRECT);
            response.put(RESPONSE_PARAM_MESSAGE, book.toString());
        } catch (ServiceException ex) {
            response.put(RESPONSE_PARAM_NAME, ERROR);
            response.put(RESPONSE_PARAM_MESSAGE, ex.getMessage());
        }
        return response;
    }
}