package com.bbcalife.bbcalife.model.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    // More fields...
}
