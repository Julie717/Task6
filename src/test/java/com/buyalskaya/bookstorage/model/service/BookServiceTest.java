package com.buyalskaya.bookstorage.model.service;

import com.buyalskaya.bookstorage.dataprovider.*;
import com.buyalskaya.bookstorage.exception.LibraryException;
import com.buyalskaya.bookstorage.exception.ServiceException;
import com.buyalskaya.bookstorage.model.entity.CustomBook;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.*;

import static org.testng.Assert.*;

public class BookServiceTest {
    BookService bookService;

    @BeforeClass
    public void setUp() throws LibraryException {
        bookService = new BookService();
        InitialLibrary.initLibrary();
    }

    @DataProvider(name = "dataForBookAdd")
    public Object[][] dataForBookAdd() {
        return new Object[][]{
                {"___", "Mikhail Bulgakov", "Vintage", "1996", "384"},
                {"", "Mikhail Bulgakov", "Vintage", "1996", "384"},
                {"The Master and Margarita", "M. Bulgakov 1", "Vintage", "1996", "384"},
                {"The Master and Margarita", "", "Vintage", "1996", "384"},
                {"The Master and Margarita", "M. Bulgakov", "___", "1996", "384"},
                {"The Master and Margarita", "M. Bulgakov", "", "1996", "384"},
                {"The Master and Margarita", "M. Bulgakov", "Vintage", "2025", "384"},
                {"The Master and Margarita", "M. Bulgakov", "Vintage", "1300", "384"},
                {"The Master and Margarita", "M. Bulgakov", "Vintage", "-1", "384"},
                {"The Master and Margarita", "M. Bulgakov", "Vintage", "", "384"},
                {"The Master and Margarita", "M. Bulgakov", "Vintage", "1996", "17384"},
                {"The Master and Margarita", "M. Bulgakov", "Vintage", "1996", "0"},
                {"The Master and Margarita", "M. Bulgakov", "Vintage", "1996", ""},
                {"Harry Potter and the Philosopher's Stone", "J.K.Rowling", "Bloomsbury", "2014", "352"}
        };
    }

    @Test(dataProvider = "dataForBookAdd")
    public void bookAddTestParams(String name, String author, String edition,
                                  String year, String page) {
        assertThrows(ServiceException.class, () -> bookService.bookAdd(name, author, edition, year, page));
    }

    @DataProvider(name = "dataForActionWithId")
    public Object[][] dataForActionWithId() {
        return new Object[][]{
                {"ffffffff-de3f-445d-88d0-c77319426c36"},
                {"mn3ad7d6-de3f-445d-88d0-c77319426c36"},
                {"152748"},
                {""}
        };
    }

    @Test(dataProvider = "dataForActionWithId")
    public void removeByIdTestParams(String id) {
        assertThrows(ServiceException.class, () -> bookService.removeById(id));
    }

    @DataProvider(name = "dataForActionWithName")
    public Object[][] dataForRemoveByName() {
        return new Object[][]{
                {"The Master and Margarita"},
                {"147"},
                {""}
        };
    }

    @Test(dataProvider = "dataForActionWithName")
    public void removeByNameTestParams(String name) {
        assertThrows(ServiceException.class, () -> bookService.removeByName(name));
    }

    @Test
    public void findAllTestPositive() throws ServiceException {
        List<CustomBook> actual = bookService.findAll();
        List<CustomBook> expected = InitialLibrary.createInitialListBook();
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "dataForActionWithId")
    public void findByIdTestParams(String id) {
        assertThrows(ServiceException.class, () -> bookService.findById(id));
    }

    @Test
    public void findByIdTestPositive() throws ServiceException {
        CustomBook actual = bookService.findById("08335865-a91c-4632-a175-fb4ed9a37e78");
        UUID bookId = UUID.fromString("08335865-a91c-4632-a175-fb4ed9a37e78");
        String name = "Les Miserables";
        List<String> author = new ArrayList<>();
        author.add("Victor Hugo");
        String edition = "Canterbury Classics";
        int year = 2015;
        int page = 1264;
        CustomBook expected = new CustomBook(bookId, name, author, edition, year, page);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "dataForActionWithName")
    public void findByNameTestParams(String name) {
        assertThrows(ServiceException.class, () -> bookService.findByName(name));
    }

