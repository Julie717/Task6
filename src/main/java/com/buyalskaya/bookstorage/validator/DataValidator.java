package com.buyalskaya.bookstorage.validator;

import com.buyalskaya.bookstorage.model.entity.SortDirection;

import java.time.LocalDate;
import java.util.List;
import java.util.regex.Pattern;

public class DataValidator {

    private final static String REGEX_LETTER = ".*\\pL.*";
    private final static String REGEX_ID = "[abcdefABCDEF\\d]{8}-([abcdefABCDEF\\d]{4}-){3}[abcdefABCDEF\\d]{12}";
    private final static String REGEX_AUTHOR = "(\\pL[\\pL\\s]+)|(\\pL\\.(\\s)*(\\pL\\.(\\s)*)?\\pL+)";
    private final static int MIN_YEAR = 1400;
    private final static int MAX_YEAR = LocalDate.now().getYear();
    private final static int MIN_PAGE = 1;
    private final static int MAX_PAGE = 10000;
    private final static String CHECK_NUMBER = "\\d+";

    private boolean isPositiveIntegerNumber(String number) {
        if (number == null) {
            return false;
        }
        return Pattern.matches(CHECK_NUMBER, number);
    }

    public boolean validateId(String id) {
        if (id == null || id.isEmpty()) {
            return false;
        }
        return Pattern.matches(REGEX_ID, id);
    }

    public boolean validateName(String name) {
        if (name == null || name.isEmpty()) {
            return false;
        }
        return Pattern.matches(REGEX_LETTER, name);
    }

    public boolean validateAuthor(List<String> author) {
        if (author == null) {
            return false;
        }
        for (String oneAuthor : author) {
            if (!validateAuthor(oneAuthor)) {
                return false;
            }
        }
        return true;
    }

    public boolean validateAuthor(String author) {
        if (author == null || author.isEmpty()) {
            return false;
        }
        return Pattern.matches(REGEX_AUTHOR, author);
    }

    public boolean validateEdition(String edition) {
        if (edition == null || edition.isEmpty()) {
            return false;
        }
        return Pattern.matches(REGEX_LETTER, edition);
    }

    public boolean validateYear(String year) {
        boolean isCorrectYear = false;
        if (isPositiveIntegerNumber(year)) {
            int yearNumber = Integer.parseInt(year);
            isCorrectYear = (yearNumber >= MIN_YEAR && yearNumber <= MAX_YEAR);
        }
        return isCorrectYear;
    }

    public boolean validatePage(String page) {
        boolean isCorrectPage = false;
        if (isPositiveIntegerNumber(page)) {
            int pageNumber = Integer.parseInt(page);
            isCorrectPage = (pageNumber >= MIN_PAGE && pageNumber <= MAX_PAGE);
        }
        return isCorrectPage;
    }

    public boolean validateSortDirection(String sortDirection) {
        if (sortDirection == null || sortDirection.isEmpty()) {
            return false;
        }
        String directionUpper = sortDirection.toUpperCase();
        for (SortDirection direction : SortDirection.values()) {
            if (directionUpper.equals(direction.toString())) {
                return true;
            }
        }
        return false;
    }
}