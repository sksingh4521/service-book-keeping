package com.assignment.demo.resources;


import com.assignment.demo.model.entity.Publication;
import com.assignment.demo.service.LibraryPublicationService;
import com.assignment.demo.respository.SearchParameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.assignment.demo.resources.UrlConstants.PUBLISHER;
import static com.assignment.demo.resources.UrlConstants.URI;

@RestController
@RequestMapping(URI + PUBLISHER)
public class LibraryPublicationsResources {

    private static final Logger logger = LoggerFactory.getLogger(LibraryAuthorsResources.class);

    private LibraryPublicationService publicationService;
    private Publication publication;

    public LibraryPublicationsResources(LibraryPublicationService publicationService) {
        this.publicationService = publicationService;


    }

    @PostMapping()
    public ResponseEntity<Publication> create(@RequestBody Publication publication) {
        logger.info("creating publication");
        return ResponseEntity.ok(publicationService.create(publication));

    }

    /*
    This method is only for testing purpose.
     */
    @PostMapping(value = "/multiple")
    public ResponseEntity<List<Publication>> createMultiple(@RequestBody List<Publication> publicationList) {
        logger.info("creating publication in bulk");
      return   ResponseEntity.ok(publicationList.stream().map(r -> publicationService.create(r)).collect(Collectors.toList()));

    }

    @PutMapping()
    public ResponseEntity<Publication> update(@RequestBody Publication publication) {
        logger.info("updatinging publication");
        return ResponseEntity.ok(publicationService.update(publication));

    }


    @GetMapping()
    public ResponseEntity<List<Publication>> list() {
        logger.info("listing publication");
        return ResponseEntity.ok(publicationService.list());


    }

    @DeleteMapping()
    public String delete(@PathVariable Long pub) {
        logger.info("deleting publication");
        publicationService.delete(pub);
        return "Deleted";

    }


    @GetMapping(value = "/search")
    public ResponseEntity<List<Publication>> getPublicationByGLobalSearch(@RequestBody List<String> list) {
        logger.info("custom search");
        ArrayList arrayList = new ArrayList();

        return ResponseEntity.ok(publicationService.getPublicationByGLobalSearch(list));

    }



}
