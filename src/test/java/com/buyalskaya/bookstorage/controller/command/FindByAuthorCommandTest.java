package com.buyalskaya.bookstorage.controller.command;

import com.buyalskaya.bookstorage.controller.command.impl.FindByAuthorCommand;
import com.buyalskaya.bookstorage.exception.LibraryException;
import com.buyalskaya.bookstorage.model.entity.CustomBook;
import com.buyalskaya.bookstorage.dataprovider.InitialLibrary;
import com.buyalskaya.bookstorage.controller.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.*;

import static org.testng.Assert.assertEquals;

public class FindByAuthorCommandTest {
    FindByAuthorCommand findByAuthorCommand;

    @BeforeClass
    public void setUp() throws LibraryException {
        findByAuthorCommand = new FindByAuthorCommand();
        InitialLibrary.initLibrary();
    }

    @DataProvider(name = "dataForFindByAuthorCommand")
    public Object[][] dataForFindByAuthorCommand() {
        Map<String, String> parameters1 = new HashMap<>();
        parameters1.put("author", "Rowling");
        Response response1 = new Response();
        response1.setCompletedSuccess(true);
        List<CustomBook> books = new ArrayList<>();
        UUID bookId = UUID.fromString("ea357cdf-fee1-4b76-a3b3-d8f9cdc07f3f");
        String name = "Harry Potter and the Philosopher's Stone";
        List<String> author = new ArrayList<>();
        author.add("J.K.Rowling");
        String edition = "Bloomsbury";
        int year = 2014;
        int page = 352;
        CustomBook book = new CustomBook(bookId, name, author, edition, year, page);
        books.add(book);
        bookId = UUID.fromString("730bd030-69a2-4d74-8183-45053437043f");
        name = "Harry Potter and the Chamber of Secrets";
        author = new ArrayList<>();
        author.add("J.K.Rowling");
        edition = "Bloomsbury";
        year = 2014;
        page = 384;
        book = new CustomBook(bookId, name, author, edition, year, page);
        books.add(book);
        bookId = UUID.fromString("b63ad7d6-de3f-445d-88d0-c77319426c36");
        name = "Harry Potter and the Prisoner of Azkaban";
        author = new ArrayList<>();
        author.add("J.K.Rowling");
        edition = "Bloomsbury";
        year = 2014;
        page = 480;
        book = new CustomBook(bookId, name, author, edition, year, page);
        books.add(book);
        bookId = UUID.fromString("6a87f4a7-3e0e-43d0-b74d-bc8f90f62702");
        name = "Harry Potter and the Goblet of Fire";
        author = new ArrayList<>();
        author.add("J.K.Rowling");
        edition = "Bloomsbury";
        year = 2014;
        page = 640;
        book = new CustomBook(bookId, name, author, edition, year, page);
        books.add(book);
        bookId = UUID.fromString("9a87cd94-ee92-4d13-8ca9-e8ef49d3f67d");
        name = "Harry Potter and the Order of the Phoenix";
        author = new ArrayList<>();
        author.add("J.K.Rowling");
        edition = "Bloomsbury";
        year = 2014;
        page = 816;
        book = new CustomBook(bookId, name, author, edition, year, page);
        books.add(book);
        bookId = UUID.fromString("20b020a3-51cb-4dd4-9267-eb997aa8e630");
        name = "Harry Potter and the Half-Blood Prince";
        author = new ArrayList<>();
        author.add("J.K.Rowling");
        edition = "Bloomsbury";
        year = 2014;
        page = 560;
        book = new CustomBook(bookId, name, author, edition, year, page);
        books.add(book);
        bookId = UUID.fromString("28b22d61-e6bf-4763-9b8f-548417a6dc41");
        name = "Harry Potter and the Deathly Hallows";
        author = new ArrayList<>();
        author.add("J.K.Rowling");
        edition = "Bloomsbury";
        year = 2014;
        page = 640;
        book = new CustomBook(bookId, name, author, edition, year, page);
        books.add(book);
        response1.setBooks(books);
        Map<String, String> parameters2 = new HashMap<>();
        parameters2.put("name", "Notre-Dam");
        Response response2 = new Response(false, "Incorrect book author");
        Map<String, String> parameters3 = new HashMap<>();
        parameters3.put("author", "Daniel Defo");
        Response response3 = new Response(false, "Book isn't found");
        Map<String, String> parameters4 = new HashMap<>();
        parameters4.put("name", "");
        Response response4 = new Response(false, "Incorrect book author");
        Map<String, String> parameters5 = new HashMap<>();
        parameters5.put("author", "DuBois");
        Response response5 = new Response();
        response5.setCompletedSuccess(true);
        books = new ArrayList<>();
        bookId = UUID.fromString("a348a970-fed2-4b51-92b9-711bc4d27835");
        name = "The Summer House";
        author = new ArrayList<>();
        author.add("James Patterson");
        author.add("Brendan DuBois");
        edition = "Little, Brown and Company";
        year = 2020;
        page = 448;
        book = new CustomBook(bookId, name, author, edition, year, page);
        books.add(book);
        response5.setBooks(books);
        Map<String, String> parameters6 = null;
        Response response6 = new Response(false, "Incorrect author");
        return new Object[][]{
                {parameters1, response1},
                {parameters2, response2},
                {parameters3, response3},
                {parameters4, response4},
                {parameters5, response5},
                {parameters6, response6}
        };
    }

    @Test(dataProvider = "dataForFindByAuthorCommand")
    public void findByAuthorCommandTestParams(Map<String, String> parameters, Response expected) {
        Response actual = findByAuthorCommand.execute(parameters);
        assertEquals(actual, expected);
    }
}