package com.buyalskaya.bookstorage.controller.command;

import com.buyalskaya.bookstorage.controller.command.impl.FindByIdCommand;
import com.buyalskaya.bookstorage.exception.LibraryException;
import com.buyalskaya.bookstorage.model.entity.CustomBook;
import com.buyalskaya.bookstorage.dataprovider.InitialLibrary;
import com.buyalskaya.bookstorage.utility.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.*;

import static org.testng.Assert.assertEquals;

public class FindByIdCommandTest {
    FindByIdCommand findByIdCommand;

    @BeforeClass
    public void setUp() throws LibraryException {
        findByIdCommand = new FindByIdCommand();
        InitialLibrary.initLibrary();
    }

    @DataProvider(name = "dataForFindByIdCommand")
    public Object[][] dataForFindByIdCommand() {
        Map<String, String> parameters1 = new HashMap<>();
        parameters1.put("id", "730bd030-69a2-4d74-8183-45053437043f");
        Response response1 = new Response();
        response1.setCompletedSuccess(true);
        List<CustomBook> books = new ArrayList<>();
        UUID bookId = UUID.fromString("730bd030-69a2-4d74-8183-45053437043f");
        String name = "Harry Potter and the Chamber of Secrets";
        List<String> author = new ArrayList<>();
        author.add("J.K.Rowling");
        String edition = "Bloomsbury";
        int year = 2014;
        int page = 384;
        CustomBook book = new CustomBook(bookId, name, author, edition, year, page);
        books.add(book);
        response1.setBooks(books);

        Map<String, String> parameters2 = new HashMap<>();
        parameters2.put("name", "Notre-Dam");
        Response response2 = new Response();
        response2.setCompletedSuccess(false);
        response2.setMessage("Incorrect book id");

        Map<String, String> parameters3 = new HashMap<>();
        parameters3.put("id", "730bd030-69a2-4d74-8183-fff53437043f");
        Response response3 = new Response();
        response3.setCompletedSuccess(false);
        response3.setMessage("The book isn't found");

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

    @Test(dataProvider = "dataForFindByIdCommand")
    public void findByIdCommandTestParams(Map<String, String> parameters, Response expected) {
        Response actual = findByIdCommand.execute(parameters);
        assertEquals(actual, expected);
    }
}