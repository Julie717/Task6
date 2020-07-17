package com.buyalskaya.bookstorage.controller.command;

import com.buyalskaya.bookstorage.controller.command.impl.SortByPageCommand;
import com.buyalskaya.bookstorage.dataprovider.SortByPageData;
import com.buyalskaya.bookstorage.exception.LibraryException;
import com.buyalskaya.bookstorage.dataprovider.InitialLibrary;
import com.buyalskaya.bookstorage.controller.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.*;

import static org.testng.Assert.assertEquals;

public class SortByPageCommandTest {
    SortByPageCommand sortByPageCommand;

    @BeforeClass
    public void setUp() throws LibraryException {
        sortByPageCommand = new SortByPageCommand();
        InitialLibrary.initLibrary();
    }

    @DataProvider(name = "dataForSortByPageCommand")
    public Object[][] dataForSortByPageCommand() {
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
                {parameters1, new Response(true, SortByPageData.expectedResultIncreaseSort())},
                {parameters2, new Response(true, SortByPageData.expectedResultDecreaseSort())},
                {parameters3, new Response(false, "Incorrect sort direction")},
                {parameters4, new Response(false, "Incorrect sort direction")},
                {parameters5, new Response(false, "Incorrect parameters")}
        };
    }

    @Test(dataProvider = "dataForSortByPageCommand")
    public void sortByPageCommandTestParams(Map<String, String> parameters, Response expected) {
        Response actual = sortByPageCommand.execute(parameters);
        assertEquals(actual, expected);
    }
}