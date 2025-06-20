package com.bbcalife.bbcalife.repository;

import com.bbcalife.bbcalife.model.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

    List<Article> findAllByDeletedAtIsNull();

    Optional<Article> findByIdAndDeletedAtIsNull(Long id);

    List<Article> findAllByCategoryIdAndDeletedAtIsNull(Long categoryId);

    List<Article> findAllByVisibilityAndDeletedAtIsNull(String visibility);

    List<Article> findAllByCategoryIdAndVisibilityAndDeletedAtIsNull(Long categoryId, String visibility);
}