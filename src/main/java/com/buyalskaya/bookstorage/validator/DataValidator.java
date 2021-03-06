package com.buyalskaya.bookstorage.validator;

import com.buyalskaya.bookstorage.model.entity.SortDirection;

import java.time.LocalDate;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

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
        boolean isValid = false;
        if (number != null) {
            isValid = Pattern.matches(CHECK_NUMBER, number);
        }
        return isValid;
    }

    public boolean isIdValid(String id) {
        boolean isValid = false;
        if (id != null && !id.isEmpty()) {
            isValid = Pattern.matches(REGEX_ID, id);
        }
        return isValid;
    }

    public boolean isNameValid(String name) {
        boolean isValid = false;
        if (name != null && !name.isEmpty()) {
            isValid = Pattern.matches(REGEX_LETTER, name);
        }
        return isValid;
    }

    public boolean isAuthorValid(List<String> author) {
        boolean isValid = false;
        if (author != null) {
            isValid = author.stream().allMatch(a -> isAuthorValid(a));
        }
        return isValid;
    }

    public boolean isAuthorValid(String author) {
        boolean isValid = false;
        if (author != null && !author.isEmpty()) {
            isValid = Pattern.matches(REGEX_AUTHOR, author);
        }
        return isValid;
    }

    public boolean isEditionValid(String edition) {
        boolean isValid = false;
        if (edition != null && !edition.isEmpty()) {
            isValid = Pattern.matches(REGEX_LETTER, edition);
        }
        return isValid;
    }

    public boolean isYearValid(String year) {
        boolean isValid = false;
        if (isPositiveIntegerNumber(year)) {
            int yearNumber = Integer.parseInt(year);
            isValid = (yearNumber >= MIN_YEAR && yearNumber <= MAX_YEAR);
        }
        return isValid;
    }

    public boolean isPageValid(String page) {
        boolean isValid = false;
        if (isPositiveIntegerNumber(page)) {
            int pageNumber = Integer.parseInt(page);
            isValid = (pageNumber >= MIN_PAGE && pageNumber <= MAX_PAGE);
        }
        return isValid;
    }

    public boolean isSortDirectionValid(String sortDirection) {
        boolean isValid = false;
        if (sortDirection != null && !sortDirection.isEmpty()) {
            String directionUpper = sortDirection.toUpperCase();
            isValid = Stream.of(SortDirection.values())
                    .anyMatch(d -> directionUpper.equals(d.toString()));
        }
        return isValid;
    }
}