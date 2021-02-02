package com.example.bootiful.article.service;

import com.example.bootiful.article.domain.Article;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ArticleService {
    List<Article> getArticles();

    Optional<Article> findArticleById(Integer id);

    List<Article> findAllByPublicationTimeBetween(Date startTime, Date endTime);

    List<Article> findAllWithCreationDateTimeAfter(Date creationDateTime);

    Article createArticle(Article article);

    Article updateArticle(Integer articleId, Article article);

    void deleteArticle(Integer articleId);
}
