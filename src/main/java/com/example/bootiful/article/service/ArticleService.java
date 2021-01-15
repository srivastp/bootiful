package com.example.bootiful.article.service;

import com.example.bootiful.article.domain.Article;

public interface ArticleService {
    Article getArticleById(final Long articleId);
}
