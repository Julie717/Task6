package com.buyalskaya.bookstorage.reader;

import com.buyalskaya.bookstorage.model.exception.ProjectException;
import com.buyalskaya.bookstorage.model.reader.InitialDataReader;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class InitialDataReaderTest {
    InitialDataReader initialDataReader;
    List<String> defaultDataExpected;


    @BeforeClass
    public void setUp() {
        initialDataReader = new InitialDataReader();
        defaultDataExpected = new ArrayList<>();
        defaultDataExpected.add("name=Harry Potter and the Philosopher's Stone; author=J.K.Rowling; edition=Bloomsbury; year=2014; page=352");
        defaultDataExpected.add("name=Harry Potter and the Chamber of Secrets; author=J.K.Rowling; edition=Bloomsbury; year=2014; page=384");
        defaultDataExpected.add("name=Harry Potter and the Prisoner of Azkaban; author=J.K.Rowling; edition=Bloomsbury; year=2014; page=480");
        defaultDataExpected.add("name=Harry Potter and the Goblet of Fire; author=J.K.Rowling; edition=Bloomsbury; year=2014; page=640");
        defaultDataExpected.add("name=Harry Potter and the Order of the Phoenix; author=J.K.Rowling; edition=Bloomsbury; year=2014; page=816");
        defaultDataExpected.add("name=Harry Potter and the Half-Blood Prince; author=J.K.Rowling; edition=Bloomsbury; year=2014; page=560");
        defaultDataExpected.add("name=Harry Potter and the Deathly Hallows; author=J.K.Rowling; edition=Bloomsbury; year=2014; page=640");
        defaultDataExpected.add("name=Notre-Dame de Paris; author=Victor Hugo; edition=Oxford University Press, Reissue edition; year=2009; page=592");
        defaultDataExpected.add("name=Les Miserables; author=Victor Hugo; edition=Canterbury Classics; year=2015; page=1264");
        defaultDataExpected.add("name=Ninety-three; author=Victor Hugo; edition=Peerless Press; year=2011; page=362");
        defaultDataExpected.add("name=The Man Who Laughs; author=Victor Hugo; edition=Moorside Press; year=2013; page=368");
        defaultDataExpected.add("name=Humans; author=Brandon Stanton; edition=St. Martin's Press; year=2020; page=448");
        defaultDataExpected.add("name=The Animals at Lockwood Manor; author=Jane Healey; edition=Houghton Mifflin Harcourt; year=2020; page=352");
        defaultDataExpected.add("name=A Fall of Marigolds; author=Susan Meissner; edition=Berkley; year=2014; page=400");
        defaultDataExpected.add("name=Find Me; author=Anne Frasier; edition=Thomas & Mercer; year=2020; page=285");
        defaultDataExpected.add("name=Scarlet Odyssey; author=C.T.Rwizi; edition=47North; year=2020; page=518");
        defaultDataExpected.add("name=Fair Warning; author=Michael Connelly; edition=Little, Brown and Company; year=2020; page=416");
        defaultDataExpected.add("name=SAT Prep Black Book: The Most Effective SAT Strategies Ever Published; author=Mike Barrett, Patrick Barrett; edition=ACT Prep Books; year=2020; page=576");
        defaultDataExpected.add("name=The Montessori Toddler: A Parent's Guide to Raising a Curious and Responsible Human Being; author=Simone Davies, Hiyoko Imai; edition=Workman Publishing Company; year=2019; page=256");
        defaultDataExpected.add("name=Montessori from the Start: The Child at Home, from Birth to Age Three; author= Paula Polk Lillard, Lynn Lillard Jessen; edition=Schocken; year=2003; page=304");
        defaultDataExpected.add("name=Guide to Colorado Backroads & 4-Wheel-Drive Trails; author= Charles A. Wells, Matt Peterson; edition=Funtreks Inc; year=2019; page=236");
        defaultDataExpected.add("name=The Warmth of Other Suns: The Epic Story of America's Great Migration; author=Isabel Wilkerson; edition=Vintage; year=2011; page=640");
        defaultDataExpected.add("name=The Summer House; author=James Patterson, Brendan DuBois; edition=Little, Brown and Company; year=2020; page=448");
        defaultDataExpected.add("name=If It Bleeds; author=Stephen King; edition=Scribner; year=2020; page=448");
        defaultDataExpected.add("name=The Institute; author=Stephen King; edition=Gallery Books; year=2020; page=576");
        defaultDataExpected.add("name=Memoirs and Misinformation; author=Jim Carrey, Dana Vachon; edition=Knopf; year=2020; page=272");
    }

    @Test
    public void readInitialDataTestPositive() throws ProjectException {
        String filePath = "resources/initialStorage.txt";
        List<String> actual = initialDataReader.readInitialData(filePath);
        assertEquals(actual, defaultDataExpected);
    }

    @Test
    public void readStringFromFileTestIncorrectFilePath() throws ProjectException {
        String filePath = "resources/input.txt";
        List<String> actual = initialDataReader.readInitialData(filePath);
        assertEquals(actual, defaultDataExpected);

    }

    @Test
    public void readStringFromFileTestFilePathNull() throws ProjectException {
        String filePath = null;
        List<String> actual = initialDataReader.readInitialData(filePath);
        assertEquals(actual, defaultDataExpected);

    }

    @Test
    public void readStringFromFileTestFilePathEmpty() throws ProjectException {
        String filePath = "";
        List<String> actual = initialDataReader.readInitialData(filePath);
        assertEquals(actual, defaultDataExpected);

    }
}
