package com.buyalskaya.bookstorage.model.service;

import com.buyalskaya.bookstorage.model.exception.ProjectException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class BookServiceTest {
    BookService bookService = new BookService();

    @BeforeClass
    public void setUp() {
        bookService = new BookService();
    }

    @Test
    public void bookAddRequestEmpty() {
        String request = "";
        assertThrows(ProjectException.class, () -> bookService.bookAddRequest(request));
    }

    @Test
    public void bookAddRequestIncorrectYearGreater() {
        String request = "request=addBook; name=The Master and Margarita; author=Mikhail Bulgakov; " +
                "edition=Vintage; year=2022; page=384;";
        assertThrows(ProjectException.class, () -> bookService.bookAddRequest(request));
    }

    @Test
    public void bookAddRequestIncorrectYearLess() {
        String request = "request=addBook; name=The Master and Margarita; author=Mikhail Bulgakov; " +
                "edition=Vintage; year=0; page=384;";
        assertThrows(ProjectException.class, () -> bookService.bookAddRequest(request));
    }

    @Test
    public void bookAddRequestIncorrectYearEmpty() {
        String request = "request=addBook; name=The Master and Margarita; author=Mikhail Bulgakov; " +
                "edition=Vintage; year=; page=384;";
        assertThrows(ProjectException.class, () -> bookService.bookAddRequest(request));
    }

    @Test
    public void bookAddRequestIncorrectYearLetter() {
        String request = "request=addBook; name=The Master and Margarita; author=Mikhail Bulgakov; " +
                "edition=Vintage; year=12f2; page=384;";
        assertThrows(ProjectException.class, () -> bookService.bookAddRequest(request));
    }

    @Test
    public void bookAddRequestIncorrectPageGreater() {
        String request = "request=addBook; name=The Master and Margarita; author=Mikhail Bulgakov; " +
                "edition=Vintage; year=1996; page=10100;";
        assertThrows(ProjectException.class, () -> bookService.bookAddRequest(request));
    }

    @Test
    public void bookAddRequestIncorrectPageLess() {
        String request = "request=addBook; name=The Master and Margarita; author=Mikhail Bulgakov; " +
                "edition=Vintage; year=1996; page=-5;";
        assertThrows(ProjectException.class, () -> bookService.bookAddRequest(request));
    }

    @Test
    public void bookAddRequestIncorrectPageEmpty() {
        String request = "request=addBook; name=The Master and Margarita; author=Mikhail Bulgakov; " +
                "edition=Vintage; year=1996; page=";
        assertThrows(ProjectException.class, () -> bookService.bookAddRequest(request));
    }

    @Test
    public void bookAddRequestIncorrectPageLetter() {
        String request = "request=addBook; name=The Master and Margarita; author=Mikhail Bulgakov; " +
                "edition=Vintage; year=1996; page=38s4;";
        assertThrows(ProjectException.class, () -> bookService.bookAddRequest(request));
    }

    @Test
    public void bookAddRequestIncorrectName() {
        String request = "request=addBook; name=126; author=Mikhail Bulgakov; " +
                "edition=Vintage; year=1996; page=384;";
        assertThrows(ProjectException.class, () -> bookService.bookAddRequest(request));
    }

    @Test
    public void bookAddRequestIncorrectNameEmpty() {
        String request = "request=addBook; name=; author=Mikhail Bulgakov; " +
                "edition=Vintage; year=1996; page=384;";
        assertThrows(ProjectException.class, () -> bookService.bookAddRequest(request));
    }

    @Test
    public void bookAddRequestIncorrectAuthor() {
        String request = "request=addBook; name=The Master and Margarita; author=M.M.M. Bulgakov; " +
                "edition=Vintage; year=1996; page=384;";
        assertThrows(ProjectException.class, () -> bookService.bookAddRequest(request));
    }

    @Test
    public void bookAddRequestIncorrectAuthorDigit() {
        String request = "request=addBook; name=The Master and Margarita; author=M. Bulgakov 1; " +
                "edition=Vintage; year=1996; page=384;";
        assertThrows(ProjectException.class, () -> bookService.bookAddRequest(request));
    }

    @Test
    public void bookAddRequestIncorrectAuthorEmpty() {
        String request = "request=addBook; name=The Master and Margarita; author=; " +
                "edition=Vintage; year=1996; page=384;";
        assertThrows(ProjectException.class, () -> bookService.bookAddRequest(request));
    }

    @Test
    public void bookAddRequestIncorrectEdition() {
        String request = "request=addBook; name=The Master and Margarita; author=Mikhail Bulgakov; " +
                "edition=.1-4; year=1996; page=384;";
        assertThrows(ProjectException.class, () -> bookService.bookAddRequest(request));
    }

    @Test
    public void bookAddRequestIncorrectEditionEmpty() {
        String request = "request=addBook; name=The Master and Margarita; author=Mikhail Bulgakov; " +
                "edition=; year=1996; page=384;";
        assertThrows(ProjectException.class, () -> bookService.bookAddRequest(request));
    }
}