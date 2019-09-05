package com.assignment.demo.model.entity;

import javax.persistence.*;
import java.time.Year;

@Embeddable
public class Comics {
    @Column(name = "Comic_Hero")
    private String hero;

    public String getHero() {
        return hero;
    }

    public void setHero(String hero) {
        this.hero = hero;
    }
}
