package com.buyalskaya.bookstorage.model.entity;

import com.buyalskaya.bookstorage.model.creator.BooksCreator;
import com.buyalskaya.bookstorage.model.exception.ProjectException;
import com.buyalskaya.bookstorage.model.reader.InitialDataReader;

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
            InitialDataReader initialDataReader = new InitialDataReader();
            List<String> booksParameters;
            try {
                booksParameters = initialDataReader.readInitialData(InitialDataReader.DEFAULT_PATH);
            } catch (ProjectException ex) {
                booksParameters = new ArrayList<>();
            }
            BooksCreator booksCreator = new BooksCreator();
            books = booksCreator.createInitialBooks(booksParameters);
        }
        return instance;
    }

    public List<CustomBook> getBooks() {
        return books;
    }

    public void add(CustomBook book) throws ProjectException {
        if (books.contains(book)) {
            throw new ProjectException("This book is already in storage");
        }
        books.add(book);
    }

    public void remove(CustomBook book) throws ProjectException {
        books.remove(book);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();//TODO ban clone
    }
}