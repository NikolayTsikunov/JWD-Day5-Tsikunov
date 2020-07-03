package by.tsikunov.day5.service.impl;

import by.tsikunov.day5.exception.ProgramException;
import by.tsikunov.day5.service.DeletingPartsText;

public class DeletingPartsTextAsCharImpl implements DeletingPartsText {

    private static final String SPACE = " ";
    private static final String VOWELS = "aeiouyAEIOUYуеыаоэяиюУЕЫАОЭЯИЮ";

    public String deleteNotLetterChars(String text) throws ProgramException {
        if(text == null) {
            throw new ProgramException("Wrong entry data");
        }

        char[] letters = text.toCharArray();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < letters.length; i++) {
            if(Character.isLetter(letters[i])) {
                result.append(letters[i]);
            } else {
                result.append(SPACE);
            }
        }
        return result.toString();
    }

    public String deleteOptionalLengthWordsWovelBeginning(String text, int deletingWordLength) throws ProgramException {
        if(text == null) {
            throw new ProgramException("Wrong entry data");
        }

        char[] letters = text.toCharArray();
        StringBuilder result = new StringBuilder();
        int wordLength = 0;
        int wordBeginning = 0;

        for (int i = 0; i < letters.length; i++) {
            if(Character.isLetter(letters[i])) {
                if(wordLength == 0) {
                    wordBeginning = i;
                }
                wordLength++;
            } else if(wordLength == 0) {
                result.append(letters[i]);
            } else {
                if(wordLength != deletingWordLength || !VOWELS.contains(String.valueOf(letters[wordBeginning]))) {
                    for (int j = wordBeginning; j <= i; j++) {
                        result.append(letters[j]);
                    }
                } else {
                    result.append(letters[i]);
                }
                wordLength = 0;
            }
        }

        if(wordLength != 0) {
            if(wordLength != deletingWordLength || !VOWELS.contains(String.valueOf(letters[wordBeginning]))) {
                for (int j = wordBeginning; j < letters.length; j++) {
                    result.append(letters[j]);
                }
            }
        }

        return result.toString();
    }
}
