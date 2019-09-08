package com.assignment.demo.search.model;

import java.util.HashMap;

public class SearchDictionary {
    private static HashMap modelMap = new HashMap<>();

    static {
        modelMap.put("book", new BookSearchModel());
        modelMap.put("magazine", new MagazineSearchModel());
        modelMap.put("comics", new ComicSsearchModel());
        modelMap.put("author", new AuthorSearchModel());
        modelMap.put("title", new SimpleSearchModel());
        modelMap.put("year", new SimpleSearchModel());
    }

    private SearchDictionary() {

    }

    public static HashMap getModelMap() {
        return modelMap;
    }


}
