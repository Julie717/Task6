package com.buyalskaya.bookstorage.controller.command;

import com.buyalskaya.bookstorage.controller.command.impl.FindByAuthorCommand;
import com.buyalskaya.bookstorage.model.entity.CustomBook;
import com.buyalskaya.bookstorage.utility.InitialLibrary;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;

public class FindByAuthorCommandTest {
    FindByAuthorCommand findByAuthorCommand;

    @BeforeClass
    public void setUp() {
        findByAuthorCommand = new FindByAuthorCommand();
        InitialLibrary.initLibrary();
    }

    @DataProvider(name = "dataForFindByAuthorCommand")
    public Object[][] dataForFindByAuthorCommand() {
        Map<String, String> parameters1 = new HashMap<>();
        parameters1.put("author", "Rowling");
        Map<String, String> response1 = new HashMap<>();
        response1.put("response", "correct");
        StringBuilder response = new StringBuilder();
        response.append("[");
        response.append(CustomBook.class.getSimpleName());
        response.append("[bookId=ea357cdf-fee1-4b76-a3b3-d8f9cdc07f3f, ");
        response.append("name='Harry Potter and the Philosopher's Stone', ");
        response.append("author=[J.K.Rowling], ");
        response.append("edition='Bloomsbury', ");
        response.append("year=2014, ");
        response.append("page=352], ");
        response.append(CustomBook.class.getSimpleName());
        response.append("[bookId=730bd030-69a2-4d74-8183-45053437043f, ");
        response.append("name='Harry Potter and the Chamber of Secrets', ");
        response.append("author=[J.K.Rowling], ");
        response.append("edition='Bloomsbury', ");
        response.append("year=2014, ");
        response.append("page=384], ");
        response.append(CustomBook.class.getSimpleName());
        response.append("[bookId=b63ad7d6-de3f-445d-88d0-c77319426c36, ");
        response.append("name='Harry Potter and the Prisoner of Azkaban', ");
        response.append("author=[J.K.Rowling], ");
        response.append("edition='Bloomsbury', ");
        response.append("year=2014, ");
        response.append("page=480], ");
        response.append(CustomBook.class.getSimpleName());
        response.append("[bookId=6a87f4a7-3e0e-43d0-b74d-bc8f90f62702, ");
        response.append("name='Harry Potter and the Goblet of Fire', ");
        response.append("author=[J.K.Rowling], ");
        response.append("edition='Bloomsbury', ");
        response.append("year=2014, ");
        response.append("page=640], ");
        response.append(CustomBook.class.getSimpleName());
        response.append("[bookId=9a87cd94-ee92-4d13-8ca9-e8ef49d3f67d, ");
        response.append("name='Harry Potter and the Order of the Phoenix', ");
        response.append("author=[J.K.Rowling], ");
        response.append("edition='Bloomsbury', ");
        response.append("year=2014, ");
        response.append("page=816], ");
        response.append(CustomBook.class.getSimpleName());
        response.append("[bookId=20b020a3-51cb-4dd4-9267-eb997aa8e630, ");
        response.append("name='Harry Potter and the Half-Blood Prince', ");
        response.append("author=[J.K.Rowling], ");
        response.append("edition='Bloomsbury', ");
        response.append("year=2014, ");
        response.append("page=560], ");
        response.append(CustomBook.class.getSimpleName());
        response.append("[bookId=28b22d61-e6bf-4763-9b8f-548417a6dc41, ");
        response.append("name='Harry Potter and the Deathly Hallows', ");
        response.append("author=[J.K.Rowling], ");
        response.append("edition='Bloomsbury', ");
        response.append("year=2014, ");
        response.append("page=640]]");
        response1.put("message", response.toString());

        Map<String, String> parameters2 = new HashMap<>();
        parameters2.put("name", "Notre-Dam");
        Map<String, String> response2 = new HashMap<>();
        response2.put("response", "error");
        response2.put("message", "Incorrect book author");

        Map<String, String> parameters3 = new HashMap<>();
        parameters3.put("author", "Daniel Defo");
        Map<String, String> response3 = new HashMap<>();
        response3.put("response", "error");
        response3.put("message", "Book isn't found");

        Map<String, String> parameters4 = new HashMap<>();
        parameters4.put("name", "");
        Map<String, String> response4 = new HashMap<>();
        response4.put("response", "error");
        response4.put("message", "Incorrect book author");

        Map<String, String> parameters5 = new HashMap<>();
        parameters5.put("author", "DuBois");
        Map<String, String> response5 = new HashMap<>();
        response5.put("response", "correct");
        StringBuilder book = new StringBuilder();
        book.append("[");
        book.append(CustomBook.class.getSimpleName());
        book.append("[bookId=a348a970-fed2-4b51-92b9-711bc4d27835, ");
        book.append("name='The Summer House', ");
        book.append("author=[James Patterson, Brendan DuBois], ");
        book.append("edition='Little, Brown and Company', ");
        book.append("year=2020, ");
        book.append("page=448]]");
        response5.put("message", book.toString());

        return new Object[][]{
                {parameters1, response1},
                {parameters2, response2},
                {parameters3, response3},
                {parameters4, response4},
                {parameters5, response5}
        };
    }

    @Test(dataProvider = "dataForFindByAuthorCommand")
    public void findByAuthorCommandTestParams(Map<String, String> parameters, Map<String, String> expected) {
        Map<String, String> actual = findByAuthorCommand.execute(parameters);
        assertEquals(actual, expected);
    }
}