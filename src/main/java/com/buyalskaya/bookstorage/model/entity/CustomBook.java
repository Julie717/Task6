package com.buyalskaya.bookstorage.model.entity;

import com.buyalskaya.bookstorage.utility.IdCreator;

import java.util.List;
import java.util.StringJoiner;
import java.util.UUID;

public class CustomBook {
    private UUID bookId;
    private String name;
    private List<String> author;
    private String edition;
    private int year;
    private int page;

    public CustomBook(String name, List<String> author, String edition, int year, int page) {
        bookId = IdCreator.createId();
        this.name = name;
        this.author = author;
        this.edition = edition;
        this.year = year;
        this.page = page;
    }

    public CustomBook(UUID bookId, String name, List<String> author, String edition, int year, int page) {
        this.bookId = bookId;
        this.name = name;
        this.author = author;
        this.edition = edition;
        this.year = year;
        this.page = page;
    }

    public CustomBook(String bookId, String name, List<String> author, String edition, int year, int page) {
        this.bookId = UUID.fromString(bookId);
        this.name = name;
        this.author = author;
        this.edition = edition;
        this.year = year;
        this.page = page;
    }

    public UUID getBookId() {
        return bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getAuthor() {
        return author;
    }

    public void setAuthor(List<String> author) {
        this.author = author;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj == null) || (getClass() != obj.getClass())) {
            return false;
        }
        CustomBook book = (CustomBook) obj;
        if ((bookId == null ^ book.bookId == null) ||
                (bookId != null && book.bookId != null && !bookId.equals(book.bookId))) {
            return false;
        }
        if ((name == null ^ book.name == null) ||
                (name != null && book.name != null && !name.equals(book.name))) {
            return false;
        }
        if ((author == null ^ book.author == null) ||
                (author != null && book.author != null && !author.equals(book.author))) {
            return false;
        }
        if ((edition == null ^ book.edition == null) ||
                (edition != null && book.edition != null && !edition.equals(book.edition))) {
            return false;
        }
        return (year == book.year) && (page == book.page);
    }

    @Override
    public int hashCode() {
        return bookId.hashCode() + name.hashCode() + author.hashCode() + edition.hashCode() + year + page * 31;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CustomBook.class.getSimpleName() + "[", "]")
                .add("bookId=" + bookId)
                .add("name='" + name + "'")
                .add("author=" + author)
                .add("edition='" + edition + "'")
                .add("year=" + year)
                .add("page=" + page)
                .toString();
    }
}
