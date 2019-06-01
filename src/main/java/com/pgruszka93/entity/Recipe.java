package com.pgruszka93.entity;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="recipes")
public class Recipe {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "text")
    private String text;

    @Column(name="image_path")
    private String imagePath;

    @Column(name="date")
    private Date date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_id", nullable=false)
    private User users;


    public Recipe() {
    }

    public Recipe(String text, String imagePath, Date date, int usersId) {
        this.text = text;
        this.imagePath = imagePath;
        this.date = date;
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

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", imagePath='" + imagePath + '\'' +
                ", date=" + date +
                '}';
    }
}
