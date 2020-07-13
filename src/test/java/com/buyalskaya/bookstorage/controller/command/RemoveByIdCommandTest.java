package com.buyalskaya.bookstorage.controller.command;

import com.buyalskaya.bookstorage.controller.command.impl.RemoveByIdCommand;
import com.buyalskaya.bookstorage.utility.InitialLibrary;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.*;

public class RemoveByIdCommandTest {
    RemoveByIdCommand removeByIdCommand;

    @BeforeClass
    public void setUp() {
        removeByIdCommand = new RemoveByIdCommand();
        InitialLibrary.initLibrary();
    }

    @DataProvider(name = "dataForRemoveByIdCommand")
    public Object[][] dataForRemoveByIdCommand() {
        Map<String, String> parameters1 = new HashMap<>();
        parameters1.put("id", "b63ad7d6-de3f-445d-88d0-c77319426c36");

        Map<String, String> response1 = new HashMap<>();
        response1.put("response", "correct");
        response1.put("message", "The book was removed");

        Map<String, String> parameters2 = new HashMap<>();
        parameters2.put("id", "ffffffff-de3f-445d-88d0-c77319426c36");
        Map<String, String> response2 = new HashMap<>();
        response2.put("response", "error");
        response2.put("message", "This book is absent in storage");

        Map<String, String> parameters3 = new HashMap<>();
        parameters3.put("id", "mn3ad7d6-de3f-445d-88d0-c77319426c36");
        Map<String, String> response3 = new HashMap<>();
        response3.put("response", "error");
        response3.put("message", "Incorrect book id");

        Map<String, String> parameters4 = new HashMap<>();
        parameters4.put("id", "");
        Map<String, String> response4 = new HashMap<>();
        response4.put("response", "error");
        response4.put("message", "Incorrect book id");

        return new Object[][]{
                {parameters1, response1},
                {parameters2, response2},
                {parameters3, response3},
                {parameters4, response4}
        };
    }

    @Test(dataProvider = "dataForRemoveByIdCommand")
    public void removeByIdCommandTestParams(Map<String, String> parameters, Map<String, String> expected) {
        Map<String, String> actual = removeByIdCommand.execute(parameters);
        assertEquals(actual, expected);
    }
}