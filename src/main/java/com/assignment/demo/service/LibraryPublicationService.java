package com.assignment.demo.service;

import com.assignment.demo.model.entity.Publication;
import com.assignment.demo.respository.PublicationRepository;
import com.assignment.demo.dao.GlobalSearchDao;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class LibraryPublicationService {

    private GlobalSearchDao globalSearchDao;

    private PublicationRepository publicationRepository;

    public LibraryPublicationService(GlobalSearchDao globalSearchDao, PublicationRepository publicationRepository) {
        this.globalSearchDao = globalSearchDao;
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
       return globalSearchDao.getPublicationByGLobalSearch(list);
    }
}
