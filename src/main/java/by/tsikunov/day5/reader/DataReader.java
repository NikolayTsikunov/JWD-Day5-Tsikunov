package by.tsikunov.day5.reader;

import by.tsikunov.day5.exception.ProgramException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class DataReader {

    private static final String DEFAULT_PATH =
            "data/defaultFile";

    public String readFromFile(String filePath) throws ProgramException {
        List<String> lines;
        Path file = Paths.get(DEFAULT_PATH);

        if(filePath != null) {
            if(Files.exists(Paths.get(filePath)) &&
                    !Files.isDirectory(Paths.get(filePath))) {
                file = Paths.get(filePath);
            }
        }

        try {
            lines = Files.readAllLines(file);
        } catch (IOException e) {
            throw new ProgramException("Error while reading from file");
        }

        StringBuilder sb = new StringBuilder();
        for (String str : lines) {
            sb.append(str).append("\n");
        }
        return sb.toString();
    }

    public String readFromConsole() throws ProgramException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        try {
            System.out.println("Input text. The end is empty string:");
            String line;
            while (true){
                line = reader.readLine();
                if (line.equals("")) {
                    break;
                }
                sb.append(line).append("\n");
            }
            reader.close();
        } catch (IOException e) {
            throw new ProgramException("Error while reading from console.");
        }
        return sb.toString();
    }
}