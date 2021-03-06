package com.buyalskaya.bookstorage.controller.command;

import com.buyalskaya.bookstorage.controller.command.impl.AddCommand;
import com.buyalskaya.bookstorage.exception.LibraryException;
import com.buyalskaya.bookstorage.dataprovider.InitialLibrary;
import com.buyalskaya.bookstorage.controller.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.*;

public class AddCommandTest {
    AddCommand addCommand;

    @BeforeClass
    public void setUp() throws LibraryException {
        addCommand = new AddCommand();
        InitialLibrary.initLibrary();
    }

    @DataProvider(name = "dataForAddCommand")
    public Object[][] dataForAddCommand() {
        Map<String, String> parameters1 = new HashMap<>();
        parameters1.put("name", "The Master and Margarita");
        parameters1.put("author", "Mikhail Bulgakov");
        parameters1.put("edition", "Vintage");
        parameters1.put("year", "1996");
        parameters1.put("page", "384");
        Response response1 = new Response(true, "The book was added");
        Map<String, String> parameters2 = new HashMap<>();
        parameters2.put("name", "The Computer Book: From the Abacus to Artificial Intelligence, 250 Milestones in the History of Computer Science");
        parameters2.put("author", "S.L.Garfinkel, R.H.Grunspan");
        parameters2.put("edition", "Sterling");
        parameters2.put("year", "2018");
        parameters2.put("page", "528");
        Response response2 = new Response(true, "The book was added");
        Map<String, String> parameters3 = new HashMap<>();
        parameters3.put("name", "Harry Potter and the Philosopher's Stone");
        parameters3.put("author", "J.K.Rowling");
        parameters3.put("edition", "Bloomsbury");
        parameters3.put("year", "2014");
        parameters3.put("page", "352");
        Response response3 = new Response(false, "This book is already in storage");
        Map<String, String> parameters4 = new HashMap<>();
        parameters4.put("name", "Harry Potter and the Philosopher's Stone");
        parameters4.put("author", "J.K.Rowling");
        parameters4.put("year", "2014");
        parameters4.put("page", "352");
        Response response4 = new Response(false, "Incorrect book parameters");
        Map<String, String> parameters5 = new HashMap<>();
        parameters5.put("name", "Harry Potter and the Philosopher's Stone");
        parameters5.put("author", "J.K.Rowling");
        parameters5.put("edition", "Bloomsbury");
        parameters5.put("year", "2025");
        parameters5.put("page", "352");
        Response response5 = new Response();
        response5.setCompletedSuccess(false);
        response5.setMessage("Incorrect book parameters");
        Map<String, String> parameters6 = null;
        Response response6 = new Response(false, "Incorrect parameters");
        return new Object[][]{
                {parameters1, response1},
                {parameters2, response2},
                {parameters3, response3},
                {parameters4, response4},
                {parameters5, response5},
                {parameters6, response6}
        };
    }

    @Test(dataProvider = "dataForAddCommand")
    public void addCommandTestParams(Map<String, String> parameters, Response expected) {
        Response actual = addCommand.execute(parameters);
        assertEquals(actual, expected);
    }
}