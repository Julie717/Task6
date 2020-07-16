package com.buyalskaya.bookstorage.model.dao.impl;

import com.buyalskaya.bookstorage.exception.LibraryException;
import com.buyalskaya.bookstorage.model.dao.BookListDao;
import com.buyalskaya.bookstorage.model.entity.CustomBook;
import com.buyalskaya.bookstorage.model.entity.Library;
import com.buyalskaya.bookstorage.model.entity.SortDirection;
import com.buyalskaya.bookstorage.exception.DaoException;

import java.util.*;
import java.util.stream.Collectors;

public class BookListDaoImpl implements BookListDao {
    @Override
    public void addBook(CustomBook book) throws DaoException {
        boolean isPresentInLibrary = Library.getInstance().getBooks()
                .stream()
                .anyMatch(b -> b.getName().equals(book.getName()) &&
                        b.getAuthor().equals(book.getAuthor()) &&
                        b.getEdition().equals(book.getEdition()) &&
                        b.getYear() == book.getYear() &&
                        b.getPage() == book.getPage());
        if (isPresentInLibrary) {
            throw new DaoException("This book is already in storage");
        }
        try {
            Library.getInstance().add(book);
        } catch (LibraryException ex) {
            throw new DaoException(ex.getMessage());
        }
    }

    @Override
    public void removeById(UUID bookId) throws DaoException {
        Optional<CustomBook> bookInLibrary = Library.getInstance().getBooks()
                .stream()
                .filter(b -> b.getBookId().equals(bookId))
                .findAny();
        if (bookInLibrary.isEmpty()) {
            throw new DaoException("This book is absent in storage");
        }
        try {
            Library.getInstance().remove(bookInLibrary.get());
        } catch (LibraryException ex) {
            throw new DaoException(ex.getMessage());
        }
    }

    @Override
    public void removeByName(String name) throws DaoException {
        List<CustomBook> bookInLibrary = Library.getInstance().getBooks()
                .stream()
                .filter(b -> b.getName().equals(name))
                .collect(Collectors.toList());
        if (bookInLibrary.isEmpty()) {
            throw new DaoException("This book is absent in storage");
        }
        for (CustomBook book : bookInLibrary) {
            try {
                Library.getInstance().remove(book);
            } catch (LibraryException ex) {
                throw new DaoException(ex.getMessage());
            }
        }
    }

    @Override
    public Optional<CustomBook> findById(UUID bookId) {
        Optional<CustomBook> book = Library.getInstance().getBooks()
                .stream()
                .filter(b -> bookId.equals(b.getBookId()))
                .findFirst();
        return book;
    }

    @Override
    public List<CustomBook> findAll() {
        return Library.getInstance().getBooks();
    }

    @Override
    public List<CustomBook> findByName(String name) {
        List<CustomBook> books = Library.getInstance().getBooks()
                .stream()
                .filter(b -> b.getName().indexOf(name) != -1)
                .collect(Collectors.toList());
        return books;
    }

    @Override
    public List<CustomBook> findByAuthor(String author) {
        List<CustomBook> books = Library.getInstance().getBooks()
                .stream()
                .filter(b -> b.getAuthor()
                        .stream()
                        .anyMatch(a -> a.indexOf(author) != -1))
                .collect(Collectors.toList());
        return books;
    }

    @Override
    public List<CustomBook> findByEdition(String edition) {
        List<CustomBook> books = Library.getInstance().getBooks()
                .stream()
                .filter(b -> b.getEdition().indexOf(edition) != -1)
                .collect(Collectors.toList());
        return books;
    }

    @Override
    public List<CustomBook> findByYear(int year) {
        List<CustomBook> books = Library.getInstance().getBooks()
                .stream()
                .filter(b -> year == b.getYear())
                .collect(Collectors.toList());
        return books;
    }

    @Override
    public List<CustomBook> findByPage(int page) {
        List<CustomBook> books = Library.getInstance().getBooks()
                .stream()
                .filter(b -> page == b.getPage())
                .collect(Collectors.toList());
        return books;
    }

    @Override
    public List<CustomBook> sortBooksByName(SortDirection sortDirection) {
        int direction = (sortDirection == SortDirection.DECREASE) ? -1 : 1;
        List<CustomBook> books = Library.getInstance().getBooks()
                .stream()
                .sorted((b1, b2) -> direction * b1.getName().compareTo(b2.getName()))
                .collect(Collectors.toList());
        return books;
    }

    @Override
    public List<CustomBook> sortBooksByAuthor(SortDirection sortDirection) {
        int direction = (sortDirection == SortDirection.DECREASE) ? -1 : 1;
        List<CustomBook> books = Library.getInstance().getBooks()
                .stream()
                .sorted((b1, b2) -> direction * b1.getAuthor().get(0).compareTo(b2.getAuthor().get(0)))
                .collect(Collectors.toList());
        return books;
    }

    @Override
    public List<CustomBook> sortBooksByEdition(SortDirection sortDirection) {
        int direction = (sortDirection == SortDirection.DECREASE) ? -1 : 1;
        List<CustomBook> books = Library.getInstance().getBooks()
                .stream()
                .sorted((b1, b2) -> direction * b1.getEdition().compareTo(b2.getEdition()))
                .collect(Collectors.toList());
        return books;
    }

    @Override
    public List<CustomBook> sortBooksByYear(SortDirection sortDirection) {
        List<CustomBook> books;
        if (sortDirection == SortDirection.DECREASE) {
            books = Library.getInstance().getBooks()
                    .stream()
                    .sorted(Comparator.comparing(CustomBook::getYear).reversed())
                    .collect(Collectors.toList());
        } else {
            books = Library.getInstance().getBooks()
                    .stream()
                    .sorted(Comparator.comparing(CustomBook::getYear))
                    .collect(Collectors.toList());
        }
        return books;
    }

    @Override
    public List<CustomBook> sortBooksByPage(SortDirection sortDirection) {
        List<CustomBook> books;
        if (sortDirection == SortDirection.DECREASE) {
            books = Library.getInstance().getBooks()
                    .stream()
                    .sorted(Comparator.comparing(CustomBook::getPage).reversed())
                    .collect(Collectors.toList());
        } else {
            books = Library.getInstance().getBooks()
                    .stream()
                    .sorted(Comparator.comparing(CustomBook::getPage))
                    .collect(Collectors.toList());
        }
        return books;
    }
}