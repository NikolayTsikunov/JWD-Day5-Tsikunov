package by.tsikunov.day5.reader;

import by.tsikunov.day5.exception.ProgramException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.testng.Assert.*;

public class DataReaderTest {

    String expected = "From fairest creatures we desire increase,\n" +
            "That thereby beauty's rose might never die,\n" +
            "But as the riper should by time decease,\n" +
            "His tender heir might bear his memory...\n";
    @Test
    public void testReadFromFile() throws ProgramException {
        DataReader reader = new DataReader();
        String actual = reader.readFromFile("data/defaultFile");
        assertEquals(actual, expected);
    }

    @Test
    public void testReadFromFileDefault() throws ProgramException {
        DataReader reader = new DataReader();
        String actual = reader.readFromFile(null);
        assertEquals(actual, expected);
    }

    @Test
    public void testReadFromConsole() {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("5").append('\n');
            sb.append("1").append('\n');
            sb.append("2").append('\n');
            sb.append("5").append('\n');
            sb.append("4").append('\n');
            sb.append("5").append('\n');
            sb.append("").append('\n');
            InputStream inputStream = new ByteArrayInputStream(sb.toString().getBytes());
            InputStream defaultInputStream = System.in;
            System.setIn(inputStream);
            DataReader reader = new DataReader();
            String actual = reader.readFromConsole();
            inputStream.close();
            String expected = "5\n1\n2\n5\n4\n5\n";
            assertEquals(actual, expected);
        } catch (ProgramException | IOException e) {
            fail(e.getMessage());
        }
    }
}