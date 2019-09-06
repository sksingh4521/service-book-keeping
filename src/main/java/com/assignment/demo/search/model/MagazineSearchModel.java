package com.assignment.demo.search.model;

import com.assignment.demo.model.entity.Magazine;
import com.assignment.demo.model.entity.Publication_;
import com.assignment.demo.search.SearchParameter;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class MagazineSearchModel implements LibraryBaseModel {

    @Override
    public Predicate seacrh(SearchParameter searchParameter, Root root, Predicate predicate, CriteriaBuilder builder) {
        if (searchParameter.getValue().equals("all")) {
            predicate = builder.or(predicate, builder.equal(
                    root.get(Publication_.magazine), Magazine.Online));

            predicate = builder.or(predicate, builder.equal(
                    root.get(Publication_.magazine), Magazine.Printed));
        } else {
            predicate = builder.and(predicate, builder.equal(
                    root.get(Publication_.magazine), Magazine.valueOf((String) searchParameter.getValue())));
        }
        return predicate;

    }
}
