package ru.sber.edu.exeptions;

public class EmptyMyExeption extends Exception {

    public EmptyMyExeption() {
        super();
    }

    public EmptyMyExeption(String s) {
        super(s);
    }
}
