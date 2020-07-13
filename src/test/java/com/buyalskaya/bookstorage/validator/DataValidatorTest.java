package com.buyalskaya.bookstorage.validator;

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
                {"1996", true},
                {"1876", true},
                {"0", false},
                {"-15", false},
                {"1300", false},
                {"2025", false},
                {"one", false},
                {"", false},
                {null, false}
        };
    }

    @Test(dataProvider = "dataForValidateYear")
    public void validateYearTestParams(String year, boolean expected) {
        boolean actual = dataValidator.validateYear(year);
        assertEquals(actual, expected);
    }

    @DataProvider(name = "dataForValidatePage")
    public Object[][] dataForValidatePage() {
        return new Object[][]{
                {"195", true},
                {"987", true},
                {"0", false},
                {"-15", false},
                {"13000", false},
                {"15o8", false},
                {"", false},
                {null, false}
        };
    }

    @Test(dataProvider = "dataForValidatePage")
    public void validatePageTestParams(String page, boolean expected) {
        boolean actual = dataValidator.validatePage(page);
        assertEquals(actual, expected);
    }

    @DataProvider(name = "dataForValidateSortDirection")
    public Object[][] dataForValidateSortDirection() {
        return new Object[][]{
                {"increase", true},
                {"decrease", true},
                {"Increase", true},
                {"Decrease", true},
                {"INCREASE", true},
                {"DECREASE", true},
                {"ANY", false},
                {"", false},
                {null, false}
        };
    }

    @Test(dataProvider = "dataForValidateSortDirection")
    public void validateSortDirectionTestParams(String sortDirection, boolean expected) {
        boolean actual = dataValidator.validateSortDirection(sortDirection);
        assertEquals(actual, expected);
    }
}