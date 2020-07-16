package com.buyalskaya.bookstorage.model.dao;

import com.buyalskaya.bookstorage.model.entity.CustomBook;
import com.buyalskaya.bookstorage.model.entity.SortDirection;
import com.buyalskaya.bookstorage.exception.DaoException;

import java.util.*;

public interface BookListDao {

    public void addBook(CustomBook book) throws DaoException;

    public void removeById(UUID bookId) throws DaoException;

    public void removeByName(String name) throws DaoException;

    public List<CustomBook> findAll();

    public Optional<CustomBook> findById(UUID bookId);

    public List<CustomBook> findByName(String name);

    public List<CustomBook> findByAuthor(String author);

    public List<CustomBook> findByEdition(String edition);

    public List<CustomBook> findByYear(int year);

    public List<CustomBook> findByPage(int page);

    public List<CustomBook> sortBooksByName(SortDirection sortDirection);

    public List<CustomBook> sortBooksByAuthor(SortDirection sortDirection);

    public List<CustomBook> sortBooksByEdition(SortDirection sortDirection);

    public List<CustomBook> sortBooksByYear(SortDirection sortDirection);

    public List<CustomBook> sortBooksByPage(SortDirection sortDirection);
}