package com.assignment.demo.resources;

import com.assignment.demo.model.entity.Author;
import com.assignment.demo.service.LibraryAuthorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.assignment.demo.resources.UrlConstants.AUTHOR;
import static com.assignment.demo.resources.UrlConstants.URI;

@RestController
@RequestMapping(URI + AUTHOR)
public class LibraryAuthorsResources {

    private static final Logger logger = LoggerFactory.getLogger(LibraryAuthorsResources.class);
    private LibraryAuthorService libraryAuthorService;

    public LibraryAuthorsResources(LibraryAuthorService libraryAuthorService) {
        this.libraryAuthorService = libraryAuthorService;
    }

    @PostMapping()
    public ResponseEntity<Author> createAuthor(@RequestBody Author author) {
        logger.info("creating author..");
        return ResponseEntity.ok(libraryAuthorService.create(author));


    }

    @PutMapping()
    public ResponseEntity<Author> update(@RequestBody Author author) {
        logger.info("updating author..");
        return ResponseEntity.ok(libraryAuthorService.update(author));

    }


    @GetMapping()
    public ResponseEntity<List<Author>> list() {
        logger.info("fetching authors..");
        return ResponseEntity.ok(libraryAuthorService.list());


    }

    @DeleteMapping()
    public ResponseEntity<String> deleteEmployee(@PathVariable String authorName) {
        logger.info("deleting author..");
        return ResponseEntity.ok("Deleted Successfully");
    }

}

