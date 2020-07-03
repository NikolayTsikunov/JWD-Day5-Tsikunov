package by.tsikunov.day5.reader;

import by.tsikunov.day5.exception.ProgramException;
import by.tsikunov.day5.service.DeletingPartsText;
import by.tsikunov.day5.service.ModificationText;
import by.tsikunov.day5.service.impl.*;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class DataReaderTest {

    @Test
    public void testReadFromFile() throws ProgramException {
        DataReader reader = new DataReader();
        String text = reader.readFromFile("data/defaultFile");
        System.out.println(text);

        ModificationText modification = new ModificationTextAsCharsImpl();
        modification.replaceWordLetter("tota popa po trom, nbr. Sir/", 3, 'F');
        modification.replaceWrongLetter("pointp papa topa", 'p', 'a', 'o');
        modification.replaceOptionalLengthWords("pointp papa top.", 4, "FUCK");

        ModificationText modification1 = new ModificationTextAsStringImpl();
        modification1.replaceWordLetter("tota popa po trom, nbr. Sir/. Мама мыла раму", 3, 'F');

        ModificationText modification2 = new ModificationTextAsRegexImpl();
        modification2.replaceWordLetter("tota popa po trom, nbr. Sir/", 3, 'F');
        modification2.replaceOptionalLengthWords("pointp papa top.", 4, "FUCK");
        modification2.replaceWrongLetter("pointp papa topa", 'p', 'a', 'o');

        DeletingPartsText deleting = new DeletingPartsTextAsStringImpl();
        deleting.deleteNotLetterChars(text);
        deleting.deleteOptionalLengthWords("арка жарко arma roma ra", 4);

        DeletingPartsText deleting1 = new DeletingPartsTextAsCharImpl();
        deleting1.deleteNotLetterChars(text);
        deleting1.deleteOptionalLengthWords("арка жарко arma roma ra", 4);

        DeletingPartsText deleting2 = new DeletingPartsTextAsRegexImpl();
        deleting2.deleteNotLetterChars(text);
        deleting2.deleteOptionalLengthWords("арка жарко arma roma ra", 4);
    }
}