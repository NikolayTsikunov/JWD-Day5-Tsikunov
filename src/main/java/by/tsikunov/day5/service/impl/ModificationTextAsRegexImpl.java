package by.tsikunov.day5.service.impl;

import by.tsikunov.day5.exception.ProgramException;
import by.tsikunov.day5.service.ModificationText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ModificationTextAsRegexImpl implements ModificationText {

    private static final String ORDINAL_LETTER = "\\b(\\p{L}{%d})(\\p{L})(\\p{L}*)";
    private static final String REPLACE_GROUP = "$1%s$3";
    private static final String WORD_CERTAIN_LENGTH = "\\b\\p{L}{%d}\\b";


    public String replaceWordLetter(String text, int letterPosition, char insertingLetter) throws ProgramException {
        if(text == null || letterPosition < 0) {
            throw new ProgramException("Wrong entry data");
        }

        String regExStatement = String.format(ORDINAL_LETTER, letterPosition - 1);
        Pattern pattern = Pattern.compile(regExStatement);

        Matcher matcher = pattern.matcher(text);

        String replacement = String.format(REPLACE_GROUP, insertingLetter);

        return matcher.replaceAll(replacement);
    }

    public String replaceWrongLetter(String text, char letterLocationError, char errorLetter, char correctLetter) throws ProgramException {
        if(text == null) {
            throw new ProgramException("Text is NULL");
        }

        Pattern pattern = Pattern.compile("" + letterLocationError + errorLetter);

        Matcher matcher = pattern.matcher(text);

        return matcher.replaceAll("" + letterLocationError + correctLetter);
    }
    public String replaceOptionalLengthWords(String text, int optionalLength, String insertingWord) throws ProgramException {
        if (text == null || optionalLength <= 0 || insertingWord == null) {
            throw new ProgramException("Wrong entry data");
        }

        String regExStatement = String.format(WORD_CERTAIN_LENGTH, optionalLength);
        Pattern pattern = Pattern.compile(regExStatement);

        Matcher matcher = pattern.matcher(text);

        return matcher.replaceAll(insertingWord);
    }
}
