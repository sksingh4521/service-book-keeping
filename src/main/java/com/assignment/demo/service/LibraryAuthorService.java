package com.assignment.demo.service;

import com.assignment.demo.entity.Author;
import com.assignment.demo.respository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryAuthorService {

    private AuthorRepository authorRepository;

    public LibraryAuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public void delete(String authorName) {
        authorRepository.deleteByName(authorName);
    }

    public Author create(Author author) {

        return authorRepository.save(author);
    }

    public Author update(Author author) {
        return authorRepository.save(author);
    }

    public List<Author> list() {
        return authorRepository.findAll();

    }
}
