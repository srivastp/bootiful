package com.example.bootiful.article.web;

import com.example.bootiful.article.domain.Article;
import com.example.bootiful.article.service.ArticleService;
import com.example.bootiful.article.web.dto.ArticleDto;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class ArticleController {
    private ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/articles")
    public List<ArticleDto> getArticles(
            @Param("startTime") @DateTimeFormat(pattern = "HH:mm") Optional<Date> startTime,
            @Param("endTime") @DateTimeFormat(pattern = "HH:mm") Optional<Date> endTime,
            @Param("creationDateTime") @DateTimeFormat(pattern = "MM-dd-yyyy")
                    Optional<Date> creationDateTime
    ) {
        List<ArticleDto> articles;
        if (creationDateTime.isPresent()) {
            articles = articleService.findAllWithCreationDateTimeAfter(creationDateTime.get());
        } else if (startTime.isPresent() && endTime.isPresent()) {
            articles = articleService.findAllByPublicationTimeBetween(startTime.get(), endTime.get());
        } else {
            articles = articleService.getArticles();
        }
        return articles;
    }

    @GetMapping("/articles/{articleId}")
    public Optional<ArticleDto> getArticleById(@PathVariable("articleId") Integer articleId) {
        Optional<ArticleDto> article = articleService.findArticleById(articleId);
        return article;
    }

    @PostMapping("/articles")
    @ResponseStatus(HttpStatus.CREATED)
    public ArticleDto createArticle(@RequestBody Article article) {
        ArticleDto newArticle = articleService.createArticle(article);
        return newArticle;
    }

    @PutMapping("/articles/{articleId}")
    @ResponseStatus(HttpStatus.OK)
    public ArticleDto updateArticle(
            @PathVariable("articleId") Integer articleId,
            @RequestBody Article article) {
        ArticleDto updatedArticle = articleService.updateArticle(articleId, article);
        return updatedArticle;
    }

    @DeleteMapping("/articles/{articleId}")
    @ResponseStatus(HttpStatus.OK)
    public void updateArticle(@PathVariable("articleId") Integer articleId) {
        articleService.deleteArticle(articleId);
    }
}
