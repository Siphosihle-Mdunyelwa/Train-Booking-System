package com.example.booking.Model;

public class Feedback {
    private String Name;
    private String Note;

    public Feedback() {

    }

    public Feedback(String name, String note) {
        Name = name;
        Note = note;
    }

    public String getName() {
        return  Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String note) {
        Note = note;
    }
}
