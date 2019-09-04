package com.assignment.demo.model.entity;

import java.io.Serializable;
import java.time.Year;
import java.util.Objects;

public class CompositeKey implements Serializable {

    private String title;
    private Year year;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompositeKey that = (CompositeKey) o;
        return Objects.equals(title, that.title) &&
                Objects.equals(year, that.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, year);
    }
}
