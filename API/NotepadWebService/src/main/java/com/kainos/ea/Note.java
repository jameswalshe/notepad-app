package com.kainos.ea;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Note {
    private String name, note, id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @JsonCreator
    public Note(@JsonProperty("name") String name, @JsonProperty("note") String note, @JsonProperty("id") String id) {
        this.setName(name);
        this.setNote(note);
        this.setId(id);
    }
}
