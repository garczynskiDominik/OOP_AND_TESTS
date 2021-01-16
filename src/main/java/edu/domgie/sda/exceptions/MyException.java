package edu.domgie.sda.exceptions;

public class MyException extends IllegalArgumentException {
    public MyException() {
    }

    public MyException(String message) {
        super(message);
    }
}
