package com.example.bootiful.article.service;

import com.example.bootiful.article.dao.ArticleRepository;
import com.example.bootiful.article.domain.Article;
import com.example.bootiful.article.web.dto.ArticleDto;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements ArticleService {
  private ArticleRepository articleRepository;
  private static final Logger logger = LoggerFactory.getLogger(ArticleServiceImpl.class);

  public ArticleServiceImpl(ArticleRepository articleRepository) {
    this.articleRepository = articleRepository;
  }

  //@Cacheable
  @Override
  public List<ArticleDto> getArticles() {
    List<Article> articles = articleRepository.findAll();
    return convertToArticleDtoList(articles);
  }

  //@Cacheable
  @Override
  public Optional<ArticleDto> findArticleById(Integer articleId) {
    logger.info("Attempt to fetch article information for id {} ", articleId);
    //simulateSlowService();
    Optional<Article> article = articleRepository.findById(articleId);
    if (article.isPresent()) {
      return Optional.of(convertToArticleDto(article.get()));
    }
    return Optional.ofNullable(null);
  }

  @Override
  public List<ArticleDto> findAllByPublicationTimeBetween(Date startTime, Date endTime) {
    return convertToArticleDtoList(
        articleRepository.findAllByPublicationTimeBetween(startTime, endTime));
  }

  public List<ArticleDto> findAllWithCreationDateTimeAfter(Date creationDateTime) {
    return convertToArticleDtoList(
        articleRepository.findAllWithCreationDateTimeAfter(creationDateTime));
  }

  public ArticleDto createArticle(Article article) {
    return convertToArticleDto(articleRepository.save(article));
  }

  public ArticleDto updateArticle(Integer articleId, Article article) {
    Optional<Article> articleToUpdate = articleRepository.findById(articleId);
    if (articleToUpdate.isPresent()) {
      Article updatedArticle = articleToUpdate.get().toBuilder()
          .publicationDate(article.getPublicationDate())
          .publicationTime(article.getPublicationTime())
          .creationDateTime(article.getCreationDateTime())
          .title(article.getTitle())
          .authors(article.getAuthors())
          .build();
      return convertToArticleDto(articleRepository.saveAndFlush(updatedArticle));
    }
    return null;
  }

  public void deleteArticle(Integer articleId) {
    Optional<Article> articleToDelete = articleRepository.findById(articleId);
    if (articleToDelete.isPresent()) {
      articleRepository.delete(articleToDelete.get());
    }
  }

  private List<ArticleDto> convertToArticleDtoList(List<Article> articles) {
    return articles.stream()
        .map(a -> convertToArticleDto(a))
        .collect(Collectors.toList());
  }

  private ArticleDto convertToArticleDto(Article article) {
    return ArticleDto.builder()
        .id(article.getId())
        .title(article.getTitle())
        .publicationDate(article.getPublicationDate())
        .publicationTime(article.getPublicationTime())
        .creationDateTime(article.getCreationDateTime())
        .rating(article.getRatings().stream()
            .map(r -> new Integer(r.getRating()))
            .collect(Collectors.toList())
        ).authors(
            article.getAuthors().stream()
                .map(t -> t.getFirstName() + " " + t.getLastName())
                .collect(Collectors.toList())
        ).comments(
            article.getComment().stream()
                .map(
                    r -> r.getText() + " - " + r.getWebuser().getFirstName() + " " + r.getWebuser()
                        .getLastName())
                .collect(Collectors.toList())
        ).build();
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
