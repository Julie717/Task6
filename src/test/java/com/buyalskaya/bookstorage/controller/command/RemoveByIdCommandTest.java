package com.buyalskaya.bookstorage.controller.command;

import com.buyalskaya.bookstorage.controller.command.impl.RemoveByIdCommand;
import com.buyalskaya.bookstorage.exception.LibraryException;
import com.buyalskaya.bookstorage.dataprovider.InitialLibrary;
import com.buyalskaya.bookstorage.utility.Response;
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
        Response response1 = new Response();
        response1.setCompletedSuccess(true);
        response1.setMessage("The book was removed");

        Map<String, String> parameters2 = new HashMap<>();
        parameters2.put("id", "ffffffff-de3f-445d-88d0-c77319426c36");
        Response response2 = new Response();
        response2.setCompletedSuccess(false);
        response2.setMessage("This book is absent in storage");

        Map<String, String> parameters3 = new HashMap<>();
        parameters3.put("id", "mn3ad7d6-de3f-445d-88d0-c77319426c36");
        Response response3 = new Response();
        response3.setCompletedSuccess(false);
        response3.setMessage("Incorrect book id");

        Map<String, String> parameters4 = new HashMap<>();
        parameters4.put("id", "");
        Response response4 = new Response();
        response4.setCompletedSuccess(false);
        response4.setMessage("Incorrect book id");
        return new Object[][]{
                {parameters1, response1},
                {parameters2, response2},
                {parameters3, response3},
                {parameters4, response4}
        };
    }

    @Test(dataProvider = "dataForRemoveByIdCommand")
    public void removeByIdCommandTestParams(Map<String, String> parameters, Response expected) {
        Response actual = removeByIdCommand.execute(parameters);
        assertEquals(actual, expected);
    }
}