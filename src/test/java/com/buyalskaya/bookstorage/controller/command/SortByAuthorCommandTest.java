package com.buyalskaya.bookstorage.controller.command;

import com.buyalskaya.bookstorage.controller.command.impl.SortByAuthorCommand;
import com.buyalskaya.bookstorage.dataprovider.SortByAuthorData;
import com.buyalskaya.bookstorage.exception.LibraryException;
import com.buyalskaya.bookstorage.dataprovider.InitialLibrary;
import com.buyalskaya.bookstorage.controller.Response;
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
        Map<String, String> parameters2 = new HashMap<>();
        parameters2.put("direction", "DECREASE");
        Map<String, String> parameters3 = new HashMap<>();
        parameters3.put("id", "");
        Map<String, String> parameters4 = new HashMap<>();
        parameters4.put("direction", "any");
        Map<String, String> parameters5 = null;
        return new Object[][]{
                {parameters1, new Response(true, SortByAuthorData.expectedResultIncreaseSort())},
                {parameters2, new Response(true, SortByAuthorData.expectedResultDecreaseSort())},
                {parameters3, new Response(false, "Incorrect sort direction")},
                {parameters4, new Response(false, "Incorrect sort direction")},
                {parameters5, new Response(false, "Incorrect parameters")}
        };
    }

    @Test(dataProvider = "dataForSortByAuthorCommand")
    public void sortByAuthorCommandTestParams(Map<String, String> parameters, Response expected) {
        Response actual = sortByAuthorCommand.execute(parameters);
        assertEquals(actual, expected);
    }
}