package com.buyalskaya.bookstorage.controller.command.impl;

import com.buyalskaya.bookstorage.controller.command.Command;
import com.buyalskaya.bookstorage.exception.ServiceException;
import com.buyalskaya.bookstorage.model.service.BookService;
import com.buyalskaya.bookstorage.utility.Response;

import java.util.Map;

public class AddCommand implements Command {
    private static final String PARAM_NAME = "name";
    private static final String PARAM_AUTHOR = "author";
    private static final String PARAM_EDITION = "edition";
    private static final String PARAM_YEAR = "year";
    private static final String PARAM_PAGE = "page";
    private static final String CORRECT_MESSAGE = "The book was added";

    @Override
    public Response execute(Map<String, String> parameters) {
        String name = parameters.get(PARAM_NAME);
        String author = parameters.get(PARAM_AUTHOR);
        String edition = parameters.get(PARAM_EDITION);
        String year = parameters.get(PARAM_YEAR);
        String page = parameters.get(PARAM_PAGE);
        BookService bookService = new BookService();
        Response response = new Response();
        try {
            bookService.bookAdd(name, author, edition, year, page);
            response.setCompletedSuccess(true);
            response.setMessage(CORRECT_MESSAGE);
        } catch (ServiceException ex) {
            response.setCompletedSuccess(false);
            response.setMessage(ex.getMessage());
        }
        return response;
    }
}