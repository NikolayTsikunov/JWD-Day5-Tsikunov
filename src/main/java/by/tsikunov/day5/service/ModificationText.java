package by.tsikunov.day5.service;

public interface ModificationText {
    void replaceWordLetter(String text, int letterPosition, char insertingLetter);
    void replaceWrongLetter(String text, char errorLocation, char correctLetter);
    void replaceOptionalLengthWords(String text, int optionalLength, String insertingWord);
}
