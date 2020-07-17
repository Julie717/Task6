package com.buyalskaya.bookstorage.controller.command;

import com.buyalskaya.bookstorage.controller.command.impl.RemoveByNameCommand;
import com.buyalskaya.bookstorage.exception.LibraryException;
import com.buyalskaya.bookstorage.dataprovider.InitialLibrary;
import com.buyalskaya.bookstorage.controller.Response;
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
        Map<String, String> parameters2 = new HashMap<>();
        parameters2.put("name", "The Master and Margarita");
        Map<String, String> parameters3 = new HashMap<>();
        parameters3.put("name", ".-, $%");
        Map<String, String> parameters4 = new HashMap<>();
        parameters4.put("name", "");
        Map<String, String> parameters5 = null;
        return new Object[][]{
                {parameters1, new Response(true, "The book(-s) was removed")},
                {parameters2, new Response(false, "This book is absent in storage")},
                {parameters3, new Response(false, "Incorrect book name")},
                {parameters4, new Response(false, "Incorrect book name")},
                {parameters5, new Response(false, "Incorrect book name")}
        };
    }

    @Test(dataProvider = "dataForRemoveByNameCommand")
    public void removeByNameCommandTestParams(Map<String, String> parameters, Response expected) {
        Response actual = removeByNameCommand.execute(parameters);
        assertEquals(actual, expected);
    }
}