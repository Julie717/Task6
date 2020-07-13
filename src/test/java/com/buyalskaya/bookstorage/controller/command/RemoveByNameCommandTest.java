package com.buyalskaya.bookstorage.controller.command;

import com.buyalskaya.bookstorage.controller.command.impl.RemoveByNameCommand;
import com.buyalskaya.bookstorage.utility.InitialLibrary;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;

public class RemoveByNameCommandTest {
    RemoveByNameCommand removeByNameCommand;

    @BeforeClass
    public void setUp() {
        removeByNameCommand = new RemoveByNameCommand();
        InitialLibrary.initLibrary();
    }

    @DataProvider(name = "dataForRemoveByNameCommand")
    public Object[][] dataForRemoveByNameCommand() {
        Map<String, String> parameters1 = new HashMap<>();
        parameters1.put("name", "Ninety-three");

        Map<String, String> response1 = new HashMap<>();
        response1.put("response", "correct");
        response1.put("message", "The book(-s) was removed");

        Map<String, String> parameters2 = new HashMap<>();
        parameters2.put("name", "The Master and Margarita");
        Map<String, String> response2 = new HashMap<>();
        response2.put("response", "error");
        response2.put("message", "This book is absent in storage");

        Map<String, String> parameters3 = new HashMap<>();
        parameters3.put("name", ".-, $%");
        Map<String, String> response3 = new HashMap<>();
        response3.put("response", "error");
        response3.put("message", "Incorrect book name");

        Map<String, String> parameters4 = new HashMap<>();
        parameters4.put("name", "");
        Map<String, String> response4 = new HashMap<>();
        response4.put("response", "error");
        response4.put("message", "Incorrect book name");

        return new Object[][]{
                {parameters1, response1},
                {parameters2, response2},
                {parameters3, response3},
                {parameters4, response4}
        };
    }

    @Test(dataProvider = "dataForRemoveByNameCommand")
    public void removeByNameCommandTestParams(Map<String, String> parameters, Map<String, String> expected) {
        Map<String, String> actual = removeByNameCommand.execute(parameters);
        assertEquals(actual, expected);
    }
}