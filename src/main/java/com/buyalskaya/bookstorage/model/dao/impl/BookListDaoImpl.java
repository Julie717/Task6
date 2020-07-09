package com.buyalskaya.bookstorage.model.dao.impl;

import com.buyalskaya.bookstorage.model.dao.BookListDao;
import com.buyalskaya.bookstorage.model.entity.CustomBook;
import com.buyalskaya.bookstorage.model.entity.Library;
import com.buyalskaya.bookstorage.model.exception.ProjectException;

import java.util.*;
import java.util.stream.Collectors;

public class BookListDaoImpl implements BookListDao {
    @Override
    public void addBook(CustomBook book) throws ProjectException {
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
            throw new ProjectException("This book is already in storage");
        }
        Library.getInstance().add(book);
    }

    @Override
    public void removeBook(UUID bookId) throws ProjectException {
        Optional<CustomBook> bookInLibrary = Library.getInstance().getBooks()
                .stream()
                .filter(p -> p.getBookId().equals(bookId))
                .findAny();
        if (!bookInLibrary.isPresent()) {
            throw new ProjectException("This book is absent in storage");
        }
        Library.getInstance().remove(bookInLibrary.get());
    }

    @Override
    public Optional<CustomBook> findById(UUID bookId) {
        return Library.getInstance().getBooks()
                .stream()
                .filter((p) -> bookId.equals(p.getBookId()))
                .findFirst();
    }

    @Override
    public List<CustomBook> findByName(String name) {
        return Library.getInstance().getBooks()
                .stream()
                .filter((p) -> name.equals(p.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public List<CustomBook> findByAuthor(String author) {
        return Library.getInstance().getBooks()
                .stream()
                .filter((p) -> p.getAuthor().contains(author))
                .collect(Collectors.toList());
    }

    @Override
    public List<CustomBook> findByEdition(String edition) {
        return Library.getInstance().getBooks()
                .stream()
                .filter((p) -> edition.equals(p.getEdition()))
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
    public List<CustomBook> sortBooksById() {
        List<CustomBook> result = new ArrayList<>(Library.getInstance().getBooks());
        return result.stream()
                .sorted(Comparator.comparing(CustomBook::getBookId))
                .collect(Collectors.toList());
    }

    @Override
    public List<CustomBook> sortBooksByName() {
        return Library.getInstance().getBooks()
                .stream()
                .sorted(Comparator.comparing(CustomBook::getName))
                .collect(Collectors.toList());
    }

    @Override
    public List<CustomBook> sortBooksByAuthor() {
        return Library.getInstance().getBooks()
                .stream()
                .sorted(Comparator.comparing(o -> o.getAuthor().get(0)))
                .collect(Collectors.toList());
    }

    @Override
    public List<CustomBook> sortBooksByEdition() {
        return Library.getInstance().getBooks()
                .stream()
                .sorted(Comparator.comparing(CustomBook::getEdition))
                .collect(Collectors.toList());
    }

    @Override
    public List<CustomBook> sortBooksByYear() {
        return Library.getInstance().getBooks()
                .stream()
                .sorted(Comparator.comparing(CustomBook::getYear))
                .collect(Collectors.toList());
    }

    @Override
    public List<CustomBook> sortBooksByPage() {
        return Library.getInstance().getBooks()
                .stream()
                .sorted(Comparator.comparing(CustomBook::getPage))
                .collect(Collectors.toList());
    }
}