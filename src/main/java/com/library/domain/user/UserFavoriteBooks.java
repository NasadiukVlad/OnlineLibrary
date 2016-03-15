package com.library.domain.user;

import javax.persistence.*;

/**
 * Created by Vlad on 15.03.2016.
 */
@Entity
public class UserFavoriteBooks {
    @Id
    // @SequenceGenerator(initialValue=1, allocationSize=1, name="users_seq", sequenceName="users_seq")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "favorite_id")
    private long usernameId;

    @Column(name = "username")
    private String username;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "author")
    private String author;

    @Column(name = "filePath")
    private String filePath;

    public UserFavoriteBooks(String username, String title, String description, String author, String filePath) {
        this.username = username;
        this.title = title;
        this.description = description;
        this.author = author;

        this.filePath = filePath;

    }

    public UserFavoriteBooks() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
