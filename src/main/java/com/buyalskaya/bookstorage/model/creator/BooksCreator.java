package com.buyalskaya.bookstorage.model.creator;

import com.buyalskaya.bookstorage.model.entity.CustomBook;
import com.buyalskaya.bookstorage.model.parser.DataParser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BooksCreator {

    private static final String REGEX_BOOK_PARAMETERS = "name=(.+);\\s*author=(.+);\\s*edition=(.+);" +
            "\\s*year=(\\d+);\\s*page=(\\d+)\\s*";

    public List<CustomBook> createInitialBooks(List<String> parameters) {
        DataParser dataParser=new DataParser();
        List<CustomBook> booksList = new ArrayList<>();
        Pattern pattern = Pattern.compile(REGEX_BOOK_PARAMETERS);
        Matcher matcher;
        CustomBook book;
        String name;
        List<String> author;
        String edition;
        int year;
        int page;
        for (String parameter : parameters) {
            matcher = pattern.matcher(parameter);
            matcher.find();
            name = matcher.group(1).trim();
            author = dataParser.authorParser(matcher.group(2).trim());
            edition = matcher.group(3).trim();
            year = Integer.parseInt(matcher.group(4).trim());
            page = Integer.parseInt(matcher.group(5).trim());
            book = new CustomBook(name, author, edition, year, page);
            booksList.add(book);
        }
        return booksList;
    }
}