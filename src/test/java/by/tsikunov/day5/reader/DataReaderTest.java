package by.tsikunov.day5.reader;

import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class DataReaderTest {

    @Test
    public void testReadFromFile() {
        DataReader reader = new DataReader();
        String text = reader.readFromFile("data/defaultFile");
        System.out.println(text.toString());
    }
}