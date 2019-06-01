package com.pgruszka93.entity;


import javax.persistence.*;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "text")
    private String text;

    @Column(name = "date")
    private String date;

    @Column(name ="users_id")
    private int usersId;

    @Column(name = "recipes_id")
    private int recipesId;


    public Comment() {
    }

    public Comment(String text, String date, int usersId, int recipesId) {
        this.text = text;
        this.date = date;
        this.usersId = usersId;
        this.recipesId = recipesId;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getUsersId() {
        return usersId;
    }

    public void setUsersId(int usersId) {
        this.usersId = usersId;
    }

    public int getRecipesId() {
        return recipesId;
    }

    public void setRecipesId(int recipesId) {
        this.recipesId = recipesId;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", date='" + date + '\'' +
                ", usersId=" + usersId +
                ", recipesId=" + recipesId +
                '}';
    }
}
