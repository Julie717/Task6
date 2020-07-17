package com.buyalskaya.bookstorage.controller;

import com.buyalskaya.bookstorage.dataprovider.*;
import com.buyalskaya.bookstorage.exception.LibraryException;
import com.buyalskaya.bookstorage.model.entity.CustomBook;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.*;

import static org.testng.Assert.*;

public class BookControllerTest {
    @BeforeClass
    public void setUp() throws LibraryException {
        InitialLibrary.initLibrary();
    }

    @Test(priority = 2)
    public void addTest() {
        String commandName = "add";
        Map<String, String> parameters = new HashMap<>();
        parameters.put("name", "The Master and Margarita");
        parameters.put("author", "Mikhail Bulgakov");
        parameters.put("edition", "Vintage");
        parameters.put("year", "1996");
        parameters.put("page", "384");
        Response expected = new Response();
        expected.setCompletedSuccess(true);
        expected.setMessage("The book was added");
        Response actual = BookController.getInstance().processRequest(commandName, parameters);
        assertEquals(actual, expected);
    }

    @Test(priority = 1)
    public void removeByIdTest() {
        String commandName = "remove_by_id";
        Map<String, String> parameters = new HashMap<>();
        parameters.put("id", "b63ad7d6-de3f-445d-88d0-c77319426c36");
        Response expected = new Response();
        expected.setCompletedSuccess(true);
        expected.setMessage("The book was removed");
        Response actual = BookController.getInstance().processRequest(commandName, parameters);
        assertEquals(actual, expected);
    }

    @Test(priority = 1)
    public void removeByNameTest() {
        String commandName = "remove_by_name";
        Map<String, String> parameters = new HashMap<>();
        parameters.put("name", "Ninety-three");
        Response expected = new Response();
        expected.setCompletedSuccess(true);
        expected.setMessage("The book(-s) was removed");
        Response actual = BookController.getInstance().processRequest(commandName, parameters);
        assertEquals(actual, expected);
    }

    @Test
    public void findByIdTest() {
        String commandName = "FIND_BY_ID";
        Map<String, String> parameters = new HashMap<>();
        parameters.put("id", "730bd030-69a2-4d74-8183-45053437043f");
        Response expected = new Response();
        expected.setCompletedSuccess(true);
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
        expected.setBooks(books);
        Response actual = BookController.getInstance().processRequest(commandName, parameters);
        assertEquals(actual, expected);
    }

    @Test(priority = 1)
    public void findByNameTest() {
        String commandName = "FIND_BY_NAME";
        Map<String, String> parameters = new HashMap<>();
        parameters.put("name", "Paris");
        Response expected = new Response();
        expected.setCompletedSuccess(true);
        List<CustomBook> books = new ArrayList<>();
        UUID bookId = UUID.fromString("5d7f2a66-1959-4b28-ba3a-bf08fcda0ebe");
        String name = "Notre-Dame de Paris";
        List<String> author = new ArrayList<>();
        author.add("Victor Hugo");
        String edition = "Oxford University Press, Reissue edition";
        int year = 2009;
        int page = 592;
        CustomBook book = new CustomBook(bookId, name, author, edition, year, page);
        books.add(book);
        expected.setBooks(books);
        Response actual = BookController.getInstance().processRequest(commandName, parameters);
        assertEquals(actual, expected);
    }

    @Test
    public void findByAuthorTest() {
        String commandName = "find_by_author";
        Map<String, String> parameters = new HashMap<>();
        parameters.put("author", "Susan Meissner");
        Response expected = new Response();
        expected.setCompletedSuccess(true);
        List<CustomBook> books = new ArrayList<>();
        UUID bookId = UUID.fromString("15a5e40d-d886-422e-90bf-d81cc9fcd8a0");
        String name = "A Fall of Marigolds";
        List<String> author = new ArrayList<>();
        author.add("Susan Meissner");
        String edition = "Houghton Mifflin Harcourt";
        int year = 2014;
        int page = 400;
        CustomBook book = new CustomBook(bookId, name, author, edition, year, page);
        books.add(book);
        expected.setBooks(books);
        Response actual = BookController.getInstance().processRequest(commandName, parameters);
        assertEquals(actual, expected);
    }

