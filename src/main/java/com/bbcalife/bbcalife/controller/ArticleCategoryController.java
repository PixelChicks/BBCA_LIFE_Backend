package com.bbcalife.bbcalife.controller;

import com.bbcalife.bbcalife.model.entity.ArticleCategory;
import com.bbcalife.bbcalife.services.ArticleCategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/article-categories")
public class ArticleCategoryController {

    private final ArticleCategoryService articleCategoryService;

    public ArticleCategoryController(ArticleCategoryService articleCategoryService) {
        this.articleCategoryService = articleCategoryService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArticleCategory> getCategoryById(@PathVariable Long id) {
        return articleCategoryService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/all")
    public ResponseEntity<List<ArticleCategory>> getAllCategories() {
        return ResponseEntity.ok(articleCategoryService.getAll());
    }

    @PostMapping("/create")
    public ResponseEntity<ArticleCategory> createCategory(@RequestBody ArticleCategory category) {
        return ResponseEntity.ok(articleCategoryService.create(category));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ArticleCategory> updateCategory(
            @PathVariable Long id, @RequestBody ArticleCategory category) {
        return ResponseEntity.ok(articleCategoryService.update(id, category));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        articleCategoryService.delete(id);
        return ResponseEntity.noContent().build();
    }
}