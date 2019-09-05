package com.assignment.demo.respository;



import com.assignment.demo.model.entity.*;

import javax.persistence.criteria.*;
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
            if (searchParameter.getKey().equals("title")) {
                predicate = builder.and(predicate, builder.equal(
                        r.get(Publication_.title),(String) searchParameter.getValue()));

            }

            if (searchParameter.getKey().equals("year")) {
                predicate = builder.and(predicate, builder.equal(
                        r.get(Publication_.year), (String) searchParameter.getValue()));

            }

            if (searchParameter.getKey().equals("book")) {
                if(searchParameter.getValue().equals("all"))
                {
                    predicate = builder.or(predicate, builder.equal(
                            r.get(Publication_.book), Book.Drama));

                    predicate = builder.or(predicate, builder.equal(
                            r.get(Publication_.book), Book.Detective));

                    predicate = builder.or(predicate, builder.equal(
                            r.get(Publication_.book), Book.Novel));
                }
                else {
                    predicate = builder.and(predicate, builder.equal(
                            r.get(Publication_.book), Book.valueOf((String) searchParameter.getValue())));
                }

            }
            if (searchParameter.getKey().equals("magazine")) {

                if(searchParameter.getValue().equals("all"))
                {
                    predicate = builder.or(predicate, builder.equal(
                            r.get(Publication_.magazine), Magazine.Online));

                    predicate = builder.or(predicate, builder.equal(
                            r.get(Publication_.magazine), Magazine.Printed));
                }
                else {
                    predicate = builder.and(predicate, builder.equal(
                            r.get(Publication_.magazine), Magazine.valueOf((String) searchParameter.getValue())));
                }

            }
            if (searchParameter.getKey().equals("comics")) {
                Join<Publication, Comics> comics = r.join(Publication_.comics);
                comics.on(builder.equal(comics.get("hero"), (String) searchParameter.getValue()));
            }
            if (searchParameter.getKey().equals("author")) {
                Join<Publication, Author> authors = r.join(Publication_.author, JoinType.LEFT);
                authors.on(builder.equal(authors.get("name"), (String) searchParameter.getValue()));
            }
        }
    }

    @Override
    public Consumer<SearchParameter> andThen(Consumer<? super SearchParameter> after) {
        return null;
    }
}
