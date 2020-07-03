package by.tsikunov.day5.service;

import by.tsikunov.day5.exception.ProgramException;

public interface ModificationText {

    String replaceWordLetter(String text, int letterPosition, char insertingLetter) throws ProgramException;

    String replaceWrongLetter(String text, char letterLocationError, char errorLetter, char correctLetter) throws ProgramException;

    String replaceOptionalLengthWords(String text, int replacementWordLength, String insertingWord) throws ProgramException;

}
