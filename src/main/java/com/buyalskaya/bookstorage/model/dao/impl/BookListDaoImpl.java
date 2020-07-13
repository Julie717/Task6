package com.buyalskaya.bookstorage.model.dao.impl;

import com.buyalskaya.bookstorage.model.dao.BookListDao;
import com.buyalskaya.bookstorage.model.entity.CustomBook;
import com.buyalskaya.bookstorage.model.entity.Library;
import com.buyalskaya.bookstorage.model.entity.SortDirection;
import com.buyalskaya.bookstorage.model.exception.DaoException;

import java.util.*;
import java.util.stream.Collectors;

public class BookListDaoImpl implements BookListDao {
    @Override
    public void addBook(CustomBook book) throws DaoException {
        boolean isAbsentLibrary = Library.getInstance().getBooks()
                .stream()
                .filter(p -> p.getName().equals(book.getName()))
                .filter(p -> p.getAuthor().equals(book.getAuthor()))
                .filter(p -> p.getEdition().equals(book.getEdition()))
                .filter(p -> p.getYear() == book.getYear())
                .filter(p -> p.getPage() == book.getPage())
                .collect(Collectors.toList())
                .isEmpty();
        if (!isAbsentLibrary) {
            throw new DaoException("This book is already in storage");
        }
        Library.getInstance().add(book);
    }

    @Override
    public void removeById(UUID bookId) throws DaoException {
        Optional<CustomBook> bookInLibrary = Library.getInstance().getBooks()
                .stream()
                .filter(p -> p.getBookId().equals(bookId))
                .findAny();
        if (!bookInLibrary.isPresent()) {
            throw new DaoException("This book is absent in storage");
        }
        Library.getInstance().remove(bookInLibrary.get());
    }

    @Override
    public void removeByName(String name) throws DaoException {
        List<CustomBook> bookInLibrary = Library.getInstance().getBooks()
                .stream()
                .filter(p -> p.getName().equals(name))
                .collect(Collectors.toList());
        if (bookInLibrary.isEmpty()) {
            throw new DaoException("This book is absent in storage");
        }
        for (CustomBook book : bookInLibrary) {
            Library.getInstance().remove(book);
        }
    }

    @Override
    public Optional<CustomBook> findById(UUID bookId) {
        return Library.getInstance().getBooks()
                .stream()
                .filter((p) -> bookId.equals(p.getBookId()))
                .findFirst();
    }

    @Override
    public List<CustomBook> findAll() {
        return Library.getInstance().getBooks();
    }

    @Override
    public List<CustomBook> findByName(String name) {
        return Library.getInstance().getBooks()
                .stream()
                .filter((p) -> p.getName().indexOf(name) != -1)
                .collect(Collectors.toList());
    }

    @Override
    public List<CustomBook> findByAuthor(String author) {
        return Library.getInstance().getBooks()
                .stream()
                .filter((p) -> p.getAuthor()
                        .stream()
                        .filter(p1 -> p1.indexOf(author) != -1).findFirst().isPresent()
                )
                .collect(Collectors.toList());
    }

    @Override
    public List<CustomBook> findByEdition(String edition) {
        return Library.getInstance().getBooks()
                .stream()
                .filter((p) ->p.getEdition().indexOf(edition)!=-1)
                .collect(Collectors.toList());
    }

    @Override
    public List<CustomBook> findByYear(int year) {
        return Library.getInstance().getBooks()
                .stream()
                .filter((p) -> year == p.getYear())
                .collect(Collectors.toList());
    }

    @Override
    public List<CustomBook> findByPage(int page) {
        return Library.getInstance().getBooks()
                .stream()
                .filter((p) -> page == p.getPage())
                .collect(Collectors.toList());
    }

    @Override
    public List<CustomBook> sortBooksByName(SortDirection sortDirection) {
        int direction = (sortDirection == SortDirection.DECREASE) ? -1 : 1;
        return Library.getInstance().getBooks()
                .stream()
                .sorted((b1, b2) -> direction * b1.getName().compareTo(b2.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public List<CustomBook> sortBooksByAuthor(SortDirection sortDirection) {
        int direction = (sortDirection == SortDirection.DECREASE) ? -1 : 1;
        return Library.getInstance().getBooks()
                .stream()
                .sorted((b1, b2) -> direction * b1.getAuthor().get(0).compareTo(b2.getAuthor().get(0)))
                .collect(Collectors.toList());
    }

    @Override
    public List<CustomBook> sortBooksByEdition(SortDirection sortDirection) {
        int direction = (sortDirection == SortDirection.DECREASE) ? -1 : 1;
        return Library.getInstance().getBooks()
                .stream()
                .sorted((b1, b2) -> direction * b1.getEdition().compareTo(b2.getEdition()))
                .collect(Collectors.toList());
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