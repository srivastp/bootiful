package com.example.bootiful.article.dao;

import com.example.bootiful.article.domain.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class ArticleRepositoryIntegrationTest {

    @Autowired
    private ArticleRepository articleRepository;

    @Test
    public void givenArticles_whenFindByPublicationDate_thenArticles1And2Returned() throws ParseException {
        List<Article> result = articleRepository.findAllByPublicationDate(
                new SimpleDateFormat("yyyy-MM-dd").parse("2018-01-01"));
        assertEquals(2, result.size());
        assertTrue(result.stream()
                .map(Article::getId)
                .allMatch(
                        id -> Arrays.asList(1, 2).contains(id)
                )
        );
    }

    @Test
    public void givenArticles_whenFindAllByPublicationTimeBetween_thenArticles2And3Returned() throws Exception {
        List<Article> result = articleRepository.findAllByPublicationTimeBetween(
                new SimpleDateFormat("HH:mm").parse("15:15"),
                new SimpleDateFormat("HH:mm").parse("16:30")
        );
        assertEquals(2, result.size());
        assertTrue(result.stream()
                .map(Article::getId)
                .allMatch(id -> Arrays.asList(2, 3).contains(id))
        );
    }

    @Test
    public void givenArticles_whenFindAllWithCreationDateTimeBefore_thenArticles2And3Returned() throws Exception {
        List<Article> result = articleRepository.findAllWithCreationDateTimeBefore(
                new SimpleDateFormat("yyyy-MM-dd HH:mm").parse("2017-12-15 10:00")
        );
        assertEquals(2, result.size());
        assertTrue(result.stream()
                .map(Article::getId)
                .allMatch(id -> Arrays.asList(2, 3).contains(id))
        );
    }

    @Test
    public void givenArticles_whenFindAllWithCreationDateTimeAfter_thenArticles2And3Returned() throws Exception {
        List<Article> result = articleRepository.findAllWithCreationDateTimeAfter(
                new SimpleDateFormat("yyyy-MM-dd HH:mm").parse("2017-12-15 10:00")
        );
        assertEquals(3, result.size());
        assertTrue(result.stream()
                .map(Article::getId)
                .allMatch(id -> Arrays.asList(1, 4, 5).contains(id))
        );
    }
}