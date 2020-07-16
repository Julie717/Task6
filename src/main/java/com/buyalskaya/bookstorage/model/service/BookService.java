package com.buyalskaya.bookstorage.model.service;

import com.buyalskaya.bookstorage.exception.ServiceException;
import com.buyalskaya.bookstorage.model.dao.BookListDao;
import com.buyalskaya.bookstorage.model.dao.impl.BookListDaoImpl;
import com.buyalskaya.bookstorage.model.entity.CustomBook;
import com.buyalskaya.bookstorage.model.entity.SortDirection;
import com.buyalskaya.bookstorage.exception.DaoException;
import com.buyalskaya.bookstorage.utility.DataParser;
import com.buyalskaya.bookstorage.validator.DataValidator;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class BookService {
    public void bookAdd(String name, String author, String edition,
                        String year, String page) throws ServiceException {
        DataParser dataParser = new DataParser();
        DataValidator dataValidator = new DataValidator();
        List<String> authorList = dataParser.authorParser(author);
        if (!dataValidator.isNameValid(name) ||
                !dataValidator.isAuthorValid(authorList) ||
                !dataValidator.isEditionValid(edition) ||
                !dataValidator.isYearValid(year) ||
                !dataValidator.isPageValid(page)) {
            throw new ServiceException("Incorrect book parameters");
        }
        int yearNumber = Integer.parseInt(year);
        int pageNumber = Integer.parseInt(page);
        CustomBook book = new CustomBook(name, authorList, edition, yearNumber, pageNumber);
        BookListDao bookListDao = new BookListDaoImpl();
        try {
            bookListDao.addBook(book);
        } catch (DaoException ex) {
            throw new ServiceException(ex.getMessage());
        }
    }

    public void removeById(String id) throws ServiceException {
        DataValidator dataValidator = new DataValidator();
        if (!dataValidator.isIdValid(id)) {
            throw new ServiceException("Incorrect book id");
        }
        BookListDao bookListDao = new BookListDaoImpl();
        try {
            bookListDao.removeById(UUID.fromString(id));
        } catch (DaoException ex) {
            throw new ServiceException(ex.getMessage());
        }
    }

    public void removeByName(String name) throws ServiceException {
        DataValidator dataValidator = new DataValidator();
        if (!dataValidator.isNameValid(name)) {
            throw new ServiceException("Incorrect book name");
        }
        BookListDao bookListDao = new BookListDaoImpl();
        try {
            bookListDao.removeByName(name);
        } catch (DaoException ex) {
            throw new ServiceException(ex.getMessage());
        }
    }

    public List<CustomBook> findAll() throws ServiceException {
        BookListDao bookListDao = new BookListDaoImpl();
        List<CustomBook> books = bookListDao.findAll();
        if (books.isEmpty()) {
            throw new ServiceException("Books are absent in library");
        }
        return books;
    }

    public CustomBook findById(String id) throws ServiceException {
        DataValidator dataValidator = new DataValidator();
        if (!dataValidator.isIdValid(id)) {
            throw new ServiceException("Incorrect book id");
        }
        BookListDao bookListDao = new BookListDaoImpl();
        Optional<CustomBook> book = bookListDao.findById(UUID.fromString(id));
        if (book.isEmpty()) {
            throw new ServiceException("The book isn't found");
        }
        return book.get();
    }

    public List<CustomBook> findByName(String name) throws ServiceException {
        DataValidator dataValidator = new DataValidator();
        if (!dataValidator.isNameValid(name)) {
            throw new ServiceException("Incorrect book name");
        }
        BookListDao bookListDao = new BookListDaoImpl();
        List<CustomBook> books = bookListDao.findByName(name);
        if (books.isEmpty()) {
            throw new ServiceException("Book isn't found");
        }
        return books;
    }

    public List<CustomBook> findByAuthor(String author) throws ServiceException {
        DataValidator dataValidator = new DataValidator();
        if (!dataValidator.isAuthorValid(author)) {
            throw new ServiceException("Incorrect book author");
        }
        BookListDao bookListDao = new BookListDaoImpl();
        List<CustomBook> books = bookListDao.findByAuthor(author);
        if (books.isEmpty()) {
            throw new ServiceException("Book isn't found");
        }
        return books;
    }

    public List<CustomBook> findByEdition(String edition) throws ServiceException {
        DataValidator dataValidator = new DataValidator();
        if (!dataValidator.isEditionValid(edition)) {
            throw new ServiceException("Incorrect book edition");
        }
        BookListDao bookListDao = new BookListDaoImpl();
        List<CustomBook> books = bookListDao.findByEdition(edition);
        if (books.isEmpty()) {
            throw new ServiceException("Book isn't found");
        }
        return books;
    }

    public List<CustomBook> findByYear(String year) throws ServiceException {
        DataValidator dataValidator = new DataValidator();
        if (!dataValidator.isYearValid(year)) {
            throw new ServiceException("Incorrect book year");
        }
        int yearNumber = Integer.parseInt(year);
        BookListDao bookListDao = new BookListDaoImpl();
        List<CustomBook> books = bookListDao.findByYear(yearNumber);
        if (books.isEmpty()) {
            throw new ServiceException("Book isn't found");
        }
        return books;
    }

    public List<CustomBook> findByPage(String page) throws ServiceException {
        DataValidator dataValidator = new DataValidator();
        if (!dataValidator.isPageValid(page)) {
            throw new ServiceException("Incorrect book page");
        }
        int pageNumber = Integer.parseInt(page);
        BookListDao bookListDao = new BookListDaoImpl();
        List<CustomBook> books = bookListDao.findByPage(pageNumber);
        if (books.isEmpty()) {
            throw new ServiceException("Book isn't found");
        }
        return books;
    }

    public List<CustomBook> sortByName(String sortDirection) throws ServiceException {
        DataValidator dataValidator = new DataValidator();
        if (!dataValidator.isSortDirectionValid(sortDirection)) {
            throw new ServiceException("Incorrect sort direction");
        }
        SortDirection direction = SortDirection.valueOf(sortDirection.toUpperCase());
        BookListDao bookListDao = new BookListDaoImpl();
        return bookListDao.sortBooksByName(direction);
    }

    public List<CustomBook> sortByAuthor(String sortDirection) throws ServiceException {
        DataValidator dataValidator = new DataValidator();
        if (!dataValidator.isSortDirectionValid(sortDirection)) {
            throw new ServiceException("Incorrect sort direction");
        }
        SortDirection direction = SortDirection.valueOf(sortDirection.toUpperCase());
        BookListDao bookListDao = new BookListDaoImpl();
        return bookListDao.sortBooksByAuthor(direction);
    }

    public List<CustomBook> sortByEdition(String sortDirection) throws ServiceException {
        DataValidator dataValidator = new DataValidator();
        if (!dataValidator.isSortDirectionValid(sortDirection)) {
            throw new ServiceException("Incorrect sort direction");
        }
        SortDirection direction = SortDirection.valueOf(sortDirection.toUpperCase());
        BookListDao bookListDao = new BookListDaoImpl();
        return bookListDao.sortBooksByEdition(direction);
    }

    public List<CustomBook> sortByYear(String sortDirection) throws ServiceException {
        DataValidator dataValidator = new DataValidator();
        if (!dataValidator.isSortDirectionValid(sortDirection)) {
            throw new ServiceException("Incorrect sort direction");
        }
        SortDirection direction = SortDirection.valueOf(sortDirection.toUpperCase());
        BookListDao bookListDao = new BookListDaoImpl();
        return bookListDao.sortBooksByYear(direction);
    }

    public List<CustomBook> sortByPage(String sortDirection) throws ServiceException {
        DataValidator dataValidator = new DataValidator();
        if (!dataValidator.isSortDirectionValid(sortDirection)) {
            throw new ServiceException("Incorrect sort direction");
        }
        SortDirection direction = SortDirection.valueOf(sortDirection.toUpperCase());
        BookListDao bookListDao = new BookListDaoImpl();
        return bookListDao.sortBooksByPage(direction);
    }
}