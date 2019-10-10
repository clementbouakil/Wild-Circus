package com.clementbouakil.wildCircus.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Spectacle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Spectacle() {
    }

    public Spectacle(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Spectacle(String name, String description) {
        this.name = name;
        this.description = description;
    }
    
}