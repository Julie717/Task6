package com.buyalskaya.bookstorage.controller.command.impl;

import com.buyalskaya.bookstorage.controller.command.Command;
import com.buyalskaya.bookstorage.exception.ServiceException;
import com.buyalskaya.bookstorage.model.entity.CustomBook;
import com.buyalskaya.bookstorage.model.service.BookService;
import com.buyalskaya.bookstorage.utility.Response;

import java.util.List;
import java.util.Map;

public class FindByAuthorCommand implements Command {
    private static final String PARAM_AUTHOR = "author";

    @Override
    public Response execute(Map<String, String> parameters) {
        String author = parameters.get(PARAM_AUTHOR);
        BookService bookService = new BookService();
        Response response = new Response();
        try {
            List<CustomBook> books = bookService.findByAuthor(author);
            response.setCompletedSuccess(true);
            response.setBooks(books);
        } catch (ServiceException ex) {
            response.setCompletedSuccess(false);
            response.setMessage(ex.getMessage());
        }
        return response;
    }
}