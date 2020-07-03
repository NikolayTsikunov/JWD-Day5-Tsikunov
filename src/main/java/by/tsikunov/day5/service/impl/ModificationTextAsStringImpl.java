package by.tsikunov.day5.service.impl;

import by.tsikunov.day5.exception.ProgramException;
import by.tsikunov.day5.service.ModificationText;

public class ModificationTextAsStringImpl implements ModificationText {

    private static final String WORD_BORDER = "\\b";
    private static final String LETTERS = "\\p{L}+";

    public String replaceWordLetter(String text, int letterPosition, char insertingLetter) throws ProgramException {
        if(text == null) {
            throw new ProgramException("Text is null");
        }

        StringBuilder sb = new StringBuilder();
        String[] words = text.split(WORD_BORDER);

        for (String word : words) {
            if(word.length() >= letterPosition && word.matches(LETTERS)) {
                word = word.substring(0, letterPosition - 1) + insertingLetter + word.substring(letterPosition);
            }
            sb.append(word);
        }
        return sb.toString();
    }

    public String replaceWrongLetter(String text, char letterLocationError, char errorLetter, char correctLetter) throws ProgramException {
        if(text == null) {
            throw new ProgramException("Text is null");
        }

        StringBuilder sb = new StringBuilder();
        String[] words = text.split(WORD_BORDER);
        String correctSeq = "" + letterLocationError + correctLetter;
        String errorSeq = "" + letterLocationError + errorLetter;

        for (String word : words) {
            word = word.replaceAll(errorSeq, correctSeq);
            sb.append(word);
        }

        return sb.toString();
    }

    public String replaceOptionalLengthWords(String text, int optionalWordLength, String insertingWord) throws ProgramException {
        if(text == null || insertingWord == null) {
            throw new ProgramException("Wrong entry data");
        }

        String[] words = text.split(WORD_BORDER);
        StringBuilder sb = new StringBuilder();

        for (String word : words) {
            if(word.matches(LETTERS) && word.length() == optionalWordLength) {
                sb.append(insertingWord);
            } else {
                sb.append(word);
            }
        }

        return sb.toString();
    }
}
