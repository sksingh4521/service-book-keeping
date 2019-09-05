package com.assignment.demo.dao;



import com.assignment.demo.model.entity.*;

import javax.persistence.criteria.*;
import javax.persistence.metamodel.SingularAttribute;
import java.util.function.Consumer;

public class PublicationSearchQueryCriteriaConsumer implements Consumer<SearchParameter> {


    private Predicate predicate;
    private CriteriaBuilder builder;
    private Root root;

    public PublicationSearchQueryCriteriaConsumer(Predicate predicate, CriteriaBuilder builder, Root root) {
        this.predicate = predicate;
        this.builder = builder;
        this.root = root;
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

    @Override
    public void accept(SearchParameter searchParameter) {
        if (searchParameter.getOperation().equalsIgnoreCase(":")) {
            simpleStringSearch(searchParameter, "title", Publication_.title);

            simpleStringSearch(searchParameter, "year", Publication_.year);

            if (searchParameter.getKey().equals("book")) {
                bookSearch(searchParameter);
            }
            if (searchParameter.getKey().equals("magazine")) {
                magazineSearch(searchParameter);
            }
            if (searchParameter.getKey().equals("comics")) {
                comicsSearch(searchParameter);
            }
            if (searchParameter.getKey().equals("author")) {
                authorSearch(searchParameter);
            }
        }
    }

    private void authorSearch(SearchParameter searchParameter) {
        Join<Publication, Author> authors = root.join(Publication_.author);
        authors.on(builder.equal(authors.get("name"), (String) searchParameter.getValue()));
    }

    private void comicsSearch(SearchParameter searchParameter) {
        Join<Publication, Comics> comics = root.join(Publication_.comics);
        comics.on(builder.equal(comics.get("hero"), (String) searchParameter.getValue()));
    }

    private void magazineSearch(SearchParameter searchParameter) {
        if(searchParameter.getValue().equals("all"))
        {
            predicate = builder.or(predicate, builder.equal(
                    root.get(Publication_.magazine), Magazine.Online));

            predicate = builder.or(predicate, builder.equal(
                    root.get(Publication_.magazine), Magazine.Printed));
        }
        else {
            predicate = builder.and(predicate, builder.equal(
                    root.get(Publication_.magazine), Magazine.valueOf((String) searchParameter.getValue())));
        }
    }

    private void bookSearch(SearchParameter searchParameter) {
        if(searchParameter.getValue().equals("all"))
        {
            predicate = builder.or(predicate, builder.equal(
                    root.get(Publication_.book), Book.Drama));

            predicate = builder.or(predicate, builder.equal(
                    root.get(Publication_.book), Book.Detective));

            predicate = builder.or(predicate, builder.equal(
                    root.get(Publication_.book), Book.Novel));
        }
        else {
            predicate = builder.and(predicate, builder.equal(
                    root.get(Publication_.book), Book.valueOf((String) searchParameter.getValue())));
        }
    }

    private void simpleStringSearch(SearchParameter searchParameter, String str, SingularAttribute<Publication, String> singularAttribute) {
        if (searchParameter.getKey().equals(str)) {
            predicate = builder.and(predicate, builder.equal(
                    root.get(singularAttribute), (String) searchParameter.getValue()));

        }
    }

    @Override
    public Consumer<SearchParameter> andThen(Consumer<? super SearchParameter> after) {
        return null;
    }
}
