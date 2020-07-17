package com.buyalskaya.bookstorage.controller.command;

import com.buyalskaya.bookstorage.controller.command.impl.FindAllCommand;
import com.buyalskaya.bookstorage.exception.LibraryException;
import com.buyalskaya.bookstorage.model.entity.CustomBook;
import com.buyalskaya.bookstorage.dataprovider.InitialLibrary;
import com.buyalskaya.bookstorage.controller.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;

import static org.testng.Assert.*;

public class FindAllCommandTest {
    FindAllCommand findAllCommand;

    @BeforeClass
    public void setUp() {
        findAllCommand = new FindAllCommand();
    }

    @Test
    public void findAllCommandTestPositive() throws LibraryException {
        InitialLibrary.initLibrary();
        Response actual = findAllCommand.execute(new HashMap<>());
        List<CustomBook> books = InitialLibrary.createInitialListBook();
        Response expected = new Response();
        expected.setCompletedSuccess(true);
        expected.setBooks(books);
        assertEquals(actual, expected);
    }

    @Test
    public void findAllCommandTestNegative() {
        Response expected = new Response();
        expected.setCompletedSuccess(false);
        Response actual = findAllCommand.execute(new HashMap<>());
        expected.setMessage("Books are absent in library");
        assertEquals(actual, expected);
    }
}