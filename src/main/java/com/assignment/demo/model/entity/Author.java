package com.assignment.demo.model.entity;

import com.assignment.demo.audit.AuditLibraryKeeping;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Author extends AuditLibraryKeeping {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "authId")
    private Long Id;
    private String name;
    @ManyToMany
    private List<Publication> publicationList = new ArrayList<Publication>();

    public List<Publication> getPublicationList() {
        return publicationList;
    }

    public void setPublicationList(List<Publication> publicationList) {
        this.publicationList = publicationList;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
