package com.buyalskaya.bookstorage.controller;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class BookControllerTest {
    BookController bookController;

    @BeforeClass
    public void setUp() {
        bookController = new BookController();
    }

    @DataProvider(name = "dataForChooseAction")
    public Object[][] dataForChooseAction() {
        return new Object[][]{
                {"request=; name=The Master and Margarita; author=Mikhail Bulgakov; " +
                        "edition=Vintage; year=1996; page=384;", "response=Error; message=Command not found"},
                {"request=addBook; name=The Master and Margarita; author=Mikhail Bulgakov; " +
                        "edition=Vintage; year=1996; page=384;", "response=Error; message=Command not found"},
                {"request=add; name=The Master and Margarita; author=Mikhail Bulgakov; " +
                        "edition=Vintage; year=1996; page=384;", "response=Correct; message=The book was added"},
                {"request=add; name=124; author=Mikhail Bulgakov; " +
                        "edition=Vintage; year=1996; page=384;", "response=Error; message=Incorrect book parameters"},
                {"request=add; name=The Master and Margarita; author=Mikhail Bulgakov; " +
                        "edition=Vintage; year=1996; page=;", "response=Error; message=Incorrect book parameters"},
                {"request=add; author=Mikhail Bulgakov; " +
                        "edition=Vintage; year=1996; page=;", "response=Error; message=Incorrect book parameters"},
                {"request=add; name=Humans; author=Brandon Stanton; edition=St. Martin's Press;" +
                        " year=2020; page=448;", "response=Error; message=This book is already in storage"},
                {"request=findByName; name=Humans;","response=Correct;"}
        };
    }

    @Test(dataProvider = "dataForChooseAction")
    public void chooseActionTestParams(String request, String expected) {
        String actual = bookController.chooseAction(request);
        assertEquals(actual, expected);
    }
}
