package com.buyalskaya.bookstorage.model.service;

import com.buyalskaya.bookstorage.model.dao.BookListDao;
import com.buyalskaya.bookstorage.model.dao.impl.BookListDaoImpl;
import com.buyalskaya.bookstorage.controller.command.CommandName;
import com.buyalskaya.bookstorage.model.entity.CustomBook;
import com.buyalskaya.bookstorage.model.exception.ProjectException;
import com.buyalskaya.bookstorage.model.parser.DataParser;
import com.buyalskaya.bookstorage.model.validator.DataValidator;

import java.util.List;
import java.util.UUID;

public class BookService {


    public void bookAddRequest(String request) throws ProjectException {
        DataParser dataParser = new DataParser();
        DataValidator dataValidator = new DataValidator();
        List<String> parameters = dataParser.bookParametersParser(request);
        String name = parameters.get(0);
        List<String> author = dataParser.authorParser(parameters.get(1));
        String edition = parameters.get(2);
        String yearString = parameters.get(3);
        String pageString = parameters.get(4);
        if (!dataValidator.isPositiveIntegerNumber(yearString) ||
                !dataValidator.isPositiveIntegerNumber(pageString)) {
            throw new ProjectException("Incorrect book parameters");
        }
        int year = Integer.parseInt(yearString);
        int page = Integer.parseInt(pageString);
        if (!dataValidator.validateName(name) ||
                !dataValidator.validateAuthor(author) ||
                !dataValidator.validateEdition(edition) ||
                !dataValidator.validateYear(year) ||
                !dataValidator.validatePage(page)) {
            throw new ProjectException("Incorrect book parameters");
        }
        CustomBook book = new CustomBook(name, author, edition, year, page);
        BookListDao bookListDao = new BookListDaoImpl();
        bookListDao.addBook(book);
    }

    public void bookRemoveRequest(String request) throws ProjectException {
        DataParser dataParser = new DataParser();
        DataValidator dataValidator = new DataValidator();
        String bookId=dataParser.oneBookParameterParser(request,CommandName.REMOVE);
        if (!dataValidator.validateId(bookId)) {
            throw new ProjectException("Incorrect book parameters");
        }
        BookListDao bookListDao = new BookListDaoImpl();
        bookListDao.removeBook(UUID.fromString(bookId));
    }

    public List<CustomBook> bookFindById(String request) throws ProjectException {
        DataParser dataParser = new DataParser();
        DataValidator dataValidator = new DataValidator();
        String id = dataParser.oneBookParameterParser(request, CommandName.FIND_BY_ID);
        if (!dataValidator.validateId(id)) {
            throw new ProjectException("Incorrect book id");
        }
        BookListDao bookListDao = new BookListDaoImpl();
        return bookListDao.findByEdition(id);
    }

    public List<CustomBook> bookFindByName(String request) throws ProjectException {
        DataParser dataParser = new DataParser();
        DataValidator dataValidator = new DataValidator();
        String name = dataParser.oneBookParameterParser(request, CommandName.FIND_BY_NAME);
        if (!dataValidator.validateName(name)) {
            throw new ProjectException("Incorrect book name");
        }
        BookListDao bookListDao = new BookListDaoImpl();
        return bookListDao.findByName(name);
    }

    public List<CustomBook> bookFindByAuthor(String request) throws ProjectException {
        DataParser dataParser = new DataParser();
        DataValidator dataValidator = new DataValidator();
        String author = dataParser.oneBookParameterParser(request, CommandName.FIND_BY_AUTHOR);
        if (!dataValidator.validateAuthor(List.of(author))) {
            throw new ProjectException("Incorrect book author");
        }
        BookListDao bookListDao = new BookListDaoImpl();
        return bookListDao.findByAuthor(author);
    }

    public List<CustomBook> bookFindByEdition(String request) throws ProjectException {
        DataParser dataParser = new DataParser();
        DataValidator dataValidator = new DataValidator();
        String edition = dataParser.oneBookParameterParser(request, CommandName.FIND_BY_EDITION);
        if (!dataValidator.validateEdition(edition)) {
            throw new ProjectException("Incorrect book edition");
        }
        BookListDao bookListDao = new BookListDaoImpl();
        return bookListDao.findByEdition(edition);
    }

    public List<CustomBook> bookFindByYear(String request) throws ProjectException {
        DataParser dataParser = new DataParser();
        DataValidator dataValidator = new DataValidator();
        String yearString = dataParser.oneBookParameterParser(request, CommandName.FIND_BY_YEAR);
        if (!dataValidator.isPositiveIntegerNumber(yearString)) {
            throw new ProjectException("Incorrect book page");
        }
        int year = Integer.parseInt(yearString);
        if (!dataValidator.validateYear(year)) {
            throw new ProjectException("Incorrect book year");
        }
        BookListDao bookListDao = new BookListDaoImpl();
        return bookListDao.findByYear(year);
    }

    public List<CustomBook> bookFindByPage(String request) throws ProjectException {
        DataParser dataParser = new DataParser();
        DataValidator dataValidator = new DataValidator();
        String pageString = dataParser.oneBookParameterParser(request, CommandName.FIND_BY_PAGE);
        if (!dataValidator.isPositiveIntegerNumber(pageString)) {
            throw new ProjectException("Incorrect book page");
        }
        int page = Integer.parseInt(pageString);
        if (!dataValidator.validatePage(page)) {
            throw new ProjectException("Incorrect book page");
        }
        BookListDao bookListDao = new BookListDaoImpl();
        return bookListDao.findByPage(page);
    }

    public List<CustomBook> bookSortById() {
        BookListDao bookListDao = new BookListDaoImpl();
        return bookListDao.sortBooksById();
    }

    public List<CustomBook> bookSortByName() {
        BookListDao bookListDao = new BookListDaoImpl();
        return bookListDao.sortBooksByName();
    }

    public List<CustomBook> bookSortByAuthor() {
        BookListDao bookListDao = new BookListDaoImpl();
        return bookListDao.sortBooksByAuthor();
    }

    public List<CustomBook> bookSortByEdition() {
        BookListDao bookListDao = new BookListDaoImpl();
        return bookListDao.sortBooksByEdition();
    }

    public List<CustomBook> bookSortByYear() {
        BookListDao bookListDao = new BookListDaoImpl();
        return bookListDao.sortBooksByYear();
    }

    public List<CustomBook> bookSortByPage() {
        BookListDao bookListDao = new BookListDaoImpl();
        return bookListDao.sortBooksByPage();
    }
}