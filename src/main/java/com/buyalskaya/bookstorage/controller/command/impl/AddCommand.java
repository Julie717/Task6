package com.buyalskaya.bookstorage.controller.command.impl;

import com.buyalskaya.bookstorage.controller.command.Command;
import com.buyalskaya.bookstorage.exception.ServiceException;
import com.buyalskaya.bookstorage.service.BookService;

import java.util.HashMap;
import java.util.Map;

public class AddCommand implements Command {
    private static final String PARAM_NAME = "name";
    private static final String PARAM_AUTHOR = "author";
    private static final String PARAM_EDITION = "edition";
    private static final String PARAM_YEAR = "year";
    private static final String PARAM_PAGE = "page";
    private static final String RESPONSE_PARAM_NAME = "response";
    private static final String RESPONSE_PARAM_MESSAGE = "message";
    private static final String ERROR = "error";
    private static final String CORRECT = "correct";
    private static final String CORRECT_MESSAGE = "The book was added";

    @Override
    public Map<String, String> execute(Map<String, String> parameters) {
        String name = parameters.get(PARAM_NAME);
        String author = parameters.get(PARAM_AUTHOR);
        String edition = parameters.get(PARAM_EDITION);
        String year = parameters.get(PARAM_YEAR);
        String page = parameters.get(PARAM_PAGE);
        BookService bookService = new BookService();
        Map<String, String> response = new HashMap<>();
        try {
            bookService.bookAdd(name, author, edition, year, page);
            response.put(RESPONSE_PARAM_NAME, CORRECT);
            response.put(RESPONSE_PARAM_MESSAGE, CORRECT_MESSAGE);
        } catch (ServiceException ex) {
            response.put(RESPONSE_PARAM_NAME, ERROR);
            response.put(RESPONSE_PARAM_MESSAGE, ex.getMessage());
        }
        return response;
    }
}