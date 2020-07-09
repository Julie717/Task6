package com.buyalskaya.bookstorage.model.validator;

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
    private static final String CHECK_NUMBER = "\\d+";

    public boolean isPositiveIntegerNumber(String number) {
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
            if (!validateOneAuthor(oneAuthor)) {
                return false;
            }
        }
        return true;
    }

    private boolean validateOneAuthor(String author) {
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

    public boolean validateYear(int year) {
        return year >= MIN_YEAR && year <= MAX_YEAR;
    }

    public boolean validatePage(int page) {
        return page >= MIN_PAGE && page <= MAX_PAGE;
    }
}
