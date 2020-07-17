package com.buyalskaya.bookstorage.controller.command.impl;

import com.buyalskaya.bookstorage.controller.command.Command;
import com.buyalskaya.bookstorage.exception.ServiceException;
import com.buyalskaya.bookstorage.model.entity.CustomBook;
import com.buyalskaya.bookstorage.model.service.BookService;
import com.buyalskaya.bookstorage.controller.Response;

import java.util.List;
import java.util.Map;

public class SortByYearCommand implements Command {
    private static final String PARAM_SORT_DIRECTION = "direction";
    private static final String INCORRECT_MESSAGE = "Incorrect parameters";

    @Override
    public Response execute(Map<String, String> parameters) {
        Response response = new Response();
        if (parameters != null) {
            String sortDirection = parameters.get(PARAM_SORT_DIRECTION);
            BookService bookService = new BookService();
            try {
                List<CustomBook> books = bookService.sortByYear(sortDirection);
                response.setCompletedSuccess(true);
                response.setBooks(books);
            } catch (ServiceException ex) {
                response.setCompletedSuccess(false);
                response.setMessage(ex.getMessage());
            }
        } else {
            response.setMessage(INCORRECT_MESSAGE);
        }
        return response;
    }
}