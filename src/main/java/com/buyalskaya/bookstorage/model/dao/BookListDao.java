package com.buyalskaya.bookstorage.model.dao;

import com.buyalskaya.bookstorage.model.entity.CustomBook;
import com.buyalskaya.bookstorage.model.exception.ProjectException;

import java.util.*;

public interface BookListDao {

    public void addBook(CustomBook book) throws ProjectException;

    public void removeBook(UUID bookId) throws ProjectException;

    public Optional<CustomBook> findById(UUID bookId);

    public List<CustomBook> findByName(String name);

    public List<CustomBook> findByAuthor(String author);

    public List<CustomBook> findByEdition(String edition);

    public List<CustomBook> findByYear(int year);

    public List<CustomBook> findByPage(int page);

    public List<CustomBook> sortBooksById();

    public List<CustomBook> sortBooksByName();

    public List<CustomBook> sortBooksByAuthor();

    public List<CustomBook> sortBooksByEdition();

    public List<CustomBook> sortBooksByYear();

    public List<CustomBook> sortBooksByPage();
}