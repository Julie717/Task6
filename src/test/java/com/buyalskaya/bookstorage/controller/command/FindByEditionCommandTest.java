package com.buyalskaya.bookstorage.controller.command;

import com.buyalskaya.bookstorage.controller.command.impl.FindByEditionCommand;
import com.buyalskaya.bookstorage.exception.LibraryException;
import com.buyalskaya.bookstorage.model.entity.CustomBook;
import com.buyalskaya.bookstorage.dataprovider.InitialLibrary;
import com.buyalskaya.bookstorage.utility.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.*;

import static org.testng.Assert.assertEquals;

public class FindByEditionCommandTest {
    FindByEditionCommand findByEditionCommand;

    @BeforeClass
    public void setUp() throws LibraryException {
        findByEditionCommand = new FindByEditionCommand();
        InitialLibrary.initLibrary();
    }


    @DataProvider(name = "dataForFindByEditionCommand")
    public Object[][] dataForFindByEditionCommand() {
        Map<String, String> parameters1 = new HashMap<>();
        parameters1.put("edition", "Bloomsbury");
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
        parameters2.put("id", "ffffffff-de3f-445d-88d0-c77319426c36");
        Response response2 = new Response();
        response2.setCompletedSuccess(false);
        response2.setMessage("Incorrect book edition");

        Map<String, String> parameters3 = new HashMap<>();
        parameters3.put("edition", "Black moon");
        Response response3 = new Response();
        response3.setCompletedSuccess(false);
        response3.setMessage("Book isn't found");

        Map<String, String> parameters4 = new HashMap<>();
        parameters4.put("edition", "");
        Response response4 = new Response();
        response4.setCompletedSuccess(false);
        response4.setMessage("Incorrect book edition");

        Map<String, String> parameters5 = new HashMap<>();
        parameters5.put("edition", "Oxford University Press");
        Response response5 = new Response();
        response5.setCompletedSuccess(true);
        books = new ArrayList<>();
        bookId = UUID.fromString("5d7f2a66-1959-4b28-ba3a-bf08fcda0ebe");
        name = "Notre-Dame de Paris";
        author = new ArrayList<>();
        author.add("Victor Hugo");
        edition = "Oxford University Press, Reissue edition";
        year = 2009;
        page = 592;
        book = new CustomBook(bookId, name, author, edition, year, page);
        books.add(book);
        response5.setBooks(books);
        return new Object[][]{
                {parameters1, response1},
                {parameters2, response2},
                {parameters3, response3},
                {parameters4, response4},
                {parameters5, response5}
        };
    }

    @Test(dataProvider = "dataForFindByEditionCommand")
    public void findByEditionCommandTestParams(Map<String, String> parameters, Response expected) {
        Response actual = findByEditionCommand.execute(parameters);
        assertEquals(actual, expected);
    }
}