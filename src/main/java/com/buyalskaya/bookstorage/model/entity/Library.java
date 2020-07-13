package com.buyalskaya.bookstorage.model.entity;

import com.buyalskaya.bookstorage.model.exception.DaoException;

import java.util.*;

public class Library {

    private static Library instance;
    private static List<CustomBook> books;

    private Library() {
        if (instance != null) {
            throw new RuntimeException("Library is already exist");//TODO ban reflection, can throw Runtime here?
        }
    }

    public static Library getInstance() {
        if (instance == null) {
            instance = new Library();
        }
        return instance;
    }

    public static void setBooks(List<CustomBook> books) {
        if (Library.books == null) {
            Library.books = books;
        }
    }

    public List<CustomBook> getBooks() {
        return books;
    }

    public void add(CustomBook book) throws DaoException {
        if (books.contains(book)) {
            throw new DaoException("This book is already in storage");
        }
        books.add(book);
    }

    public void remove(CustomBook book) throws DaoException {
        books.remove(book);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();//TODO ban clone
    }
}