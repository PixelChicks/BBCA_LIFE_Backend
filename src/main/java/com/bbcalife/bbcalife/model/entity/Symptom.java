package com.bbcalife.bbcalife.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "symptoms")
@Getter
@Setter
public class Symptom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String category;

    private String region;

    private String name;

    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;
}

