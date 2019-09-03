package com.assignment.demo.model.entity;

import java.time.Year;
import java.util.Date;

public class Tag {
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Year getDate() {
        return date;
    }

    public void setDate(Year date) {
        this.date = date;
    }

    private Year date;
}
