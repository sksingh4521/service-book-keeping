package com.assignment.demo.search;


import com.assignment.demo.search.model.LibraryBaseModel;
import com.assignment.demo.search.model.SearchDictionary;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.function.Consumer;

public class PublicationSearchQueryCriteriaConsumer implements Consumer<SearchParameter> {
    private final String OPERATOR = ":";
    private Predicate predicate;
    private CriteriaBuilder builder;
    private Root root;

    public PublicationSearchQueryCriteriaConsumer(Predicate predicate, CriteriaBuilder builder, Root root) {
        this.predicate = predicate;
        this.builder = builder;
        this.root = root;
    }
    @Override
    public void accept(SearchParameter searchParameter) {
        if (searchParameter.getOperation().equalsIgnoreCase(OPERATOR)) {
            SearchDictionary.getModelMap().forEach((key, value) -> {
                if (searchParameter.getKey().equals(key)) {
                    LibraryBaseModel libraryBaseModel = (LibraryBaseModel) value;

                    try {
                        predicate = libraryBaseModel.seacrh(searchParameter, root, predicate, builder);
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }

                }
            });
        }
    }

    @Override
    public Consumer<SearchParameter> andThen(Consumer<? super SearchParameter> after) {
        return null;
    }


    public Predicate getPredicate() {
        return predicate;
    }

    public CriteriaBuilder getBuilder() {
        return builder;
    }

    public Root getRoot() {
        return root;
    }

}
