package com.assignment.demo.model.entity;

import javax.persistence.*;
import java.time.Year;

@Entity
@IdClass(CompositeKey.class)
public class Magazine {
    @Id
    private String title;
    @Id
    private Year year;
    @Enumerated(EnumType.STRING)
    private Type type;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }


    public enum Type {
        Printed, Online;
    }

}
