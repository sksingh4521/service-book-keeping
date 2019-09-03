package com.assignment.demo.model.entity;

public class Book {
    private Tag tag;

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public enum Genere{
        Drama,
        Novel,
        Detective
    }
}
