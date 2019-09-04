package com.assignment.demo.model.entity;


public class Magazine {
    private Tag tag;

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public enum Type {
        Printed, Online;
    }

}
