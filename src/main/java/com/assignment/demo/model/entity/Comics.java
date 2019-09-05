package com.assignment.demo.model.entity;

import javax.persistence.*;
import java.time.Year;

@Entity
public class Comics {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "Comic_Hero")
    private String hero;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getHero() {
        return hero;
    }

    public void setHero(String hero) {
        this.hero = hero;
    }
}
