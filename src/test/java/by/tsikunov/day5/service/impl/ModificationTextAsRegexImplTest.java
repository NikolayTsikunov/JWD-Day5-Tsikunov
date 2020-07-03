package by.tsikunov.day5.service.impl;

import by.tsikunov.day5.exception.ProgramException;
import by.tsikunov.day5.service.ModificationText;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ModificationTextAsRegexImplTest {

    ModificationText modificator;

    @BeforeTest
    private void initialization() {
        modificator = new ModificationTextAsRegexImpl();
    }

    @Test
    public void replaceWordLetterTest() throws ProgramException {
        String actual = modificator.replaceWordLetter("tota popa po trom, nbr. Sir/", 3, 'F');
        String expected = "toFa poFa po trFm, nbF. SiF/";
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = ProgramException.class,
            expectedExceptionsMessageRegExp = "Wrong entry data")
    public void replaceWordLetterExceptionTest() throws ProgramException {
        modificator.replaceWordLetter(null, 5, 'c');
    }

    @Test
    public void replaceWrongLetterTest() throws ProgramException {
        String actual = modificator.replaceWrongLetter("pointp, papa topa!", 'p', 'a', 'o');
        String expected = "pointp, popo topo!";
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = ProgramException.class,
            expectedExceptionsMessageRegExp = "Text is NULL")
    public void replaceWrongLetterExceptionTest() throws ProgramException {
        modificator.replaceWrongLetter(null, 'c', 'a', 'p');
    }

    @Test
    public void replaceOptionalLengthWordsTest() throws ProgramException {
        String actual = modificator.replaceOptionalLengthWords("pointp papa top. tros/", 4, "WORK");
        String expected = "pointp WORK top. WORK/";
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = ProgramException.class,
            expectedExceptionsMessageRegExp = "Wrong entry data")
    public void replaceOptionalLengthWordsExceptionTest() throws ProgramException {
        modificator.replaceOptionalLengthWords(null, 5, "WORK");
    }
}