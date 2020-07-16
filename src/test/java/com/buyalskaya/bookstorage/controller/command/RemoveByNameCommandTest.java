package com.buyalskaya.bookstorage.controller.command;

import com.buyalskaya.bookstorage.controller.command.impl.RemoveByNameCommand;
import com.buyalskaya.bookstorage.exception.LibraryException;
import com.buyalskaya.bookstorage.dataprovider.InitialLibrary;
import com.buyalskaya.bookstorage.utility.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;

public class RemoveByNameCommandTest {
    RemoveByNameCommand removeByNameCommand;

    @BeforeClass
    public void setUp() throws LibraryException {
        removeByNameCommand = new RemoveByNameCommand();
        InitialLibrary.initLibrary();
    }

    @DataProvider(name = "dataForRemoveByNameCommand")
    public Object[][] dataForRemoveByNameCommand() {
        Map<String, String> parameters1 = new HashMap<>();
        parameters1.put("name", "Ninety-three");
        Response response1 = new Response();
        response1.setCompletedSuccess(true);
        response1.setMessage("The book(-s) was removed");

        Map<String, String> parameters2 = new HashMap<>();
        parameters2.put("name", "The Master and Margarita");
        Response response2 = new Response();
        response2.setCompletedSuccess(false);
        response2.setMessage("This book is absent in storage");

        Map<String, String> parameters3 = new HashMap<>();
        parameters3.put("name", ".-, $%");
        Response response3 = new Response();
        response3.setCompletedSuccess(false);
        response3.setMessage("Incorrect book name");

        Map<String, String> parameters4 = new HashMap<>();
        parameters4.put("name", "");
        Response response4 = new Response();
        response4.setCompletedSuccess(false);
        response4.setMessage("Incorrect book name");
        return new Object[][]{
                {parameters1, response1},
                {parameters2, response2},
                {parameters3, response3},
                {parameters4, response4}
        };
    }

    @Test(dataProvider = "dataForRemoveByNameCommand")
    public void removeByNameCommandTestParams(Map<String, String> parameters, Response expected) {
        Response actual = removeByNameCommand.execute(parameters);
        assertEquals(actual, expected);
    }
}