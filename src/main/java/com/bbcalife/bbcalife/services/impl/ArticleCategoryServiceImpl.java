package com.bbcalife.bbcalife.services.impl;

import com.bbcalife.bbcalife.model.entity.ArticleCategory;
import com.bbcalife.bbcalife.repository.ArticleCategoryRepository;
import com.bbcalife.bbcalife.services.ArticleCategoryService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleCategoryServiceImpl implements ArticleCategoryService {

    private final ArticleCategoryRepository articleCategoryRepository;

    @Autowired
    public ArticleCategoryServiceImpl(ArticleCategoryRepository articleCategoryRepository) {
        this.articleCategoryRepository = articleCategoryRepository;
    }

    @Override
    public ArticleCategory create(ArticleCategory category) {
        try {
            category.setId(null);
            return articleCategoryRepository.save(category);
        } catch (Exception e){
            System.out.println(e.toString());
        }
        return new ArticleCategory();
    }

    @Override
    public ArticleCategory update(Long id, ArticleCategory updatedCategory) {
        ArticleCategory existing = articleCategoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Category not found"));

        existing.setCategory(updatedCategory.getCategory());
        return articleCategoryRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        articleCategoryRepository.deleteById(id);
    }

    @Override
    public Optional<ArticleCategory> getById(Long id) {
        return articleCategoryRepository.findById(id);
    }

    @Override
    public List<ArticleCategory> getAll() {
        return articleCategoryRepository.findAll();
    }
}
