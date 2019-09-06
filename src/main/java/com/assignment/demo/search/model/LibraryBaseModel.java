package com.assignment.demo.search.model;

import com.assignment.demo.search.SearchParameter;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public interface LibraryBaseModel {
    Predicate seacrh(SearchParameter searchParameter, Root root, Predicate predicate, CriteriaBuilder builder) throws ClassNotFoundException;
}
