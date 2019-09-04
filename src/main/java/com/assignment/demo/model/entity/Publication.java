package com.assignment.demo.model.entity;

import com.assignment.demo.audit.AuditLibraryKeeping;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Publ")
public class Publication extends AuditLibraryKeeping {

    public Magazine getMagazine() {
        return magazine;
    }

    public void setMagazine(Magazine magazine) {
        this.magazine = magazine;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pId")
    private Long pubId;
    @OneToOne
    private Magazine magazine;
    @OneToOne
    private Book book;
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

    @OneToOne
    private Comics comics;
    @ManyToMany
    private List<Author> author = new ArrayList<Author>();

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


}
