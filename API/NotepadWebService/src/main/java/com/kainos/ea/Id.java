package com.kainos.ea;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Id {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Id(@JsonProperty("id") String id) {
        this.id = id;
    }
}
