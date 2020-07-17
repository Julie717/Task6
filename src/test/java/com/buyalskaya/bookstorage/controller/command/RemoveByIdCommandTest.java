package com.buyalskaya.bookstorage.controller.command;

import com.buyalskaya.bookstorage.controller.command.impl.RemoveByIdCommand;
import com.buyalskaya.bookstorage.exception.LibraryException;
import com.buyalskaya.bookstorage.dataprovider.InitialLibrary;
import com.buyalskaya.bookstorage.controller.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.*;

public class RemoveByIdCommandTest {
    RemoveByIdCommand removeByIdCommand;

    @BeforeClass
    public void setUp() throws LibraryException {
        removeByIdCommand = new RemoveByIdCommand();
        InitialLibrary.initLibrary();
    }

    @DataProvider(name = "dataForRemoveByIdCommand")
    public Object[][] dataForRemoveByIdCommand() {
        Map<String, String> parameters1 = new HashMap<>();
        parameters1.put("id", "b63ad7d6-de3f-445d-88d0-c77319426c36");
        Map<String, String> parameters2 = new HashMap<>();
        parameters2.put("id", "ffffffff-de3f-445d-88d0-c77319426c36");
        Map<String, String> parameters3 = new HashMap<>();
        parameters3.put("id", "mn3ad7d6-de3f-445d-88d0-c77319426c36");
        Map<String, String> parameters4 = new HashMap<>();
        parameters4.put("id", "");
        Map<String, String> parameters5 = null;
        return new Object[][]{
                {parameters1, new Response(true, "The book was removed")},
                {parameters2, new Response(false, "This book is absent in storage")},
                {parameters3, new Response(false, "Incorrect book id")},
                {parameters4, new Response(false, "Incorrect book id")},
                {parameters5, new Response(false, "Incorrect book id")}
        };
    }

    @Test(dataProvider = "dataForRemoveByIdCommand")
    public void removeByIdCommandTestParams(Map<String, String> parameters, Response expected) {
        Response actual = removeByIdCommand.execute(parameters);
        assertEquals(actual, expected);
    }
}