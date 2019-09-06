package com.assignment.demo.search;


import com.assignment.demo.entity.Publication;
import com.assignment.demo.search.model.*;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.SingularAttribute;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Consumer;

public class PublicationSearchQueryCriteriaConsumer implements Consumer<SearchParameter> {


    private Predicate predicate;
    private CriteriaBuilder builder;
    private Root root;

    private static HashMap modelMap = new HashMap<>();


    static {
        modelMap.put("book", new BookSearchModel());
        modelMap.put("magazine", new MagazineSearchModel());
        modelMap.put("comics", new ComicSsearchModel());
        modelMap.put("author", new AuthorSearchModel());
        modelMap.put("title", new SimpleSearchModel());
        modelMap.put("year", new SimpleSearchModel());
    }

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

          modelMap.forEach((key,value) -> {
              if (searchParameter.getKey().equals(key)) {
                  LibraryBaseModel libraryBaseModel = (LibraryBaseModel)value;
                  try {
                      predicate = libraryBaseModel.seacrh(searchParameter,root,predicate,builder);
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
}
