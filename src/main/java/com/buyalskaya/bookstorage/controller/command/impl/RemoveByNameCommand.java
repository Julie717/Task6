package com.buyalskaya.bookstorage.controller.command.impl;

import com.buyalskaya.bookstorage.controller.command.Command;
import com.buyalskaya.bookstorage.exception.ServiceException;
import com.buyalskaya.bookstorage.model.service.BookService;
import com.buyalskaya.bookstorage.utility.Response;

import java.util.Map;

public class RemoveByNameCommand implements Command {
    private static final String PARAM_NAME = "name";
    private static final String CORRECT_MESSAGE = "The book(-s) was removed";

    @Override
    public Response execute(Map<String, String> parameters) {
        String name = parameters.get(PARAM_NAME);
        BookService bookService = new BookService();
        Response response = new Response();
        try {
            bookService.removeByName(name);
            response.setCompletedSuccess(true);
            response.setMessage(CORRECT_MESSAGE);
        } catch (ServiceException ex) {
            response.setCompletedSuccess(false);
            response.setMessage(ex.getMessage());
        }
        return response;
    }
}