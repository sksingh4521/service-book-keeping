package com.assignment.demo.search.model;

import com.assignment.demo.model.entity.Publication;
import com.assignment.demo.model.entity.Publication_;
import com.assignment.demo.search.SearchParameter;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.SingularAttribute;

public class SimpleSearchModel implements LibraryBaseModel {
    @Override
    public Predicate seacrh(SearchParameter searchParameter, Root root, Predicate predicate, CriteriaBuilder builder){
        SingularAttribute<Publication, String> singularAttribute = null;
        if(searchParameter.getKey().equals("title"))
        {
            singularAttribute = Publication_.title;
        }
        if(searchParameter.getKey().equals("year"))
        {
            singularAttribute = Publication_.year;
        }
       return      predicate = builder.and(predicate, builder.equal(root.get(singularAttribute), (String) searchParameter.getValue()));
    }
}
