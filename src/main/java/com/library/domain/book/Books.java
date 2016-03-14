package com.library.domain.book;

import javax.persistence.*;
import java.io.File;
import java.io.InputStream;

/**
 * Created by Vlad on 13.03.2016.
 */
@Entity
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "book_id")
    private long bookId;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "author")
    private String author;

    @Column(name = "filePath")
    private String filePath;


    /*@Column(name = "filepath")
    private String filepath;*/

    public Books(String title, String description, String author, String filePath) {
        this.title = title;
        this.description = description;
        this.author = author;
        this.filePath = filePath;
    }

    public Books() {
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

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }
}
