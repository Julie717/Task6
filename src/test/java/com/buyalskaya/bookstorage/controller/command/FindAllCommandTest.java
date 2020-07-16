package com.buyalskaya.bookstorage.controller.command;

import com.buyalskaya.bookstorage.controller.command.impl.FindAllCommand;
import com.buyalskaya.bookstorage.exception.LibraryException;
import com.buyalskaya.bookstorage.model.entity.CustomBook;
import com.buyalskaya.bookstorage.dataprovider.InitialLibrary;
import com.buyalskaya.bookstorage.utility.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

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
        List<CustomBook> books = new ArrayList<>();
        UUID bookId = UUID.fromString("ea357cdf-fee1-4b76-a3b3-d8f9cdc07f3f");
        String name = "Harry Potter and the Philosopher's Stone";
        List<String> author = new ArrayList<>();
        author.add("J.K.Rowling");
        String edition = "Bloomsbury";
        int year = 2014;
        int page = 352;
        CustomBook book = new CustomBook(bookId, name, author, edition, year, page);
        books.add(book);

        bookId = UUID.fromString("730bd030-69a2-4d74-8183-45053437043f");
        name = "Harry Potter and the Chamber of Secrets";
        author = new ArrayList<>();
        author.add("J.K.Rowling");
        edition = "Bloomsbury";
        year = 2014;
        page = 384;
        book = new CustomBook(bookId, name, author, edition, year, page);
        books.add(book);

        bookId = UUID.fromString("b63ad7d6-de3f-445d-88d0-c77319426c36");
        name = "Harry Potter and the Prisoner of Azkaban";
        author = new ArrayList<>();
        author.add("J.K.Rowling");
        edition = "Bloomsbury";
        year = 2014;
        page = 480;
        book = new CustomBook(bookId, name, author, edition, year, page);
        books.add(book);

        bookId = UUID.fromString("6a87f4a7-3e0e-43d0-b74d-bc8f90f62702");
        name = "Harry Potter and the Goblet of Fire";
        author = new ArrayList<>();
        author.add("J.K.Rowling");
        edition = "Bloomsbury";
        year = 2014;
        page = 640;
        book = new CustomBook(bookId, name, author, edition, year, page);
        books.add(book);

        bookId = UUID.fromString("9a87cd94-ee92-4d13-8ca9-e8ef49d3f67d");
        name = "Harry Potter and the Order of the Phoenix";
        author = new ArrayList<>();
        author.add("J.K.Rowling");
        edition = "Bloomsbury";
        year = 2014;
        page = 816;
        book = new CustomBook(bookId, name, author, edition, year, page);
        books.add(book);

        bookId = UUID.fromString("20b020a3-51cb-4dd4-9267-eb997aa8e630");
        name = "Harry Potter and the Half-Blood Prince";
        author = new ArrayList<>();
        author.add("J.K.Rowling");
        edition = "Bloomsbury";
        year = 2014;
        page = 560;
        book = new CustomBook(bookId, name, author, edition, year, page);
        books.add(book);

        bookId = UUID.fromString("28b22d61-e6bf-4763-9b8f-548417a6dc41");
        name = "Harry Potter and the Deathly Hallows";
        author = new ArrayList<>();
        author.add("J.K.Rowling");
        edition = "Bloomsbury";
        year = 2014;
        page = 640;
        book = new CustomBook(bookId, name, author, edition, year, page);
        books.add(book);

        bookId = UUID.fromString("5d7f2a66-1959-4b28-ba3a-bf08fcda0ebe");
        name = "Notre-Dame de Paris";
        author = new ArrayList<>();
        author.add("Victor Hugo");
        edition = "Oxford University Press, Reissue edition";
        year = 2009;
        page = 592;
        book = new CustomBook(bookId, name, author, edition, year, page);
        books.add(book);

        bookId = UUID.fromString("08335865-a91c-4632-a175-fb4ed9a37e78");
        name = "Les Miserables";
        author = new ArrayList<>();
        author.add("Victor Hugo");
        edition = "Canterbury Classics";
        year = 2015;
        page = 1264;
        book = new CustomBook(bookId, name, author, edition, year, page);
        books.add(book);

        bookId = UUID.fromString("af908285-53c4-46de-9d8a-5a6ac88014a0");
        name = "Ninety-three";
        author = new ArrayList<>();
        author.add("Victor Hugo");
        edition = "Peerless Press";
        year = 2011;
        page = 362;
        book = new CustomBook(bookId, name, author, edition, year, page);
        books.add(book);

        bookId = UUID.fromString("703ffb17-d2f8-436f-8ef3-60018c2c3577");
        name = "The Man Who Laughs";
        author = new ArrayList<>();
        author.add("Victor Hugo");
        edition = "Moorside Press";
        year = 2013;
        page = 368;
        book = new CustomBook(bookId, name, author, edition, year, page);
        books.add(book);

        bookId = UUID.fromString("abd2a107-36ee-4509-869e-6cee81a2c539");
        name = "Humans";
        author = new ArrayList<>();
        author.add("Brandon Stanton");
        edition = "St. Martin's Press";
        year = 2020;
        page = 448;
        book = new CustomBook(bookId, name, author, edition, year, page);
        books.add(book);

        bookId = UUID.fromString("82728797-df92-4ef0-b099-cd542187741d");
        name = "The Animals at Lockwood Manor";
        author = new ArrayList<>();
        author.add("Jane Healey");
        edition = "Houghton Mifflin Harcourt";
        year = 2020;
        page = 352;
        book = new CustomBook(bookId, name, author, edition, year, page);
        books.add(book);

        bookId = UUID.fromString("15a5e40d-d886-422e-90bf-d81cc9fcd8a0");
        name = "A Fall of Marigolds";
        author = new ArrayList<>();
        author.add("Susan Meissner");
        edition = "Houghton Mifflin Harcourt";
        year = 2014;
        page = 400;
        book = new CustomBook(bookId, name, author, edition, year, page);
        books.add(book);

        bookId = UUID.fromString("a348a970-fed2-4b51-92b9-711bc4d27835");
        name = "The Summer House";
        author = new ArrayList<>();
        author.add("James Patterson");
        author.add("Brendan DuBois");
        edition = "Little, Brown and Company";
        year = 2020;
        page = 448;
        book = new CustomBook(bookId, name, author, edition, year, page);
        books.add(book);
        Response expected = new Response();
        expected.setCompletedSuccess(true);
        Response actual = findAllCommand.execute(new HashMap<>());
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