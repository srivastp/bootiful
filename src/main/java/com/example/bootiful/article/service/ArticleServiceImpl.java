package com.example.bootiful.article.service;

import com.example.bootiful.article.domain.Article;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements ArticleService {

    private static final Logger logger = LoggerFactory.getLogger(ArticleServiceImpl.class);

    //@Cacheable
    @Override
    public Article getArticleById(Long articleId) {
        logger.info("Trying to get article information for id {} ", articleId);
        simulateSlowService();
        return getArticleDetailsById(articleId);
    }

    private void simulateSlowService() {
        try {
            long time = 3000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }

    private Article getArticleDetailsById(final Long id){
        return  new Article();
    }
}
