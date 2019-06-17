package com.pgruszka93.model;

import com.pgruszka93.entity.User;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class RecipeModel {

    private int id;

    @NotNull(message = "Tytuł jest wymagany")
    @Size(min = 1, message = "is required")
    private String title;

    @NotNull(message = "Streszczenie jest wymagane")
    @Size(min = 1, message = "is required")
    private String headerText;

    @NotNull(message = "Opis jest wymagany")
    @Size(min = 1, message = "is required")
    private String text;



    private User user;



    private String imagePath;

    public RecipeModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHeaderText() {
        return headerText;
    }

    public void setHeaderText(String headerText) {
        this.headerText = headerText;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
