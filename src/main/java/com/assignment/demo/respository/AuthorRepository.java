package com.assignment.demo.respository;

import com.assignment.demo.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    void deleteByName(String name);
}
