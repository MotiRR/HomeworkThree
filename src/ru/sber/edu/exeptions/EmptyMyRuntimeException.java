package ru.sber.edu.exeptions;

public class EmptyMyRuntimeException extends RuntimeException {

    public EmptyMyRuntimeException() {
        super();
    }

    public EmptyMyRuntimeException(String s) {
        super(s);
    }
}
