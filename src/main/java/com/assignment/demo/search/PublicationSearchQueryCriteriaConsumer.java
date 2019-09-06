package com.assignment.demo.search;


import com.assignment.demo.model.entity.Publication;
import com.assignment.demo.search.model.*;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.SingularAttribute;
import java.util.function.Consumer;

public class PublicationSearchQueryCriteriaConsumer implements Consumer<SearchParameter> {


    private Predicate predicate;
    private CriteriaBuilder builder;
    private Root root;
    private final BookSearchModel bookSearchModel = new BookSearchModel();
    private final MagazineSearchModel magazineSearchModel = new MagazineSearchModel();
    private final ComicSsearchModel comicSsearchModel = new ComicSsearchModel();
    private final AuthorSearchModel authorSearchModel = new AuthorSearchModel();
    private final SimpleSearchModel simpleSearchModel = new SimpleSearchModel();


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
            if (searchParameter.getKey().equals("title")) {
                predicate = simpleSearchModel.seacrh(searchParameter,root,predicate,builder);
            }
            if (searchParameter.getKey().equals("year")) {
                predicate = simpleSearchModel.seacrh(searchParameter,root,predicate,builder);
            }
            if (searchParameter.getKey().equals("book")) {
                predicate = bookSearchModel.seacrh(searchParameter, root, predicate, builder);
            }
            if (searchParameter.getKey().equals("magazine")) {
                predicate = magazineSearchModel.seacrh(searchParameter, root, predicate, builder);
            }
            if (searchParameter.getKey().equals("comics")) {
                predicate = comicSsearchModel.seacrh(searchParameter, root, predicate, builder);
            }
            if (searchParameter.getKey().equals("author")) {
                predicate = authorSearchModel.seacrh(searchParameter, root, predicate, builder);
            }
        }
    }
    private void simpleStringSearch(SearchParameter searchParameter, SingularAttribute<Publication, String> singularAttribute) {

            predicate = builder.and(predicate, builder.equal(
                    root.get(singularAttribute), (String) searchParameter.getValue()));


    }

    @Override
    public Consumer<SearchParameter> andThen(Consumer<? super SearchParameter> after) {
        return null;
    }
}
