package com.bbcalife.bbcalife.services;

import com.bbcalife.bbcalife.model.dto.request.ArticleRequest;
import com.bbcalife.bbcalife.model.dto.response.ArticleResponse;

import java.util.List;

public interface ArticleService {
    ArticleResponse create(ArticleRequest request);
    ArticleResponse update(Long id, ArticleRequest request);
    void delete(Long id);
    ArticleResponse getById(Long id);
    List<ArticleResponse> getAll();
    List<ArticleResponse> getAllNotDeleted();
    List<ArticleResponse> getByCategory(Long categoryId);
    List<ArticleResponse> getByVisibility(String visibility);
    List<ArticleResponse> getByCategoryAndVisibility(Long categoryId, String visibility);
}