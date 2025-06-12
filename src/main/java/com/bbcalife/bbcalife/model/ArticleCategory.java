package com.bbcalife.bbcalife.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cl_article_categories")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArticleCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Add more fields here as needed, for example:
    // private String name;
}
