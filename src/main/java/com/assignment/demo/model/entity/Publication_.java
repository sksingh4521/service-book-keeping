package com.assignment.demo.model.entity;

import javax.persistence.metamodel.*;
import java.util.List;

@StaticMetamodel(Publication.class)
public abstract class Publication_ {
    public static volatile SingularAttribute<Publication, String> title;
    public static volatile SingularAttribute<Publication, String> year;
    public static volatile SingularAttribute<Publication, Book> book;
    public static volatile SingularAttribute<Publication, Magazine> magazine;
    public static volatile SingularAttribute<Publication, Comics> comics;

    public static volatile ListAttribute<Publication, Author> author;
}
