package com.bbcalife.bbcalife.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArticleRequest {
    private String title;
    private String description;
    private String thumbnailPicture;
    private Long categoryId;
    private String visibility;
    private String subcategory;
    private Short calories;
    private Byte hours;
    private Byte minutes;
}
