package com.bbcalife.bbcalife.controller;

import com.bbcalife.bbcalife.model.dto.request.ArticleRequest;
import com.bbcalife.bbcalife.model.dto.response.ArticleResponse;
import com.bbcalife.bbcalife.model.entity.Article;
import com.bbcalife.bbcalife.services.ArticleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/articles")
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @PostMapping("/create")
    public ResponseEntity<ArticleResponse> create(@RequestBody ArticleRequest request) {
        return ResponseEntity.ok(articleService.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ArticleResponse> update(
            @PathVariable Long id,
            @RequestBody ArticleRequest request) {
        return ResponseEntity.ok(articleService.update(id, request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArticleResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(articleService.getById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ArticleResponse>> getAll() {
        return ResponseEntity.ok(articleService.getAll());
    }

    @GetMapping("/filterSearch")
    public ResponseEntity<List<ArticleResponse>> searchArticlesFilter(
            @RequestParam(required = false) String search,
            @RequestParam(required = false) String category
    ) {
        return ResponseEntity.ok(articleService.searchArticlesFilter(search, category));
    }


    @GetMapping("/allNotDeleted")
    public ResponseEntity<List<ArticleResponse>> getAllDeletedAtNull() {
        return ResponseEntity.ok(articleService.getAllNotDeleted());
    }

    @GetMapping("/newest-not-deleted")
    public List<ArticleResponse> getNewestNotDeleted(@RequestParam(defaultValue = "3") int limit) {
        return articleService.getNewestNotDeleted(limit);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        articleService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<List<ArticleResponse>> getByCategory(@PathVariable Long id) {
        return ResponseEntity.ok(articleService.getByCategory(id));
    }

    @GetMapping("/visibility/{visibility}")
    public ResponseEntity<List<ArticleResponse>> getByVisibility(@PathVariable String visibility) {
        return ResponseEntity.ok(articleService.getByVisibility(visibility));
    }

    @GetMapping("/filter")
    public ResponseEntity<List<ArticleResponse>> getByCategoryAndVisibility(
            @RequestParam Long categoryId,
            @RequestParam String visibility) {
        return ResponseEntity.ok(articleService.getByCategoryAndVisibility(categoryId, visibility));
    }

}