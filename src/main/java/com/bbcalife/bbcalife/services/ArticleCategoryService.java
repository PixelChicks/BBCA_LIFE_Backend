package com.bbcalife.bbcalife.services;


import com.bbcalife.bbcalife.model.entity.ArticleCategory;

import java.util.List;
import java.util.Optional;

public interface ArticleCategoryService {
    ArticleCategory create(ArticleCategory category);
    ArticleCategory update(Long id, ArticleCategory category);
    void delete(Long id);
    Optional<ArticleCategory> getById(Long id);
    List<ArticleCategory> getAll();
}
