package com.assignment.demo.resources;

import com.assignment.demo.model.api.AuthorDTO;
import com.assignment.demo.model.entity.Author;
import com.assignment.demo.service.LibraryAuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.assignment.demo.resources.UrlConstants.URI;

@RestController
    @RequestMapping(URI)
    public class LibraryAuthorsResources {

    private  LibraryAuthorService libraryAuthorService;
    private Author author;

    public LibraryAuthorsResources(LibraryAuthorService libraryAuthorService) {
        this.libraryAuthorService = libraryAuthorService;
    }

    @PostMapping()
        public ResponseEntity<AuthorDTO> createAuthor(@RequestBody AuthorDTO authorDTO) {
            libraryAuthorService.create(author);

          return null;
        }

        @PutMapping()
        public AuthorDTO update(@RequestBody AuthorDTO authorDTO  )  {
            libraryAuthorService.update(author);


            return null;
        }


        @GetMapping()
        public ResponseEntity<List<AuthorDTO>> list() {
            libraryAuthorService.list();
            return null;


        }

        @DeleteMapping()
        public String deleteEmployee(@PathVariable String authorName) {
            libraryAuthorService.delete(authorName);
            return null;
        }

    }