    @Test
    public void findByNameTestPositive() throws ServiceException {
        List<CustomBook> actual = bookService.findByName("Ninety-three");
        UUID bookId = UUID.fromString("af908285-53c4-46de-9d8a-5a6ac88014a0");
        String name = "Ninety-three";
        List<String> author = new ArrayList<>();
        author.add("Victor Hugo");
        String edition = "Peerless Press";
        int year = 2011;
        int page = 362;
        CustomBook book = new CustomBook(bookId, name, author, edition, year, page);
        List<CustomBook> expected = new ArrayList<>();
        expected.add(book);
        assertEquals(actual, expected);
    }

    @DataProvider(name = "dataForFindByAuthor")
    public Object[][] dataForFindByAuthor() {
        return new Object[][]{
                {"Daniel Defo"},
                {"147"},
                {""}
        };
    }

    @Test(dataProvider = "dataForFindByAuthor")
    public void findByAuthorTestParams(String author) {
        assertThrows(ServiceException.class, () -> bookService.findByAuthor(author));
    }

    @Test
    public void findByAuthorTestPositive() throws ServiceException {
        List<CustomBook> actual = bookService.findByAuthor("Jane Healey");
        UUID bookId = UUID.fromString("82728797-df92-4ef0-b099-cd542187741d");
        String name = "The Animals at Lockwood Manor";
        List<String> author = new ArrayList<>();
        author.add("Jane Healey");
        String edition = "Houghton Mifflin Harcourt";
        int year = 2020;
        int page = 352;
        CustomBook book = new CustomBook(bookId, name, author, edition, year, page);
        List<CustomBook> expected = new ArrayList<>();
        expected.add(book);
        assertEquals(actual, expected);
    }

    @DataProvider(name = "dataForFindByEdition")
    public Object[][] dataForFindByEdition() {
        return new Object[][]{
                {"Green Moon"},
                {"147"},
                {""}
        };
    }

    @Test(dataProvider = "dataForFindByEdition")
    public void findByEditionTestParams(String edition) {
        assertThrows(ServiceException.class, () -> bookService.findByEdition(edition));
    }

    @Test
    public void findByEditionTestPositive() throws ServiceException {
        List<CustomBook> actual = bookService.findByEdition("Oxford University Press");
        UUID bookId = UUID.fromString("5d7f2a66-1959-4b28-ba3a-bf08fcda0ebe");
        String name = "Notre-Dame de Paris";
        List<String> author = new ArrayList<>();
        author.add("Victor Hugo");
        String edition = "Oxford University Press, Reissue edition";
        int year = 2009;
        int page = 592;
        CustomBook book = new CustomBook(bookId, name, author, edition, year, page);
        List<CustomBook> expected = new ArrayList<>();
        expected.add(book);
        assertEquals(actual, expected);
    }

    @DataProvider(name = "dataForFindByYear")
    public Object[][] dataForFindByYear() {
        return new Object[][]{
                {"2075"},
                {"-14"},
                {"0"},
                {"1999"},
                {""}
        };
    }

    @Test(dataProvider = "dataForFindByYear")
    public void findByYearTestParams(String year) {
        assertThrows(ServiceException.class, () -> bookService.findByYear(year));
    }

    @Test
    public void findByYearTestPositive() throws ServiceException {
        List<CustomBook> actual = bookService.findByYear("2009");
        UUID bookId = UUID.fromString("5d7f2a66-1959-4b28-ba3a-bf08fcda0ebe");
        String name = "Notre-Dame de Paris";
        List<String> author = new ArrayList<>();
        author.add("Victor Hugo");
        String edition = "Oxford University Press, Reissue edition";
        int year = 2009;
        int page = 592;
        CustomBook book = new CustomBook(bookId, name, author, edition, year, page);
        List<CustomBook> expected = new ArrayList<>();
        expected.add(book);
        assertEquals(actual, expected);
    }

    @DataProvider(name = "dataForFindByPage")
    public Object[][] dataForFindByPage() {
        return new Object[][]{
                {"20750"},
                {"-14"},
                {"0"},
                {"19"},
                {""}
        };
    }

