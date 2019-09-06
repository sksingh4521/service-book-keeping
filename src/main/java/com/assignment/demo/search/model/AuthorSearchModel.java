package com.assignment.demo.search.model;

import com.assignment.demo.entity.Author;
import com.assignment.demo.entity.Publication;
import com.assignment.demo.entity.Publication_;
import com.assignment.demo.search.SearchParameter;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class AuthorSearchModel implements LibraryBaseModel {
    @Override
    public Predicate seacrh(SearchParameter searchParameter, Root root, Predicate predicate, CriteriaBuilder builder) {
        Join<Publication, Author> authors = root.join(Publication_.author);
        authors.on(builder.equal(authors.get("name"), (String) searchParameter.getValue()));
        return predicate;
    }
}
