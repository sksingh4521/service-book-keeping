package com.assignment.demo.resources;


import com.assignment.demo.model.entity.Publication;
import com.assignment.demo.service.LibraryPublicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.assignment.demo.resources.UrlConstants.URI;
import static com.assignment.demo.resources.UrlConstants.VERSIONED_API;

@RestController
@RequestMapping(URI)
public class LibraryPublicationsResources {

    private LibraryPublicationService publicationService;
    private Publication publication;

    public LibraryPublicationsResources(LibraryPublicationService publicationService) {
        this.publicationService = publicationService;


    }

    @PostMapping()
    public ResponseEntity<Publication> create(@RequestBody Publication publication) {
return ResponseEntity.ok(publicationService.create(publication));

    }

    @PutMapping()
    public ResponseEntity<Publication> update(@RequestBody Publication publication) {
        return ResponseEntity.ok(publicationService.update(publication));

    }


    @GetMapping()
    public ResponseEntity<List<Publication>> list() {
   return   ResponseEntity.ok(publicationService.list());



    }

    @DeleteMapping()
    public String delete(@PathVariable Long pub) {
        publicationService.delete(pub);
        return null;
    }

}
