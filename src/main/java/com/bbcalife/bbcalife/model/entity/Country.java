package com.bbcalife.bbcalife.model.entity;

import jakarta.persistence.*;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Entity
@ToString
@RequiredArgsConstructor
@Table(name = "countries")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

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
}