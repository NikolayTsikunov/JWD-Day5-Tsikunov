package by.tsikunov.day5.service.impl;

import by.tsikunov.day5.exception.ProgramException;
import by.tsikunov.day5.service.DeletingPartsText;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class DeletingPartsTextAsRegexImplTest {

    DeletingPartsText deletingPartsText;

    @BeforeTest
    private void initialization() {
        deletingPartsText = new DeletingPartsTextAsRegexImpl();
    }

    @Test
    public void deleteNotLetterCharsTest() throws ProgramException {
        String text = "That thereby beauty's rose might never die,";
        String actual = deletingPartsText.deleteNotLetterChars(text);
        String expected = "That thereby beauty s rose might never die ";
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = ProgramException.class,
            expectedExceptionsMessageRegExp = "Wrong entry data")
    public void deleteNotLetterCharsExceptionTest() throws ProgramException {
        deletingPartsText.deleteNotLetterChars(null);
    }
    
    public void deleteOptionalLengthWordsWovelBeginningTest() throws ProgramException {
        String text = "amour, logo pass, bright arkar";
        String actual = deletingPartsText.deleteOptionalLengthWordsWovelBeginning(text, 5);
        String expected = ", logo pass, bright ";
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = ProgramException.class,
            expectedExceptionsMessageRegExp = "Wrong entry data")
    public void deleteOptionalLengthWordsWovelBeginningExceptionTest() throws ProgramException {
        deletingPartsText.deleteOptionalLengthWordsWovelBeginning(null, 5);
    }
}