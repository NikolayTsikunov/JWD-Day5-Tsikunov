package by.tsikunov.day5.reader;

import by.tsikunov.day5.exception.ProgramException;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class DataReaderTest {

    @Test
    public void testReadFromFile() throws ProgramException {
        DataReader reader = new DataReader();
        String text = reader.readFromFile("data/defaultFile");
        System.out.println(text);
        char[] str = new char[] {'1', '2', '3',};//  new char[]{'r', 'v', 'c',};
    }
}