    @Test(dataProvider = "dataForFindByPage")
    public void findByPageTestParams(String page) {
        assertThrows(ServiceException.class, () -> bookService.findByPage(page));
    }

    @Test
    public void findByPageTestPositive() throws ServiceException {
        List<CustomBook> actual = bookService.findByPage("592");
        UUID bookId = UUID.fromString("5d7f2a66-1959-4b28-ba3a-bf08fcda0ebe");
        String name = "Notre-Dame de Paris";
        List<String> author = new ArrayList<>();
        author.add("Victor Hugo");
        String edition = "Oxford University Press, Reissue edition";
        int year = 2009;
        int page = 592;
        CustomBook book = new CustomBook(bookId, name, author, edition, year, page);
        List<CustomBook> expected = new ArrayList<>();
        expected.add(book);
        assertEquals(actual, expected);
    }

    @Test
    public void sortByNameTestIncrease() throws ServiceException {
        List<CustomBook> actual = bookService.sortByName("increase");
        List<CustomBook> expected = SortByNameData.expectedResultIncreaseSort();
        assertEquals(actual, expected);
    }

    @Test
    public void sortByNameTestDecrease() throws ServiceException {
        List<CustomBook> actual = bookService.sortByName("Decrease");
        List<CustomBook> expected = SortByNameData.expectedResultDecreaseSort();
        assertEquals(actual, expected);
    }

    @Test
    public void sortByNameTestNegative() {
        assertThrows(ServiceException.class, () -> bookService.sortByName("123"));
    }

    @Test
    public void sortByAuthorTestIncrease() throws ServiceException {
        List<CustomBook> actual = bookService.sortByAuthor("increase");
        List<CustomBook> expected = SortByAuthorData.expectedResultIncreaseSort();
        assertEquals(actual, expected);
    }

    @Test
    public void sortByAuthorTestDecrease() throws ServiceException {
        List<CustomBook> actual = bookService.sortByAuthor("Decrease");
        List<CustomBook> expected = SortByAuthorData.expectedResultDecreaseSort();
        assertEquals(actual, expected);
    }

    @Test
    public void sortByAuthorTestNegative() {
        assertThrows(ServiceException.class, () -> bookService.sortByAuthor(""));
    }

    @Test
    public void sortByEditionTestIncrease() throws ServiceException {
        List<CustomBook> actual = bookService.sortByEdition("increase");
        List<CustomBook> expected = SortByEditionData.expectedResultIncreaseSort();
        assertEquals(actual, expected);
    }

    @Test
    public void sortByEditionTestDecrease() throws ServiceException {
        List<CustomBook> actual = bookService.sortByEdition("Decrease");
        List<CustomBook> expected = SortByEditionData.expectedResultDecreaseSort();
        assertEquals(actual, expected);
    }

    @Test
    public void sortByEditionTestNegative() {
        assertThrows(ServiceException.class, () -> bookService.sortByEdition("any"));
    }

    @Test
    public void sortByYearTestIncrease() throws ServiceException {
        List<CustomBook> actual = bookService.sortByYear("increase");
        List<CustomBook> expected = SortByYearData.expectedResultIncreaseSort();
        assertEquals(actual, expected);
    }

    @Test
    public void sortByYearTestDecrease() throws ServiceException {
        List<CustomBook> actual = bookService.sortByYear("Decrease");
        List<CustomBook> expected = SortByYearData.expectedResultDecreaseSort();
        assertEquals(actual, expected);
    }

    @Test
    public void sortByYearTestNegative() {
        assertThrows(ServiceException.class, () -> bookService.sortByYear(""));
    }

    @Test
    public void sortByPageTestIncrease() throws ServiceException {
        List<CustomBook> actual = bookService.sortByPage("increase");
        List<CustomBook> expected = SortByPageData.expectedResultIncreaseSort();
        assertEquals(actual, expected);
    }

    @Test
    public void sortByPageTestDecrease() throws ServiceException {
        List<CustomBook> actual = bookService.sortByPage("Decrease");
        List<CustomBook> expected = SortByPageData.expectedResultDecreaseSort();
        assertEquals(actual, expected);
    }

    @Test
    public void sortByPageTestNegative() {
        assertThrows(ServiceException.class, () -> bookService.sortByPage(""));
    }
}