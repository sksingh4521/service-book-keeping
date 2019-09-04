package com.assignment.demo.respository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.function.Consumer;

public class PublicationSearchQueryCriteriaConsumer implements Consumer<SearchParameter> {


    private Predicate predicate;
    private CriteriaBuilder builder;
    private Root r;

    public PublicationSearchQueryCriteriaConsumer(Predicate predicate, CriteriaBuilder builder, Root r) {
        this.predicate = predicate;
        this.builder = builder;
        this.r = r;
    }

    public Predicate getPredicate() {
        return predicate;
    }

    public CriteriaBuilder getBuilder() {
        return builder;
    }

    public Root getR() {
        return r;
    }

    @Override
    public void accept(SearchParameter searchParameter) {
       if (searchParameter.getOperation().equalsIgnoreCase(":")) {
            if (r.get(searchParameter.getKey()).getJavaType() == String.class) {
                predicate = builder.and(predicate, builder.like(
                        r.get(searchParameter.getKey()), "%" + searchParameter.getValue() + "%"));
            } else {
                predicate = builder.and(predicate, builder.equal(
                        r.get(searchParameter.getKey()), searchParameter.getValue()));
            }
        }

    }

    @Override
    public Consumer<SearchParameter> andThen(Consumer<? super SearchParameter> after) {
        return null;
    }
}
