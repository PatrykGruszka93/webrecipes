package com.pgruszka93.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CommentModel {

    private int id;

    @NotNull(message = "Tekst jest wymagany")
    @Size(min = 1, message = "is required")
    private String text;

    public CommentModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
