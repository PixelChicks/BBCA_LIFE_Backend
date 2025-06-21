package com.bbcalife.bbcalife.repository;

import com.bbcalife.bbcalife.model.entity.ArticleCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleCategoryRepository extends JpaRepository<ArticleCategory, Long> {
}

