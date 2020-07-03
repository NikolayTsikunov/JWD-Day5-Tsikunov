package by.tsikunov.day5.service.impl;

import by.tsikunov.day5.exception.ProgramException;
import by.tsikunov.day5.service.DeletingPartsText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DeletingPartsTextAsRegexImpl implements DeletingPartsText {

    private static final String VOWEL_WORD = "\\b([aeiouyAEIOUYуеыаоэяиюУЕЫАОЭЯИЮ])(\\p{L}{%d})\\b";
    private static final String NOT_LETTER_AND_SPACE = "[^\\p{L}]\\s?";
    private static final String SPACE = " ";
    private static final String BLANK = "";

    public String deleteNotLetterChars(String text) throws ProgramException {
        if(text == null) {
            throw new ProgramException("Wrong entry data");
        }

        Pattern pattern = Pattern.compile(NOT_LETTER_AND_SPACE);

        Matcher matcher = pattern.matcher(text);

        return matcher.replaceAll(SPACE);
    }

    public String deleteOptionalLengthWordsWovelBeginning(String text, int deletingWordLength) throws ProgramException {
        if(text == null || deletingWordLength <= 0) {
            throw new ProgramException("Wrong entry data");
        }

        String regEXStatement = String.format(VOWEL_WORD, deletingWordLength - 1);
        Pattern pattern = Pattern.compile(regEXStatement);

        Matcher matcher = pattern.matcher(text);

        return matcher.replaceAll(BLANK);
    }
}
