package com.buyalskaya.bookstorage.controller.command;

import com.buyalskaya.bookstorage.controller.command.impl.SortByEditionCommand;
import com.buyalskaya.bookstorage.dataprovider.SortByEditionData;
import com.buyalskaya.bookstorage.exception.LibraryException;
import com.buyalskaya.bookstorage.dataprovider.InitialLibrary;
import com.buyalskaya.bookstorage.controller.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.*;

import static org.testng.Assert.assertEquals;

public class SortByEditionCommandTest {
    SortByEditionCommand sortByEditionCommand;

    @BeforeClass
    public void setUp() throws LibraryException {
        sortByEditionCommand = new SortByEditionCommand();
        InitialLibrary.initLibrary();
    }

    @DataProvider(name = "dataForSortByEditionCommand")
    public Object[][] dataForSortByEditionCommand() {
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
                {parameters1, new Response(true, SortByEditionData.expectedResultIncreaseSort())},
                {parameters2, new Response(true, SortByEditionData.expectedResultDecreaseSort())},
                {parameters3, new Response(false, "Incorrect sort direction")},
                {parameters4, new Response(false, "Incorrect sort direction")},
                {parameters5, new Response(false, "Incorrect parameters")}
        };
    }

    @Test(dataProvider = "dataForSortByEditionCommand")
    public void sortByEditionCommandTestParams(Map<String, String> parameters, Response expected) {
        Response actual = sortByEditionCommand.execute(parameters);
        assertEquals(actual, expected);
    }
}