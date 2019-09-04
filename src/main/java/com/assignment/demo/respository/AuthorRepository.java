package com.assignment.demo.respository;

import com.assignment.demo.model.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    void deleteByName(String name);
}
