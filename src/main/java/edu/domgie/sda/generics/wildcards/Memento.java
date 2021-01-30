package edu.domgie.sda.generics.wildcards;

public class Memento {
    private Note note;

    public Memento(Note note) {
        this.note = note;
    }

    public Note getNote() {
        return note;
    }
}
