package com.assignment.demo.service;

import com.assignment.demo.model.entity.Publication;
import com.assignment.demo.respository.PublicationRepository;
import com.assignment.demo.respository.SearchDao;
import com.assignment.demo.respository.SearchParameter;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Year;
import java.util.List;

@Service
public class LibraryPublicationService {

    private SearchDao searchDao;

    private PublicationRepository publicationRepository;

    public LibraryPublicationService(SearchDao searchDao, PublicationRepository publicationRepository) {
        this.searchDao = searchDao;
        this.publicationRepository = publicationRepository;
    }

    public void delete(Long pubId) {
        publicationRepository.deleteById(pubId);
    }

    public List<Publication> list() {
        return publicationRepository.findAll();
    }

    public Publication update(Publication publication) {
        return publicationRepository.save(publication);
    }

    @Transactional
    public Publication create(Publication publication) {
        return publicationRepository.save(publication);
    }


    public List<Publication> getPublicationByGLobalSearch(List<String> list)
    {
       return searchDao.getPublicationByGLobalSearch(list);
    }
}
