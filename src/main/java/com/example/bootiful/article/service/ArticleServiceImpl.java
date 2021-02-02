package com.example.bootiful.article.service;

import com.example.bootiful.article.dao.ArticleRepository;
import com.example.bootiful.article.domain.Article;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ArticleServiceImpl implements ArticleService {
    private ArticleRepository articleRepository;
    private static final Logger logger = LoggerFactory.getLogger(ArticleServiceImpl.class);

    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    //@Cacheable
    @Override
    public List<Article> getArticles() {
        return articleRepository.findAll();
    }

    //@Cacheable
    @Override
    public Optional<Article> findArticleById(Integer articleId) {
        logger.info("Attempt to fetch article information for id {} ", articleId);
        //simulateSlowService();
        return articleRepository.findById(articleId);
    }

    @Override
    public List<Article> findAllByPublicationTimeBetween(Date startTime, Date endTime) {
        return articleRepository.findAllByPublicationTimeBetween(startTime, endTime);
    }

    public List<Article> findAllWithCreationDateTimeAfter(Date creationDateTime) {
        return articleRepository.findAllWithCreationDateTimeAfter(creationDateTime);
    }

    public Article createArticle(Article article) {
        return articleRepository.save(article);
    }

    public Article updateArticle(Integer articleId, Article article) {
        Optional<Article> articleToUpdate = findArticleById(articleId);
        if (articleToUpdate.isPresent()) {
            Article updatedArticle = articleToUpdate.get().toBuilder()
                    .publicationDate(article.getPublicationDate())
                    .publicationTime(article.getPublicationTime())
                    .creationDateTime(article.getCreationDateTime())
                    .title(article.getTitle())
                    .build();
            return articleRepository.saveAndFlush(updatedArticle);
        }
        return null;
    }

    public void deleteArticle(Integer articleId) {
        Optional<Article> articleToDelete = findArticleById(articleId);
        if (articleToDelete.isPresent()) {
            articleRepository.delete(articleToDelete.get());
        }
    }

    private void simulateSlowService() {
        try {
            long time = 3000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}
