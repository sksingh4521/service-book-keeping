package com.assignment.demo.model.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Publ")
public class Publication {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pId")
    private Long pubId;

    private String pubName;

    public String getPubName() {
        return pubName;
    }

    public void setPubName(String pubName) {
        this.pubName = pubName;
    }

    @OneToOne(cascade=CascadeType.ALL)
    private Magazine magazine;
    @OneToOne(cascade=CascadeType.ALL)
    private Book book;
    @OneToOne(cascade=CascadeType.ALL)
    private Comics comics;
    @ManyToMany(cascade=CascadeType.ALL)
    private List<Author> author = new ArrayList<Author>();

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



    public Long getPubId() {
        return pubId;
    }

    public void setPubId(Long pubId) {
        this.pubId = pubId;
    }

    @ManyToMany
    public List<Author> getAuthor() {
        return author;
    }

    public void setAuthor(List<Author> author) {
        this.author = author;
    }
    public Magazine getMagazine() {
        return magazine;
    }

    public void setMagazine(Magazine magazine) {
        this.magazine = magazine;
    }

}
