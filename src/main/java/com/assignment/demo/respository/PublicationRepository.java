package com.assignment.demo.respository;

import com.assignment.demo.model.entity.Publication;
import com.assignment.demo.model.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublicationRepository extends JpaRepository<Publication, Tag> {
}
