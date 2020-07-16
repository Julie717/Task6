package com.buyalskaya.bookstorage.controller.command;

import com.buyalskaya.bookstorage.controller.command.impl.FindByPageCommand;
import com.buyalskaya.bookstorage.exception.LibraryException;
import com.buyalskaya.bookstorage.model.entity.CustomBook;
import com.buyalskaya.bookstorage.dataprovider.InitialLibrary;
import com.buyalskaya.bookstorage.utility.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.*;

import static org.testng.Assert.assertEquals;

public class FindByPageCommandTest {
    FindByPageCommand findByPageCommand;

    @BeforeClass
    public void setUp() throws LibraryException {
        findByPageCommand = new FindByPageCommand();
        InitialLibrary.initLibrary();
    }

    @DataProvider(name = "dataForFindByPageCommand")
    public Object[][] dataForFindByPageCommand() {
        Map<String, String> parameters1 = new HashMap<>();
        parameters1.put("page", "640");
        Response response1 = new Response();
        response1.setCompletedSuccess(true);
        List<CustomBook> books = new ArrayList<>();
        UUID bookId = UUID.fromString("6a87f4a7-3e0e-43d0-b74d-bc8f90f62702");
        String name = "Harry Potter and the Goblet of Fire";
        List<String> author = new ArrayList<>();
        author.add("J.K.Rowling");
        String edition = "Bloomsbury";
        int year = 2014;
        int page = 640;
        CustomBook book = new CustomBook(bookId, name, author, edition, year, page);
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
        Response response2 = new Response();
        response2.setCompletedSuccess(false);
        response2.setMessage("Incorrect book page");

        Map<String, String> parameters3 = new HashMap<>();
        parameters3.put("page", "25");
        Response response3 = new Response();
        response3.setCompletedSuccess(false);
        response3.setMessage("Book isn't found");

        Map<String, String> parameters4 = new HashMap<>();
        parameters4.put("page", "");
        Response response4 = new Response();
        response4.setCompletedSuccess(false);
        response4.setMessage("Incorrect book page");

        Map<String, String> parameters5 = new HashMap<>();
        parameters5.put("page", "17891");
        Response response5 = new Response();
        response5.setCompletedSuccess(false);
        response5.setMessage("Incorrect book page");
        return new Object[][]{
                {parameters1, response1},
                {parameters2, response2},
                {parameters3, response3},
                {parameters4, response4},
                {parameters5, response5}
        };
    }

    @Test(dataProvider = "dataForFindByPageCommand")
    public void findByPageCommandTestParams(Map<String, String> parameters, Response expected) {
        Response actual = findByPageCommand.execute(parameters);
        assertEquals(actual, expected);
    }
}