    @Test
    public void findByEditionTest() {
        String commandName = "find_by_edition";
        Map<String, String> parameters = new HashMap<>();
        parameters.put("edition", "Little, Brown and Company");
        Response expected = new Response();
        expected.setCompletedSuccess(true);
        List<CustomBook> books = new ArrayList<>();
        UUID bookId = UUID.fromString("a348a970-fed2-4b51-92b9-711bc4d27835");
        String name = "The Summer House";
        List<String> author = new ArrayList<>();
        author.add("James Patterson");
        author.add("Brendan DuBois");
        String edition = "Little, Brown and Company";
        int year = 2020;
        int page = 448;
        CustomBook book = new CustomBook(bookId, name, author, edition, year, page);
        books.add(book);
        expected.setBooks(books);
        Response actual = BookController.getInstance().processRequest(commandName, parameters);
        assertEquals(actual, expected);
    }

    @Test
    public void findByYearTest() {
        String commandName = "find_by_year";
        Map<String, String> parameters = new HashMap<>();
        parameters.put("year", "2009");
        Response expected = new Response();
        expected.setCompletedSuccess(true);
        List<CustomBook> books = new ArrayList<>();
        UUID bookId = UUID.fromString("5d7f2a66-1959-4b28-ba3a-bf08fcda0ebe");
        String name = "Notre-Dame de Paris";
        List<String> author = new ArrayList<>();
        author.add("Victor Hugo");
        String edition = "Oxford University Press, Reissue edition";
        int year = 2009;
        int page = 592;
        CustomBook book = new CustomBook(bookId, name, author, edition, year, page);
        books.add(book);
        expected.setBooks(books);
        Response actual = BookController.getInstance().processRequest(commandName, parameters);
        assertEquals(actual, expected);
    }

    @Test
    public void findByPageTest() {
        String commandName = "find_by_page";
        Map<String, String> parameters = new HashMap<>();
        parameters.put("page", "400");
        Response expected = new Response();
        expected.setCompletedSuccess(true);
        List<CustomBook> books = new ArrayList<>();
        UUID bookId = UUID.fromString("15a5e40d-d886-422e-90bf-d81cc9fcd8a0");
        String name = "A Fall of Marigolds";
        List<String> author = new ArrayList<>();
        author.add("Susan Meissner");
        String edition = "Houghton Mifflin Harcourt";
        int year = 2014;
        int page = 400;
        CustomBook book = new CustomBook(bookId, name, author, edition, year, page);
        books.add(book);
        expected.setBooks(books);
        Response actual = BookController.getInstance().processRequest(commandName, parameters);
        assertEquals(actual, expected);
    }

    @DataProvider(name = "dataForSort")
    public Object[][] dataForSort() {
        Map<String, String> parametersIncrease = new HashMap<>();
        parametersIncrease.put("direction", "increase");
        Map<String, String> parametersDecrease = new HashMap<>();
        parametersDecrease.put("direction", "DECREASE");
        return new Object[][]{
                {"sort_by_name", parametersIncrease,
                        new Response(true, SortByNameData.expectedResultIncreaseSort())},
                {"sort_by_name", parametersDecrease,
                        new Response(true, SortByNameData.expectedResultDecreaseSort())},
                {"sort_by_author", parametersIncrease,
                        new Response(true, SortByAuthorData.expectedResultIncreaseSort())},
                {"sort_by_author", parametersDecrease,
                        new Response(true, SortByAuthorData.expectedResultDecreaseSort())},
                {"sort_by_edition", parametersIncrease,
                        new Response(true, SortByEditionData.expectedResultIncreaseSort())},
                {"sort_by_edition", parametersDecrease,
                        new Response(true, SortByEditionData.expectedResultDecreaseSort())},
                {"sort_by_year", parametersIncrease,
                        new Response(true, SortByYearData.expectedResultIncreaseSort())},
                {"sort_by_year", parametersDecrease,
                        new Response(true, SortByYearData.expectedResultDecreaseSort())},
                {"sort_by_page", parametersIncrease,
                        new Response(true, SortByPageData.expectedResultIncreaseSort())},
                {"sort_by_page", parametersDecrease,
                        new Response(true, SortByPageData.expectedResultDecreaseSort())},
        };
    }

    @Test(dataProvider = "dataForSort")
    public void sortTestParams(String commandName, Map<String, String> parameters, Response expected) {
        Response actual = BookController.getInstance().processRequest(commandName, parameters);
        assertEquals(actual, expected);
    }

    @Test
    public void processRequestTestNegativeCommand() {
        String commandName = "findByMaterial";
        Map<String, String> parameters = new HashMap<>();
        parameters.put("page", "400");
        Response expected = new Response();
        expected.setCompletedSuccess(false);
        expected.setMessage("Incorrect command");
        Response actual = BookController.getInstance().processRequest(commandName, parameters);
        assertEquals(actual, expected);
    }
}