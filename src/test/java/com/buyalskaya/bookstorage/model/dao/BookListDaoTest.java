package com.buyalskaya.bookstorage.model.dao;

import com.buyalskaya.bookstorage.dataprovider.*;
import com.buyalskaya.bookstorage.exception.DaoException;
import com.buyalskaya.bookstorage.exception.LibraryException;
import com.buyalskaya.bookstorage.model.dao.impl.BookListDaoImpl;
import com.buyalskaya.bookstorage.model.entity.CustomBook;

import com.buyalskaya.bookstorage.model.entity.SortDirection;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.testng.Assert.*;

public class BookListDaoTest {
    BookListDaoImpl bookListDao;

    @BeforeClass
    public void setUp() throws LibraryException {
        bookListDao = new BookListDaoImpl();
        InitialLibrary.initLibrary();
    }

    @Test
    public void addBookTestNegativeWithId() {
        UUID bookId = UUID.fromString("15a5e40d-d886-422e-90bf-d81cc9fcd8a0");
        String name = "A Fall of Marigolds";
        List<String> author = new ArrayList<>();
        author.add("Susan Meissner");
        String edition = "Houghton Mifflin Harcourt";
        int year = 2014;
        int page = 400;
        CustomBook book = new CustomBook(bookId, name, author, edition, year, page);
        assertThrows(DaoException.class, () -> bookListDao.addBook(book));
    }

    @Test
    public void addBookTestNegativeWithoutId() {
        String name = "A Fall of Marigolds";
        List<String> author = new ArrayList<>();
        author.add("Susan Meissner");
        String edition = "Houghton Mifflin Harcourt";
        int year = 2014;
        int page = 400;
        CustomBook book = new CustomBook(name, author, edition, year, page);
        assertThrows(DaoException.class, () -> bookListDao.addBook(book));
    }

    @Test
    public void removeByIdTestNegative() {
        UUID bookId = UUID.fromString("ffa5e40d-d886-422e-90bf-d81cc9fcd8a0");
        assertThrows(DaoException.class, () -> bookListDao.removeById(bookId));
    }

    @Test
    public void removeByNameTestNegative() {
        String name = "The Master and Margarita";
        assertThrows(DaoException.class, () -> bookListDao.removeByName(name));
    }

    @Test
    public void findByIdTestPositive() {
        UUID bookId = UUID.fromString("82728797-df92-4ef0-b099-cd542187741d");
        Optional<CustomBook> actual = bookListDao.findById(bookId);
        String name = "The Animals at Lockwood Manor";
        List<String> author = new ArrayList<>();
        author.add("Jane Healey");
        String edition = "Houghton Mifflin Harcourt";
        int year = 2020;
        int page = 352;
        CustomBook expected = new CustomBook(bookId, name, author, edition, year, page);
        assertEquals(actual.get(), expected);
    }

    @Test
    public void findByIdTestNegative() {
        UUID bookId = UUID.fromString("827287ff-df92-4ef0-b099-cd542187741d");
        Optional<CustomBook> actual = bookListDao.findById(bookId);
        Optional<CustomBook> expected = Optional.empty();
        assertEquals(actual, expected);
    }

    @Test
    public void findByNameTestPositive() {
        String name = "Animal";
        List<CustomBook> actual = bookListDao.findByName(name);
        UUID bookId = UUID.fromString("82728797-df92-4ef0-b099-cd542187741d");
        String nameExpected = "The Animals at Lockwood Manor";
        List<String> author = new ArrayList<>();
        author.add("Jane Healey");
        String edition = "Houghton Mifflin Harcourt";
        int year = 2020;
        int page = 352;
        CustomBook expectedBook = new CustomBook(bookId, nameExpected, author, edition, year, page);
        List<CustomBook> expected = new ArrayList<>();
        expected.add(expectedBook);
        assertEquals(actual, expected);
    }

    @Test
    public void findByNameTestNegative() {
        String name = "Sun";
        List<CustomBook> actual = bookListDao.findByName(name);
        List<CustomBook> expected = new ArrayList<>();
        assertEquals(actual, expected);
    }

    @Test
    public void findByAuthorTestPositive() {
        String author = "Healey";
        List<CustomBook> actual = bookListDao.findByAuthor(author);
        UUID bookId = UUID.fromString("82728797-df92-4ef0-b099-cd542187741d");
        String name = "The Animals at Lockwood Manor";
        List<String> authorExpected = new ArrayList<>();
        authorExpected.add("Jane Healey");
        String edition = "Houghton Mifflin Harcourt";
        int year = 2020;
        int page = 352;
        CustomBook expectedBook = new CustomBook(bookId, name,
                authorExpected, edition, year, page);
        List<CustomBook> expected = new ArrayList<>();
        expected.add(expectedBook);
        assertEquals(actual, expected);
    }

    @Test
    public void findByAuthorTestNegative() {
        String author = "Charles Dickens";
        List<CustomBook> actual = bookListDao.findByAuthor(author);
        List<CustomBook> expected = new ArrayList<>();
        assertEquals(actual, expected);
    }

