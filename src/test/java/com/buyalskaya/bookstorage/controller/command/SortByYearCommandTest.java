package com.buyalskaya.bookstorage.controller.command;

import com.buyalskaya.bookstorage.controller.command.impl.SortByYearCommand;
import com.buyalskaya.bookstorage.dataprovider.SortByYearData;
import com.buyalskaya.bookstorage.exception.LibraryException;
import com.buyalskaya.bookstorage.dataprovider.InitialLibrary;
import com.buyalskaya.bookstorage.controller.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.*;

import static org.testng.Assert.assertEquals;

public class SortByYearCommandTest {
    SortByYearCommand sortByYearCommand;

    @BeforeClass
    public void setUp() throws LibraryException {
        sortByYearCommand = new SortByYearCommand();
        InitialLibrary.initLibrary();
    }

    @DataProvider(name = "dataForSortByYearCommand")
    public Object[][] dataForSortByYearCommand() {
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
                {parameters1, new Response(true, SortByYearData.expectedResultIncreaseSort())},
                {parameters2, new Response(true, SortByYearData.expectedResultDecreaseSort())},
                {parameters3, new Response(false, "Incorrect sort direction")},
                {parameters4, new Response(false, "Incorrect sort direction")},
                {parameters5, new Response(false, "Incorrect parameters")}
        };
    }

    @Test(dataProvider = "dataForSortByYearCommand")
    public void sortByYearCommandTestParams(Map<String, String> parameters, Response expected) {
        Response actual = sortByYearCommand.execute(parameters);
        assertEquals(actual, expected);
    }
}