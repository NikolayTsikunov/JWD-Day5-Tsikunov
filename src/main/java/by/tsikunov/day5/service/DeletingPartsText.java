package by.tsikunov.day5.service;

import by.tsikunov.day5.exception.ProgramException;

public interface DeletingPartsText {

    String deleteNotLetterChars(String text) throws ProgramException;

    String deleteOptionalWords(String text, int deletingWordLength) throws ProgramException;

}
