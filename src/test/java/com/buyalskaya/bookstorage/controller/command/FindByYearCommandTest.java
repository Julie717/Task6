package com.buyalskaya.bookstorage.controller.command;

import com.buyalskaya.bookstorage.controller.command.impl.FindByYearCommand;
import com.buyalskaya.bookstorage.exception.LibraryException;
import com.buyalskaya.bookstorage.model.entity.CustomBook;
import com.buyalskaya.bookstorage.dataprovider.InitialLibrary;
import com.buyalskaya.bookstorage.utility.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.*;

import static org.testng.Assert.assertEquals;

public class FindByYearCommandTest {
    FindByYearCommand findByYearCommand;

    @BeforeClass
    public void setUp() throws LibraryException {
        findByYearCommand = new FindByYearCommand();
        InitialLibrary.initLibrary();
    }

    @DataProvider(name = "dataForFindByYearCommand")
    public Object[][] dataForFindByYearCommand() {
        Map<String, String> parameters1 = new HashMap<>();
        parameters1.put("year", "2009");
        Response response1 = new Response();
        response1.setCompletedSuccess(true);
        List<CustomBook> books = new ArrayList<>();
        UUID bookId =  UUID.fromString("5d7f2a66-1959-4b28-ba3a-bf08fcda0ebe");
        String name = "Notre-Dame de Paris";
        List<String> author = new ArrayList<>();
        author.add("Victor Hugo");
        String edition = "Oxford University Press, Reissue edition";
        int year = 2009;
        int page = 592;
        CustomBook book = new CustomBook(bookId, name, author, edition, year, page);
        books.add(book);
        response1.setBooks(books);

        Map<String, String> parameters2 = new HashMap<>();
        parameters2.put("name", "Notre-Dam");
        Response response2 = new Response();
        response2.setCompletedSuccess(false);
        response2.setMessage("Incorrect book year");

        Map<String, String> parameters3 = new HashMap<>();
        parameters3.put("year", "2001");
        Response response3 = new Response();
        response3.setCompletedSuccess(false);
        response3.setMessage("Book isn't found");

        Map<String, String> parameters4 = new HashMap<>();
        parameters4.put("year", "");
        Response response4 = new Response();
        response4.setCompletedSuccess(false);
        response4.setMessage("Incorrect book year");

        Map<String, String> parameters5 = new HashMap<>();
        parameters5.put("year", "2025");
        Response response5 = new Response();
        response5.setCompletedSuccess(false);
        response5.setMessage("Incorrect book year");
        return new Object[][]{
                {parameters1, response1},
                {parameters2, response2},
                {parameters3, response3},
                {parameters4, response4},
                {parameters5, response5}
        };
    }

    @Test(dataProvider = "dataForFindByYearCommand")
    public void findByYearCommandTestParams(Map<String, String> parameters, Response expected) {
        Response actual = findByYearCommand.execute(parameters);
        assertEquals(actual, expected);
    }
}