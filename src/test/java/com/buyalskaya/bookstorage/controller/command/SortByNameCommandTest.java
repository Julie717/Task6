package com.buyalskaya.bookstorage.controller.command;

import com.buyalskaya.bookstorage.controller.command.impl.SortByNameCommand;
import com.buyalskaya.bookstorage.dataprovider.*;
import com.buyalskaya.bookstorage.exception.LibraryException;
import com.buyalskaya.bookstorage.controller.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.*;

import static org.testng.Assert.assertEquals;

public class SortByNameCommandTest {
    SortByNameCommand sortByNameCommand;

    @BeforeClass
    public void setUp() throws LibraryException {
        sortByNameCommand = new SortByNameCommand();
        InitialLibrary.initLibrary();
    }

    @DataProvider(name = "dataForSortByNameCommand")
    public Object[][] dataForSortByNameCommand() {
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
                {parameters1, new Response(true, SortByNameData.expectedResultIncreaseSort())},
                {parameters2, new Response(true, SortByNameData.expectedResultDecreaseSort())},
                {parameters3, new Response(false, "Incorrect sort direction")},
                {parameters4, new Response(false, "Incorrect sort direction")},
                {parameters5, new Response(false, "Incorrect parameters")}
        };
    }

    @Test(dataProvider = "dataForSortByNameCommand")
    public void sortByNameCommandTestParams(Map<String, String> parameters, Response expected) {
        Response actual = sortByNameCommand.execute(parameters);
        assertEquals(actual, expected);
    }
}