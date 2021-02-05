package com.example.bootiful.article.service;

import com.example.bootiful.article.domain.Article;
import com.example.bootiful.article.web.dto.ArticleDto;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ArticleService {
    List<ArticleDto> getArticles();

    Optional<ArticleDto> findArticleById(Integer id);

    List<ArticleDto> findAllByPublicationTimeBetween(Date startTime, Date endTime);

    List<ArticleDto> findAllWithCreationDateTimeAfter(Date creationDateTime);

    ArticleDto createArticle(Article article);

    ArticleDto updateArticle(Integer articleId, Article article);

    void deleteArticle(Integer articleId);
}
