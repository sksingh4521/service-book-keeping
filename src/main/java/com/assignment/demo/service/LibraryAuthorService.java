package com.assignment.demo.service;

import com.assignment.demo.model.entity.Author;
import com.assignment.demo.respository.AuthorRepository;

import java.util.List;

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
