package com.assignment.demo.service;

import com.assignment.demo.model.entity.Publication;
import com.assignment.demo.respository.PublicationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LibraryPublicationService {

    private PublicationRepository publicationRepository;

    public LibraryPublicationService(PublicationRepository publicationRepository) {
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

    public Publication create(Publication publication) {
        return publicationRepository.save(publication);
    }
}
