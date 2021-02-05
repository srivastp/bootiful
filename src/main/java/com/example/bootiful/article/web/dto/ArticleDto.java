package com.example.bootiful.article.web.dto;

import com.example.bootiful.rating.domain.ArticleRating;
import com.example.bootiful.tag.dao.Tag;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ArticleDto {
    Integer id;
    String title;
    Date publicationDate;
    Date publicationTime;
    Date creationDateTime;
    List<String> authors;
    List<Integer> rating;
    List<String> comments;
    Tag tag;
}
