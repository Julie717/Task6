package com.buyalskaya.bookstorage.controller.command.impl;

import com.buyalskaya.bookstorage.controller.command.Command;
import com.buyalskaya.bookstorage.exception.ServiceException;
import com.buyalskaya.bookstorage.model.entity.CustomBook;
import com.buyalskaya.bookstorage.model.service.BookService;
import com.buyalskaya.bookstorage.utility.Response;

import java.util.List;
import java.util.Map;

public class FindByEditionCommand implements Command {
    private static final String PARAM_EDITION = "edition";

    @Override
    public Response execute(Map<String, String> parameters) {
        String edition = parameters.get(PARAM_EDITION);
        BookService bookService = new BookService();
        Response response = new Response();
        try {
            List<CustomBook> books = bookService.findByEdition(edition);
            response.setCompletedSuccess(true);
            response.setBooks(books);
        } catch (ServiceException ex) {
            response.setCompletedSuccess(false);
            response.setMessage(ex.getMessage());
        }
        return response;
    }
}