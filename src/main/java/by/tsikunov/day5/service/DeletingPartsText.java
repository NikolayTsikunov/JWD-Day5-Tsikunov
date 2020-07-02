package by.tsikunov.day5.service;

public interface DeletingPartsText {
    void deleteNotLetterChars(String text);
    void deleteOptionalWords(String text, int deletingWordLength, boolean isVowelBeginning);
}
