package com.buyalskaya.bookstorage.model.validator;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class DataValidatorTest {
    DataValidator dataValidator;

    @BeforeClass
    public void setUp() {
        dataValidator = new DataValidator();
    }

    @DataProvider(name = "dataForIsPositiveIntegerNumber")
    public Object[][] dataForIsPositiveIntegerNumber() {
        return new Object[][]{
                {"7", true},
                {"1", true},
                {"0", true},
                {"-4", false},
                {"11.5", false},
                {"one", false},
                {"7.", false},
                {"1E-9", false},
                {null, false}
        };
    }

    @Test(dataProvider = "dataForIsPositiveIntegerNumber")
    public void isPositiveIntegerNumberTestParams(String number, boolean expected) {
        boolean actual = dataValidator.isPositiveIntegerNumber(number);
        assertEquals(actual, expected);
    }

    @DataProvider(name = "dataForValidateId")
    public Object[][] dataForValidateId() {
        return new Object[][]{
                {"09054ea5-9564-4d64-ad14-8f0a1df3bc27", true},
                {"09054EA5-9564-4d64-ad14-8f0a1df3bc27", true},
                {"", false},
                {"1234", false},
                {"09054EA5-9564-4k64-ad14-8f0a1df3bc27", false},
                {null, false}
        };
    }

    @Test(dataProvider = "dataForValidateId")
    public void validateIdTestParams(String id, boolean expected) {
        boolean actual = dataValidator.validateId(id);
        assertEquals(actual, expected);
    }


    @DataProvider(name = "dataForValidateStringParameter")
    public Object[][] dataForValidateStringParameter() {
        return new Object[][]{
                {"World", true},
                {".", false},
                {"", false},
                {"4", false},
                {null, false}
        };
    }

    @Test(dataProvider = "dataForValidateStringParameter")
    public void validateNameTestParams(String name, boolean expected) {
        boolean actual = dataValidator.validateName(name);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "dataForValidateStringParameter")
    public void validateEditionTestParams(String edition, boolean expected) {
        boolean actual = dataValidator.validateEdition(edition);
        assertEquals(actual, expected);
    }

    @DataProvider(name = "dataForValidateAuthor")
    public Object[][] dataForValidateAuthor() {
        return new Object[][]{
                {Arrays.asList("J.K.Rowling", "Victor Hugo", "Александр Сергеевич Пушкин", "S. King"), true},
                {Arrays.asList("S.S.S.King", "Victor Hugo"), false},
                {Arrays.asList("Victor Hugo", ""), false},
                {Arrays.asList("Victor Hugo", " "), false},
                {Arrays.asList("Victor Hugo", "4"), false},
                {Arrays.asList("Victor Hugo", null), false},
                {null, false},
        };
    }

    @Test(dataProvider = "dataForValidateAuthor")
    public void validateAuthorTestParams(List<String> author, boolean expected) {
        boolean actual = dataValidator.validateAuthor(author);
        assertEquals(actual, expected);
    }

    @DataProvider(name = "dataForValidateYear")
    public Object[][] dataForValidateYear() {
        return new Object[][]{
                {1996, true},
                {1876, true},
                {0, false},
                {-15, false},
                {1300, false},
                {2025, false}
        };
    }

    @Test(dataProvider = "dataForValidateYear")
    public void validateYearTestParams(int year, boolean expected) {
        boolean actual = dataValidator.validateYear(year);
        assertEquals(actual, expected);
    }

    @DataProvider(name = "dataForValidatePage")
    public Object[][] dataForValidatePage() {
        return new Object[][]{
                {195, true},
                {987, true},
                {0, false},
                {-15, false},
                {13000, false}
        };
    }

    @Test(dataProvider = "dataForValidatePage")
    public void validatePageTestParams(int year, boolean expected) {
        boolean actual = dataValidator.validatePage(year);
        assertEquals(actual, expected);
    }
}