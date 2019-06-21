package com.pgruszka93.entity;


import javax.persistence.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name="recipes")
public class Recipe {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="title")
    private String title;

    @Column(name="header_text")
    private String headerText;

    @Column(name = "text")
    private String text;

    @Column(name="image_path")
    private String imagePath;

    @Column(name="date")
    private Date date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_id", nullable=false)
    private User user;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "recipe")
    private Collection<Comment> comments;


    public Recipe() {
    }

    public Recipe(String title, String headerText, String text, String imagePath, Date date, User user, Collection<Comment> comments) {
        this.title = title;
        this.headerText = headerText;
        this.text = text;
        this.imagePath = imagePath;
        this.date = date;
        this.user = user;
        this.comments = comments;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Collection<Comment> getComments() {
        return comments;
    }

    public void setComments(Collection<Comment> comments) {
        this.comments = comments;
    }

    public String getFormatedDate(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return df.format(this.date);
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", headerText='" + headerText + '\'' +
                ", text='" + text + '\'' +
                ", imagePath='" + imagePath + '\'' +
                ", date=" + date +
                ", user=" + user +
                ", comments=" + comments +
                '}';
    }
}
