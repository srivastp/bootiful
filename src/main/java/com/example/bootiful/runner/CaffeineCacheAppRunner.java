package com.example.bootiful.runner;

import com.example.bootiful.article.service.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CaffeineCacheAppRunner implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(CaffeineCacheAppRunner.class);

    private final ArticleService articleService;

    public CaffeineCacheAppRunner(ArticleService articleService) {
        this.articleService = articleService;
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info(".... Fetching Articles to test Caffeine Cache");
        /*logger.info("1 -->" + articleService.getArticleById(1L));
        logger.info("2 -->" + articleService.getArticleById(2L));
        logger.info("1 -->" + articleService.getArticleById(1L));
        logger.info("2 -->" + articleService.getArticleById(2L));
        logger.info("3 -->" + articleService.getArticleById(3L));*/
    }

}
