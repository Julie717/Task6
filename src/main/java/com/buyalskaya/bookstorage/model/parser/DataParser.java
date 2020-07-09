package com.buyalskaya.bookstorage.model.parser;

import com.buyalskaya.bookstorage.controller.command.CommandName;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataParser {
    private static final String REGEX_COMMAND = "request=([\\pL\\s]+);";
    private static final String REGEX_BOOK_ID = "id=([abcdefABCDEF\\d]{8}-([abcdefABCDEF\\d]{4}-){3}[abcdefABCDEF\\d]{12});";
    private static final String REGEX_BOOK_NAME = "name=([^;]+);";
    private static final String REGEX_BOOK_AUTHOR = "author=([^;]+);";
    private static final String REGEX_BOOK_EDITION = "edition=([^;]+);";
    private static final String REGEX_BOOK_YEAR = "year=(\\d+);";
    private static final String REGEX_BOOK_PAGE = "page=(\\d+);";
    private static final String REGEX_COMMA = ",";
    private static final String EMPTY_STRING = "";

    public String commandParser(String request) {
        Pattern pattern = Pattern.compile(REGEX_COMMAND);
        Matcher matcher = pattern.matcher(request);
        String command = EMPTY_STRING;
        if (matcher.find()) {
            command = matcher.group(1).trim();
        }
        return command;
    }

    public List<String> bookParametersParser(String request) {
        List<String> parameters = new ArrayList<>();
        parameters.add(searchParameter(request, REGEX_BOOK_NAME));
        parameters.add(searchParameter(request, REGEX_BOOK_AUTHOR));
        parameters.add(searchParameter(request, REGEX_BOOK_EDITION));
        parameters.add(searchParameter(request, REGEX_BOOK_YEAR));
        parameters.add(searchParameter(request, REGEX_BOOK_PAGE));
        return parameters;
    }

    public String oneBookParameterParser(String request, CommandName commandName) {
        String regexExp = EMPTY_STRING;
        switch (commandName) {
            case REMOVE:
            case FIND_BY_ID:
                regexExp = REGEX_BOOK_ID;
                break;
            case FIND_BY_NAME:
            regexExp = REGEX_BOOK_NAME;
                break;
            case FIND_BY_AUTHOR:
                regexExp = REGEX_BOOK_AUTHOR;
                break;
            case FIND_BY_EDITION:
                regexExp = REGEX_BOOK_EDITION;
                break;
            case FIND_BY_YEAR:
                regexExp = REGEX_BOOK_YEAR;
                break;
            case FIND_BY_PAGE:
                regexExp = REGEX_BOOK_PAGE;
                break;
        }
        return (regexExp.isEmpty()) ? EMPTY_STRING : searchParameter(request, regexExp);
    }

    public List<String> authorParser(String author) {
        String[] authorsArray = author.split(REGEX_COMMA);
        return Stream.of(authorsArray).map(p -> p.trim()).collect(Collectors.toList());
    }

    private String searchParameter(String request, String regexExp) {
        Pattern pattern = Pattern.compile(regexExp);
        Matcher matcher = pattern.matcher(request);
        String parameter = EMPTY_STRING;
        if (matcher.find()) {
            parameter = matcher.group(1).trim();
        }
        return parameter;
    }
}