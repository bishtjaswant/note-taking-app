package com.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Random;


@Entity
@Table(name = "notes")
public class Note {
    @Id
    private int noteId;
    private String title;

    @Column(length = 1200)
    private String content;
    private Date noteAdded;

    public Note() {
    }

    public Note( String title, String content, Date noteAdded) {
        this.noteId = new Random().nextInt(1000);
        this.title = title;
        this.content = content;
        this.noteAdded = noteAdded;
    }

    public int getNoteId() {
        return noteId;
    }

    public void setNoteId(int noteId) {
        this.noteId = noteId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getNoteAdded() {
        return noteAdded;
    }

    public void setNoteAdded(Date noteAdded) {
        this.noteAdded = noteAdded;
    }
}
