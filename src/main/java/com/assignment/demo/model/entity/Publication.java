package com.assignment.demo.model.entity;

import com.assignment.demo.audit.AuditLibraryKeeping;

import javax.persistence.*;
import java.time.Year;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name = "Publication")
@IdClass(CompositeKey.class)
public class Publication extends AuditLibraryKeeping {
    @Id
    private String title;
    @Id
    private String year;


    private String pubName;
    @Enumerated(EnumType.STRING)
    private Magazine magazine;
    @Enumerated(EnumType.STRING)
    private Book book;
    @OneToOne(cascade=CascadeType.ALL)
    private Comics comics;
    @ManyToMany(cascade=CascadeType.ALL)
    private Set<Author> author = new HashSet<Author>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPubName() {
        return pubName;
    }

    public void setPubName(String pubName) {
        this.pubName = pubName;
    }

    public Magazine getMagazine() {
        return magazine;
    }

    public void setMagazine(Magazine magazine) {
        this.magazine = magazine;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Comics getComics() {
        return comics;
    }

    public void setComics(Comics comics) {
        this.comics = comics;
    }


    public Set<Author> getAuthor() {
        return author;
    }

    public void setAuthor(Set<Author> author) {
        this.author = author;
    }

}