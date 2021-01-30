package edu.domgie.sda.generics.wildcards;


import lombok.Getter;
import lombok.Setter;

public class Note {
    private String note;


    @Getter
    @Setter
    private String anotherNote;

    public Note(String note) {
        this.note = note;
    }


    public String getNote() {
        return note;
    }
}
