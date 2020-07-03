package by.tsikunov.day5.service.impl;

import by.tsikunov.day5.exception.ProgramException;
import by.tsikunov.day5.service.ModificationText;

// TODO: 03.07.2020 Tests
public class ModificationTextAsCharsImpl implements ModificationText {
    public String replaceWordLetter(String text, int letterPosition, char insertingLetter) throws ProgramException {
        if(text == null) {
            throw new ProgramException("Text is null");
        }

        char[] letters = text.toCharArray();
        int wordLength = 0;
        for (int i = 0; i < letters.length; i++) {
            if(Character.isLetter(letters[i])) {
                wordLength++;
                if(wordLength == letterPosition) {
                    letters[i] = insertingLetter;
                }
            } else {
                wordLength = 0;
            }
        }

        return String.valueOf(letters);
    }
    public String replaceWrongLetter(String text, char letterLocationError, char errorLetter, char correctLetter) throws ProgramException {
        if(text == null) {
            throw new ProgramException("Text is null");
        }
        char[] letters = text.toCharArray();
        for (int i = 0; i < letters.length; i++) {
            if(letters[i] == letterLocationError && i != letters.length - 1) {
                if(letters[i + 1] == errorLetter) {
                    letters[i + 1] = correctLetter;
                    i++;
                }
            }
        }
        return String.valueOf(letters);
    }
    public String replaceOptionalLengthWords(String text, int optionalLength, String insertingWord) throws ProgramException {
        if(text == null || insertingWord == null) {
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
                if(wordLength == optionalLength) {
                    result.append(insertingWord).append(letters[i]);
                } else {
                    for (int j = wordBeginning; j <= i; j++) {
                        result.append(letters[j]);
                    }
                }
                wordLength = 0;
            }
        }

        if(wordLength != 0) {
            if(wordLength == optionalLength) {
                result.append(insertingWord);
            } else {
                for (int j = wordBeginning; j < letters.length; j++) {
                    result.append(letters[j]);
                }
            }
        }

        return result.toString();
    }
}
