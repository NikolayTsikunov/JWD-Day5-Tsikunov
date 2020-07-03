package by.tsikunov.day5.service.impl;

import by.tsikunov.day5.exception.ProgramException;
import by.tsikunov.day5.service.DeletingPartsText;

public class DeletingPartsTextAsStringImpl implements DeletingPartsText {

    private static final String BORDER = "\\b";
    private static final String VOWELS = "aeiouyAEIOUYуеыаоэяиюУЕЫАОЭЯИЮ";
    private static final String SPACE = " ";
    private static final String NOT_LETTER_AND_SPACE = "[^\\p{L}]\\s?";

    public String deleteNotLetterChars(String text) throws ProgramException {
        if(text == null) {
            throw new ProgramException("Wrong entry data");
        }

        return text.replaceAll(NOT_LETTER_AND_SPACE, SPACE);
    }

    public String deleteOptionalLengthWordsWovelBeginning(String text, int deletingWordLength) throws ProgramException {
        if(text == null || deletingWordLength <= 0) {
            throw new ProgramException("Wrong entry data");
        }

        String[] words = text.split(BORDER);
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            if(word.length() != deletingWordLength) {
                result.append(word);
            } else if (!VOWELS.contains(String.valueOf(word.charAt(0)))) {
                result.append(word);
            }
        }

        return result.toString();
    }
}
