package com.buyalskaya.bookstorage.parser;

import com.buyalskaya.bookstorage.controller.command.CommandName;
import com.buyalskaya.bookstorage.model.parser.DataParser;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import java.util.List;

import static org.testng.Assert.*;

public class DataParserTest {
    DataParser dataParser;

    @BeforeClass
    public void setUp() {
        dataParser = new DataParser();
    }

    @DataProvider(name = "dataForCommandParser")
    public Object[][] dataForCommandParser() {
        return new Object[][]{
                {"request=remove; id=09054ea5-9564-4d64-ad14-8f0a1df3bc27;", "remove"},
                {"some text... request=add; ...", "add"},
                {"some text... request=findByName; ...", "findByName"},
                {"some text... request= ...", ""}
        };
    }

    @Test(dataProvider = "dataForCommandParser")
    public void commandParserTestParams(String request, String expected) {
        String actual = dataParser.commandParser(request);
        assertEquals(actual, expected);
    }

    @DataProvider(name = "dataForBookParametersParser")
    public Object[][] dataForBookParametersParser() {
        return new Object[][]{
                {"request=add; name=The Master and Margarita; author=Mikhail Bulgakov; " +
                        "edition=Vintage; year=1996; page=384;",
                        List.of("The Master and Margarita", "Mikhail Bulgakov", "Vintage",
                                "1996", "384")},
                {"request=add; name=Computer Networking: A Top-Down Approach; " +
                        "author=James Kurose, Keith Ross; " +
                        "edition=Pearson; year=2016; page=864;",
                        List.of("Computer Networking: A Top-Down Approach", "James Kurose, Keith Ross",
                                "Pearson", "2016", "864")},
                {"request=add; name=Computer Networking: A Top-Down Approach; " +
                        "author=; " +
                        "edition=Pearson; year=2016; page=864;",
                        List.of("Computer Networking: A Top-Down Approach", "",
                                "Pearson", "2016", "864")}
        };
    }

    @Test(dataProvider = "dataForBookParametersParser")
    public void bookParametersParserTestParams(String request, List<String> expected) {
        List<String> actual = dataParser.bookParametersParser(request);
        assertEquals(actual, expected);
    }

    @DataProvider(name = "dataForOneBookParameterParser")
    public Object[][] dataForOneBookParameterParser() {
        return new Object[][]{
                {"request=remove; id=09054ea5-9564-4d64-ad14-8f0a1df3bc27; name=The Master and Margarita; author=Mikhail Bulgakov; " +
                        "edition=Vintage; year=1996; page=384;", CommandName.REMOVE,
                        "09054ea5-9564-4d64-ad14-8f0a1df3bc27"},
                {"request=findByYear; year=2016;", CommandName.FIND_BY_YEAR, "2016"},
                {"request=sortByName; name=Computer Networking: A Top-Down Approach; ", CommandName.SORT_BY_NAME, ""},
                {"request=; name=Computer Networking: A Top-Down Approach; ", CommandName.SORT_BY_NAME, ""}
        };
    }

    @Test(dataProvider = "dataForOneBookParameterParser")
    public void oneBookParameterParserTestParams(String request, CommandName commandName, String expected) {
        String actual = dataParser.oneBookParameterParser(request, commandName);
        assertEquals(actual, expected);
    }

    @DataProvider(name = "dataForAuthorParser")
    public Object[][] dataForAuthorParser() {
        return new Object[][]{
                {"Mikhail Bulgakov", List.of("Mikhail Bulgakov")},
                {"James Kurose, Keith Ross", List.of("James Kurose","Keith Ross")},
                {"J.Kurose, K.Ross", List.of("J.Kurose","K.Ross")},
                {"", List.of("")}
        };
    }

    @Test(dataProvider = "dataForAuthorParser")
    public void authorParserTestParams(String author, List<String> expected) {
        List<String> actual = dataParser.authorParser(author);
        assertEquals(actual, expected);
    }
}