package com.assignment.demo.respository;

import com.assignment.demo.model.entity.Book;
import com.assignment.demo.model.entity.Comics;
import com.assignment.demo.model.entity.Magazine;
import com.assignment.demo.model.entity.Publication;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class SearchDao  {


    @PersistenceContext
    private EntityManager entityManager;


    public SearchDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Publication> getPublicationByGLobalSearch(List<String> list)
    {
//        List<SearchParameter> params = new ArrayList<SearchParameter>();
//         list.stream().forEach(s ->
//          params.add(new SearchParameter(s.substring(0,s.indexOf(":")), ":", s.substring(s.indexOf(":")+1))
//          )
//  );
        List<SearchParameter> params =  list.stream().map(s->new SearchParameter(s.substring(0,s.indexOf(":")), ":", s.substring(s.indexOf(":")+1))).collect(Collectors.toList());
        return this.searchPublisher(params);
    }

    private List<Publication> searchPublisher(List<SearchParameter> params) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Publication> query = builder.createQuery(Publication.class);
         Root r = query.from(Publication.class);
        Predicate predicate = builder.conjunction();




        PublicationSearchQueryCriteriaConsumer searchPublisher =
                new PublicationSearchQueryCriteriaConsumer(predicate, builder, r);
        params.stream().forEach(searchPublisher);
        predicate = searchPublisher.getPredicate();
        query.where(predicate);

        List<Publication> result = entityManager.createQuery(query).getResultList();
        return result;
    }


}
