package edu.domgie.sda.homework1;

import java.util.DuplicateFormatFlagsException;

public class PersonAlreadyInsertedException extends DuplicateFormatFlagsException {
    public PersonAlreadyInsertedException(String message) {
        super(message);
    }
}
