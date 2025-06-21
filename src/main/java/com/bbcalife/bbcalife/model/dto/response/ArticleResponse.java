package com.bbcalife.bbcalife.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArticleResponse {
    private Long id;
    private String title;
    private String description;
    private String thumbnailPicture;
    private String categoryName;
    private String visibility;
    private String subcategory;
    private Short calories;
    private Byte hours;
    private Byte minutes;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

