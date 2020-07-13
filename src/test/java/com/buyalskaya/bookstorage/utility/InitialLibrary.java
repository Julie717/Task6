package com.buyalskaya.bookstorage.utility;

import com.buyalskaya.bookstorage.model.entity.CustomBook;
import com.buyalskaya.bookstorage.model.entity.Library;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class InitialLibrary {
    public static List<CustomBook> books;

    public static void initLibrary() {
        books = new ArrayList<>();
        UUID bookId = UUID.fromString("ea357cdf-fee1-4b76-a3b3-d8f9cdc07f3f");
        String name = "Harry Potter and the Philosopher's Stone";
        List<String> author = new ArrayList<>();
        author.add("J.K.Rowling");
        String edition = "Bloomsbury";
        int year = 2014;
        int page = 352;
        CustomBook book = new CustomBook(bookId, name, author, edition, year, page);
        books.add(book);

        bookId = UUID.fromString("730bd030-69a2-4d74-8183-45053437043f");
        name = "Harry Potter and the Chamber of Secrets";
        author = new ArrayList<>();
        author.add("J.K.Rowling");
        edition = "Bloomsbury";
        year = 2014;
        page = 384;
        book = new CustomBook(bookId, name, author, edition, year, page);
        books.add(book);

        bookId = UUID.fromString("b63ad7d6-de3f-445d-88d0-c77319426c36");
        name = "Harry Potter and the Prisoner of Azkaban";
        author = new ArrayList<>();
        author.add("J.K.Rowling");
        edition = "Bloomsbury";
        year = 2014;
        page = 480;
        book = new CustomBook(bookId, name, author, edition, year, page);
        books.add(book);

        bookId = UUID.fromString("6a87f4a7-3e0e-43d0-b74d-bc8f90f62702");
        name = "Harry Potter and the Goblet of Fire";
        author = new ArrayList<>();
        author.add("J.K.Rowling");
        edition = "Bloomsbury";
        year = 2014;
        page = 640;
        book = new CustomBook(bookId, name, author, edition, year, page);
        books.add(book);

        bookId = UUID.fromString("9a87cd94-ee92-4d13-8ca9-e8ef49d3f67d");
        name = "Harry Potter and the Order of the Phoenix";
        author = new ArrayList<>();
        author.add("J.K.Rowling");
        edition = "Bloomsbury";
        year = 2014;
        page = 816;
        book = new CustomBook(bookId, name, author, edition, year, page);
        books.add(book);

        bookId = UUID.fromString("20b020a3-51cb-4dd4-9267-eb997aa8e630");
        name = "Harry Potter and the Half-Blood Prince";
        author = new ArrayList<>();
        author.add("J.K.Rowling");
        edition = "Bloomsbury";
        year = 2014;
        page = 560;
        book = new CustomBook(bookId, name, author, edition, year, page);
        books.add(book);

        bookId = UUID.fromString("28b22d61-e6bf-4763-9b8f-548417a6dc41");
        name = "Harry Potter and the Deathly Hallows";
        author = new ArrayList<>();
        author.add("J.K.Rowling");
        edition = "Bloomsbury";
        year = 2014;
        page = 640;
        book = new CustomBook(bookId, name, author, edition, year, page);
        books.add(book);


        bookId = UUID.fromString("5d7f2a66-1959-4b28-ba3a-bf08fcda0ebe");
        name = "Notre-Dame de Paris";
        author = new ArrayList<>();
        author.add("Victor Hugo");
        edition = "Oxford University Press, Reissue edition";
        year = 2009;
        page = 592;
        book = new CustomBook(bookId, name, author, edition, year, page);
        books.add(book);

        bookId = UUID.fromString("08335865-a91c-4632-a175-fb4ed9a37e78");
        name = "Les Miserables";
        author = new ArrayList<>();
        author.add("Victor Hugo");
        edition = "Canterbury Classics";
        year = 2015;
        page = 1264;
        book = new CustomBook(bookId, name, author, edition, year, page);
        books.add(book);

        bookId = UUID.fromString("af908285-53c4-46de-9d8a-5a6ac88014a0");
        name = "Ninety-three";
        author = new ArrayList<>();
        author.add("Victor Hugo");
        edition = "Peerless Press";
        year = 2011;
        page = 362;
        book = new CustomBook(bookId, name, author, edition, year, page);
        books.add(book);

        bookId = UUID.fromString("703ffb17-d2f8-436f-8ef3-60018c2c3577");
        name = "The Man Who Laughs";
        author = new ArrayList<>();
        author.add("Victor Hugo");
        edition = "Moorside Press";
        year = 2013;
        page = 368;
        book = new CustomBook(bookId, name, author, edition, year, page);
        books.add(book);

        bookId = UUID.fromString("abd2a107-36ee-4509-869e-6cee81a2c539");
        name = "Humans";
        author = new ArrayList<>();
        author.add("Brandon Stanton");
        edition = "St. Martin's Press";
        year = 2020;
        page = 448;
        book = new CustomBook(bookId, name, author, edition, year, page);
        books.add(book);

        bookId = UUID.fromString("82728797-df92-4ef0-b099-cd542187741d");
        name = "The Animals at Lockwood Manor";
        author = new ArrayList<>();
        author.add("Jane Healey");
        edition = "Houghton Mifflin Harcourt";
        year = 2020;
        page = 352;
        book = new CustomBook(bookId, name, author, edition, year, page);
        books.add(book);

        bookId = UUID.fromString("15a5e40d-d886-422e-90bf-d81cc9fcd8a0");
        name = "A Fall of Marigolds";
        author = new ArrayList<>();
        author.add("Susan Meissner");
        edition = "Houghton Mifflin Harcourt";
        year = 2014;
        page = 400;
        book = new CustomBook(bookId, name, author, edition, year, page);
        books.add(book);

        bookId = UUID.fromString("a348a970-fed2-4b51-92b9-711bc4d27835");
        name = "The Summer House";
        author = new ArrayList<>();
        author.add("James Patterson");
        author.add("Brendan DuBois");
        edition = "Little, Brown and Company";
        year = 2020;
        page = 448;
        book = new CustomBook(bookId, name, author, edition, year, page);
        books.add(book);

        Library.setBooks(books);
      //  books.add(book);
        /*
CustomBook[bookId=7c7449cb-99d9-453b-bbfc-31e3af90b96e, name='Find Me', author=[Anne Frasier], edition='Thomas & Mercer', year=2020, page=285]
CustomBook[bookId=e451d537-6fe2-4972-bbff-8f38d00fa61c, name='Scarlet Odyssey', author=[C.T.Rwizi], edition='47North', year=2020, page=518]
CustomBook[bookId=d77854da-58d2-4f0b-afa3-2cf1fae24ace, name='Fair Warning', author=[Michael Connelly], edition='Little, Brown and Company', year=2020, page=416]
CustomBook[bookId=9ee8ffc4-7449-497c-9cd7-eab886024b42, name='SAT Prep Black Book: The Most Effective SAT Strategies Ever Published', author=[Mike Barrett, Patrick Barrett], edition='ACT Prep Books', year=2020, page=576]
CustomBook[bookId=aa920966-6094-4237-b6ad-7dacb2f452fd, name='The Montessori Toddler: A Parent's Guide to Raising a Curious and Responsible Human Being', author=[Simone Davies, Hiyoko Imai], edition='Workman Publishing Company', year=2019, page=256]
CustomBook[bookId=68546ef5-5313-4154-8d3a-12f33fe7ae8a, name='Montessori from the Start: The Child at Home, from Birth to Age Three', author=[Paula Polk Lillard, Lynn Lillard Jessen], edition='Schocken', year=2003, page=304]
CustomBook[bookId=95f6a13d-0ae0-4ffa-8243-9e69a9202cd2, name='Guide to Colorado Backroads & 4-Wheel-Drive Trails', author=[Charles A. Wells, Matt Peterson], edition='Funtreks Inc', year=2019, page=236]
CustomBook[bookId=5aba7da3-9301-4cda-adb4-7fd42c36806e, name='The Warmth of Other Suns: The Epic Story of America's Great Migration', author=[Isabel Wilkerson], edition='Vintage', year=2011, page=640]
CustomBook[bookId=ffff70e7-4552-49a6-960e-6d7101bb98fe, name='If It Bleeds', author=[Stephen King], edition='Scribner', year=2020, page=448]
CustomBook[bookId=c01cad91-873e-42ca-b267-e1267e1bd201, name='The Institute', author=[Stephen King], edition='Gallery Books', year=2020, page=576]
CustomBook[bookId=d9d60f47-6989-4f00-8a2e-4b5fbc88b027, name='Memoirs and Misinformation', author=[Jim Carrey, Dana Vachon], edition='Knopf', year=2020, page=272]
*/
    }
}
