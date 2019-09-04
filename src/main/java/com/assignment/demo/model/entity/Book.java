package com.assignment.demo.model.entity;

import javax.persistence.*;
import java.time.Year;
@Entity
@IdClass(CompositeKey.class)
public class Book{
    @Id
    private String title;
    @Id
    private Year year;
    @Enumerated(EnumType.STRING)
    private Genere  genere;

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    public Genere getGenere() {
        return genere;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public enum Genere {
        Drama,
        Novel,
        Detective
    }
}
