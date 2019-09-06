package com.assignment.demo.search.model;

import com.assignment.demo.entity.Book;
import com.assignment.demo.entity.Publication_;
import com.assignment.demo.search.SearchParameter;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class BookSearchModel implements LibraryBaseModel {

    @Override
    public Predicate seacrh(SearchParameter searchParameter, Root root, Predicate predicate, CriteriaBuilder builder) {
        if (searchParameter.getValue().equals("all")) {
            predicate = builder.or(predicate, builder.equal(
                    root.get(Publication_.book), Book.Drama));

            predicate = builder.or(predicate, builder.equal(
                    root.get(Publication_.book), Book.Detective));

            predicate = builder.or(predicate, builder.equal(
                    root.get(Publication_.book), Book.Novel));
        } else {
            predicate = builder.and(predicate, builder.equal(
                    root.get(Publication_.book), Book.valueOf((String) searchParameter.getValue())));
        }

        return predicate;
    }
}
