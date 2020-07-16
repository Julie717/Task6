package com.buyalskaya.bookstorage.controller.command;

import com.buyalskaya.bookstorage.controller.command.impl.SortByAuthorCommand;
import com.buyalskaya.bookstorage.dataprovider.SortByAuthorData;
import com.buyalskaya.bookstorage.exception.LibraryException;
import com.buyalskaya.bookstorage.model.entity.CustomBook;
import com.buyalskaya.bookstorage.dataprovider.InitialLibrary;
import com.buyalskaya.bookstorage.utility.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.*;

import static org.testng.Assert.assertEquals;

public class SortByAuthorCommandTest {
    SortByAuthorCommand sortByAuthorCommand;

    @BeforeClass
    public void setUp() throws LibraryException {
        sortByAuthorCommand = new SortByAuthorCommand();
        InitialLibrary.initLibrary();
    }

    @DataProvider(name = "dataForSortByAuthorCommand")
    public Object[][] dataForSortByAuthorCommand() {
        Map<String, String> parameters1 = new HashMap<>();
        parameters1.put("direction", "increase");
        Response response1 = new Response();
        response1.setCompletedSuccess(true);
        List<CustomBook> books = SortByAuthorData.expectedResultIncreaseSort();
        response1.setBooks(books);
        Map<String, String> parameters2 = new HashMap<>();
        parameters2.put("direction", "DECREASE");
        Response response2 = new Response();
        response2.setCompletedSuccess(true);
        books=SortByAuthorData.expectedResultDecreaseSort();
        response2.setBooks(books);
        Map<String, String> parameters3 = new HashMap<>();
        parameters3.put("id", "");
        Response response3 = new Response();
        response3.setCompletedSuccess(false);
        response3.setMessage("Incorrect sort direction");
        Map<String, String> parameters4 = new HashMap<>();
        parameters3.put("direction", "any");
        Response response4 = new Response();
        response4.setCompletedSuccess(false);
        response4.setMessage("Incorrect sort direction");
        return new Object[][]{
                {parameters1, response1},
                {parameters2, response2},
                {parameters3, response3},
                {parameters4, response4}
        };
    }

    @Test(dataProvider = "dataForSortByAuthorCommand")
    public void sortByAuthorCommandTestParams(Map<String, String> parameters, Response expected) {
        Response actual = sortByAuthorCommand.execute(parameters);
        assertEquals(actual, expected);
    }
}