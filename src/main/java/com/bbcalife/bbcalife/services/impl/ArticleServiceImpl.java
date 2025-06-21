package com.bbcalife.bbcalife.services.impl;

import com.bbcalife.bbcalife.exceptions.articles.ArticleCategoryNotFoundException;
import com.bbcalife.bbcalife.exceptions.articles.ArticleNotFoundException;
import com.bbcalife.bbcalife.model.dto.request.ArticleRequest;
import com.bbcalife.bbcalife.model.dto.response.ArticleResponse;
import com.bbcalife.bbcalife.model.entity.Article;
import com.bbcalife.bbcalife.model.entity.ArticleCategory;
import com.bbcalife.bbcalife.repository.ArticleCategoryRepository;
import com.bbcalife.bbcalife.repository.ArticleRepository;
import com.bbcalife.bbcalife.services.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;
    private final ArticleCategoryRepository categoryRepository;

    @Override
    public ArticleResponse getById(Long id) {
        return articleRepository.findByIdAndDeletedAtIsNull(id)
                .map(this::mapToResponse)
                .orElseThrow(ArticleNotFoundException::new);
    }

    @Override
    public List<ArticleResponse> getAll() {
        return articleRepository.findAllByDeletedAtIsNull()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public ArticleResponse create(ArticleRequest request) {
        ArticleCategory category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(ArticleCategoryNotFoundException::new);

        Article article = Article.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .thumbnailPicture(request.getThumbnailPicture())
                .category(category)
                .visibility(request.getVisibility())
                .subcategory(request.getSubcategory())
                .calories(request.getCalories())
                .hours(request.getHours())
                .minutes(request.getMinutes())
                .createdAt(LocalDateTime.now())
                .build();

        return mapToResponse(articleRepository.save(article));
    }

    @Override
    public ArticleResponse update(Long id, ArticleRequest request) {
        Article article = articleRepository.findByIdAndDeletedAtIsNull(id)
                .orElseThrow(ArticleNotFoundException::new);

        ArticleCategory category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(ArticleCategoryNotFoundException::new);

        article.setTitle(request.getTitle());
        article.setDescription(request.getDescription());
        article.setThumbnailPicture(request.getThumbnailPicture());
        article.setCategory(category);
        article.setVisibility(request.getVisibility());
        article.setSubcategory(request.getSubcategory());
        article.setCalories(request.getCalories());
        article.setHours(request.getHours());
        article.setMinutes(request.getMinutes());
        article.setUpdatedAt(LocalDateTime.now());

        return mapToResponse(articleRepository.save(article));
    }

    @Override
    public void delete(Long id) {
        articleRepository.deleteById(id);
    }


    @Override
    public List<ArticleResponse> getByCategory(Long categoryId) {
        return articleRepository.findAllByCategoryIdAndDeletedAtIsNull(categoryId)
                .stream().map(this::mapToResponse)
                .toList();
    }

    @Override
    public List<ArticleResponse> getByVisibility(String visibility) {
        return articleRepository.findAllByVisibilityAndDeletedAtIsNull(visibility)
                .stream().map(this::mapToResponse)
                .toList();
    }

    @Override
    public List<ArticleResponse> getByCategoryAndVisibility(Long categoryId, String visibility) {
        return articleRepository.findAllByCategoryIdAndVisibilityAndDeletedAtIsNull(categoryId, visibility)
                .stream().map(this::mapToResponse)
                .toList();
    }

    private ArticleResponse mapToResponse(Article article) {
        return ArticleResponse.builder()
                .id(article.getId())
                .title(article.getTitle())
                .description(article.getDescription())
                .thumbnailPicture(article.getThumbnailPicture())
                .categoryName(article.getCategory().getCategory())
                .visibility(article.getVisibility())
                .subcategory(article.getSubcategory())
                .calories(article.getCalories())
                .hours(article.getHours())
                .minutes(article.getMinutes())
                .createdAt(article.getCreatedAt())
                .updatedAt(article.getUpdatedAt())
                .build();
    }
}