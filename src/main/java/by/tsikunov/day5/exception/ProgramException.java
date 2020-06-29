package by.tsikunov.day5.exception;

public class ProgramException extends Exception {
    public ProgramException() {
        super();
    }
    public ProgramException(String message) {
        super(message);
    }
    public ProgramException(Throwable e) {
        super(e);
    }
    public ProgramException(String message, Throwable e) {
        super(message, e);
    }
}
