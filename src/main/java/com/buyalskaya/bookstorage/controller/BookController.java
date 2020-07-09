package com.buyalskaya.bookstorage.controller;

import com.buyalskaya.bookstorage.controller.command.CommandName;
import com.buyalskaya.bookstorage.model.entity.CustomBook;
import com.buyalskaya.bookstorage.model.exception.ProjectException;
import com.buyalskaya.bookstorage.model.parser.DataParser;
import com.buyalskaya.bookstorage.model.service.BookService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static com.buyalskaya.bookstorage.controller.command.CommandName.*;

public class BookController {

    private static final String RESPONSE = "response=%s; message=%s";
    private static final String WARNING = "Command not found";
    private static final String REQUEST_NULL = "Request is null";
    private static final String ERROR = "Error";
    private static final String CORRECT = "Correct";
    private static final String CORRECT_ADD = "The book was added";
    private static final String CORRECT_REMOVE = "The book was removed";
    private static final String NOT_FOUND = "Not found";

    public String chooseAction(String request) {
        if (request == null) {
            return String.format(RESPONSE, ERROR, REQUEST_NULL);
        }
        DataParser dataParser = new DataParser();
        String command = dataParser.commandParser(request);
        BookService bookService = new BookService();
        Optional<CommandName> commandName = Stream.of(values())
                .filter((p) -> p.getCommandStringName().equals(command))
                .findAny();
        if (commandName.isEmpty()) {
            return String.format(RESPONSE, ERROR, WARNING);
        }
        String response = "";
        List<CustomBook> result;
        try {
            switch (commandName.get()) {
                case ADD:
                    bookService.bookAddRequest(request);
                    response = String.format(RESPONSE, CORRECT, CORRECT_ADD);
                    break;
                case REMOVE:
                    bookService.bookRemoveRequest(request);
                    response = String.format(RESPONSE, CORRECT, CORRECT_REMOVE);
                    break;
                case FIND_BY_ID:
                    result = bookService.bookFindById(request);
                    response = String.format(RESPONSE, CORRECT, (result.isEmpty()) ? NOT_FOUND : result);
                    break;
                case FIND_BY_NAME:
                    result = bookService.bookFindByName(request);
                    response = String.format(RESPONSE, CORRECT, (result.isEmpty()) ? NOT_FOUND : result);
                    break;
                case FIND_BY_AUTHOR:
                    result = bookService.bookFindByAuthor(request);
                    response = String.format(RESPONSE, CORRECT, (result.isEmpty()) ? NOT_FOUND : result);
                    break;
                case FIND_BY_EDITION:
                    result = bookService.bookFindByEdition(request);
                    response = String.format(RESPONSE, CORRECT, (result.isEmpty()) ? NOT_FOUND : result);
                    break;
                case FIND_BY_YEAR:
                    result = bookService.bookFindByYear(request);
                    response = String.format(RESPONSE, CORRECT, (result.isEmpty()) ? NOT_FOUND : result);
                    break;
                case FIND_BY_PAGE:
                    result = bookService.bookFindByPage(request);
                    response = String.format(RESPONSE, CORRECT, (result.isEmpty()) ? NOT_FOUND : result);
                    break;
                case SORT_BY_ID:
                    response = String.format(RESPONSE, CORRECT, bookService.bookSortById());
                    break;
                case SORT_BY_NAME:
                    response = String.format(RESPONSE, CORRECT, bookService.bookSortByName());
                    break;
                case SORT_BY_AUTHOR:
                    response = String.format(RESPONSE, CORRECT, bookService.bookSortByAuthor());
                    break;
                case SORT_BY_EDITION:
                    response = String.format(RESPONSE, CORRECT, bookService.bookSortByEdition());
                    break;
                case SORT_BY_YEAR:
                    response = String.format(RESPONSE, CORRECT, bookService.bookSortByYear());
                    break;
                case SORT_BY_PAGE:
                    response = String.format(RESPONSE, CORRECT, bookService.bookSortByPage());
                    break;
            }
        } catch (ProjectException ex) {
            response = String.format(RESPONSE, ERROR, ex.getMessage());
        }
        return response;
    }
}