    @Test
    public void findByEditionTestPositive() {
        String edition = "Mifflin Harcourt";
        List<CustomBook> actual = bookListDao.findByEdition(edition);
        UUID bookId = UUID.fromString("82728797-df92-4ef0-b099-cd542187741d");
        String name = "The Animals at Lockwood Manor";
        List<String> author = new ArrayList<>();
        author.add("Jane Healey");
        String editionExpected = "Houghton Mifflin Harcourt";
        int year = 2020;
        int page = 352;
        CustomBook expectedBook = new CustomBook(bookId, name,
                author, editionExpected, year, page);
        List<CustomBook> expected = new ArrayList<>();
        expected.add(expectedBook);
        bookId = UUID.fromString("15a5e40d-d886-422e-90bf-d81cc9fcd8a0");
        name = "A Fall of Marigolds";
        author = new ArrayList<>();
        author.add("Susan Meissner");
        edition = "Houghton Mifflin Harcourt";
        year = 2014;
        page = 400;
        expectedBook = new CustomBook(bookId, name, author, edition, year, page);
        expected.add(expectedBook);
        assertEquals(actual, expected);
    }

    @Test
    public void findByEditionTestNegative() {
        String edition = "Minsk";
        List<CustomBook> actual = bookListDao.findByEdition(edition);
        List<CustomBook> expected = new ArrayList<>();
        assertEquals(actual, expected);
    }

    @Test
    public void findByYearTestPositive() {
        int year = 2009;
        List<CustomBook> actual = bookListDao.findByYear(year);
        UUID bookId = UUID.fromString("5d7f2a66-1959-4b28-ba3a-bf08fcda0ebe");
        String name = "Notre-Dame de Paris";
        List<String> author = new ArrayList<>();
        author.add("Victor Hugo");
        String edition = "Oxford University Press, Reissue edition";
        int page = 592;
        CustomBook expectedBook = new CustomBook(bookId, name, author, edition, year, page);
        List<CustomBook> expected = new ArrayList<>();
        expected.add(expectedBook);
        assertEquals(actual, expected);
    }

    @Test
    public void findByYearTestNegative() {
        int year = 1995;
        List<CustomBook> actual = bookListDao.findByYear(year);
        List<CustomBook> expected = new ArrayList<>();
        assertEquals(actual, expected);
    }

    @Test
    public void findByPageTestPositive() {
        int page = 816;
        List<CustomBook> actual = bookListDao.findByPage(page);
        UUID bookId = UUID.fromString("9a87cd94-ee92-4d13-8ca9-e8ef49d3f67d");
        String name = "Harry Potter and the Order of the Phoenix";
        List<String> author = new ArrayList<>();
        author.add("J.K.Rowling");
        String edition = "Bloomsbury";
        int year = 2014;
        CustomBook expectedBook = new CustomBook(bookId, name, author, edition, year, page);
        List<CustomBook> expected = new ArrayList<>();
        expected.add(expectedBook);
        assertEquals(actual, expected);
    }

    @Test
    public void findByPageTestNegative() {
        int page = 25;
        List<CustomBook> actual = bookListDao.findByPage(page);
        List<CustomBook> expected = new ArrayList<>();
        assertEquals(actual, expected);
    }

    @Test
    public void sortBooksByNameTestIncrease() {
        List<CustomBook> actual = bookListDao.sortBooksByName(SortDirection.INCREASE);
        List<CustomBook> expected = SortByNameData.expectedResultIncreaseSort();
        assertEquals(actual, expected);
    }

    @Test
    public void sortBooksByNameTestDecrease() {
        List<CustomBook> actual = bookListDao.sortBooksByName(SortDirection.DECREASE);
        List<CustomBook> expected = SortByNameData.expectedResultDecreaseSort();
        assertEquals(actual, expected);
    }

    @Test
    public void sortBooksByAuthorTestIncrease() {
        List<CustomBook> actual = bookListDao.sortBooksByAuthor(SortDirection.INCREASE);
        List<CustomBook> expected = SortByAuthorData.expectedResultIncreaseSort();
        assertEquals(actual, expected);
    }

    @Test
    public void sortBooksByAuthorTestDecrease() {
        List<CustomBook> actual = bookListDao.sortBooksByAuthor(SortDirection.DECREASE);
        List<CustomBook> expected = SortByAuthorData.expectedResultDecreaseSort();
        assertEquals(actual, expected);
    }

    @Test
    public void sortBooksByEditionTestIncrease() {
        List<CustomBook> actual = bookListDao.sortBooksByEdition(SortDirection.INCREASE);
        List<CustomBook> expected = SortByEditionData.expectedResultIncreaseSort();
        assertEquals(actual, expected);
    }

    @Test
    public void sortBooksByEditionTestDecrease() {
        List<CustomBook> actual = bookListDao.sortBooksByEdition(SortDirection.DECREASE);
        List<CustomBook> expected = SortByEditionData.expectedResultDecreaseSort();
        assertEquals(actual, expected);
    }

    @Test
    public void sortBooksByYearTestIncrease() {
        List<CustomBook> actual = bookListDao.sortBooksByYear(SortDirection.INCREASE);
        List<CustomBook> expected = SortByYearData.expectedResultIncreaseSort();
        assertEquals(actual, expected);
    }

    @Test
    public void sortBooksByYearTestDecrease() {
        List<CustomBook> actual = bookListDao.sortBooksByYear(SortDirection.DECREASE);
        List<CustomBook> expected = SortByYearData.expectedResultDecreaseSort();
        assertEquals(actual, expected);
    }

    @Test
    public void sortBooksByPageTestIncrease() {
        List<CustomBook> actual = bookListDao.sortBooksByPage(SortDirection.INCREASE);
        List<CustomBook> expected = SortByPageData.expectedResultIncreaseSort();
        assertEquals(actual, expected);
    }

    @Test
    public void sortBooksByPageTestDecrease() {
        List<CustomBook> actual = bookListDao.sortBooksByPage(SortDirection.DECREASE);
        List<CustomBook> expected = SortByPageData.expectedResultDecreaseSort();
        assertEquals(actual, expected);
    }
}