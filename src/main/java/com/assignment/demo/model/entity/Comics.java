package com.assignment.demo.model.entity;


public class Comics extends Tag {

    private Tag tag;
    private String hero;

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public String getHero() {
        return hero;
    }

    public void setHero(String hero) {
        this.hero = hero;
    }
}
