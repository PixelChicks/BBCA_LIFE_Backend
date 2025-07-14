package com.bbcalife.bbcalife.repository;

import com.bbcalife.bbcalife.model.entity.Article;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

    List<Article> findAllByOrderByCreatedAtDesc();

    List<Article> findAllByDeletedAtIsNullOrderByCreatedAtDesc();
    Page<Article> findByDeletedAtIsNull(Pageable pageable);

    @Query("""
    SELECT a FROM Article a 
    WHERE (:search IS NULL OR LOWER(a.title) LIKE LOWER(CONCAT('%', :search, '%')))
      AND (:category IS NULL OR a.category.category = :category)
    ORDER BY a.createdAt DESC
    """)
    List<Article> searchAndFilter(@Param("search") String search, @Param("category") String category);

}