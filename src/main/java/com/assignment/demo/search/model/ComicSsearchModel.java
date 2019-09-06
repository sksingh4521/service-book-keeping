package com.assignment.demo.search.model;

import com.assignment.demo.entity.Comics;
import com.assignment.demo.entity.Publication;
import com.assignment.demo.entity.Publication_;
import com.assignment.demo.search.SearchParameter;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class ComicSsearchModel implements LibraryBaseModel {
    @Override
    public Predicate seacrh(SearchParameter searchParameter, Root root, Predicate predicate, CriteriaBuilder builder) {
        Join<Publication, Comics> comics = root.join(Publication_.comics);
        comics.on(builder.equal(comics.get("hero"), (String) searchParameter.getValue()));
        return predicate;
    }
}
