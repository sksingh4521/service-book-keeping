package com.assignment.demo.resources;

import com.assignment.demo.model.api.PublicationDTO;
import com.assignment.demo.model.entity.Publication;
import com.assignment.demo.service.LibraryPublicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.assignment.demo.resources.UrlConstants.VERSIONED_API;
@RestController
@RequestMapping(VERSIONED_API)
public class LibraryPublicationsResources {

    private LibraryPublicationService publicationService;
private Publication publication;
    public LibraryPublicationsResources(LibraryPublicationService publicationService) {
        this.publicationService = publicationService;


    }

    @PostMapping()
        public ResponseEntity<PublicationDTO> create(@RequestBody PublicationDTO publicationDTO) {
            publicationService.create(publication);

            return null;
        }

        @PutMapping()
        public PublicationDTO update(@RequestBody PublicationDTO publicationDTO)

        {
            publicationService.update(publication);
            return null;
        }


        @GetMapping()
        public ResponseEntity<List<PublicationDTO>> list() {
            publicationService.list();
            return null;


        }

        @DeleteMapping()
        public String delete(@PathVariable String pub)

        {
            publicationService.delete(pub);
            return null;
        }

    }
