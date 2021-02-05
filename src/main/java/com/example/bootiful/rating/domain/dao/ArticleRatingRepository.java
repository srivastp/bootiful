package com.example.bootiful.rating.domain.dao;

import com.example.bootiful.rating.domain.ArticleRating;
import com.example.bootiful.rating.domain.ArticleRatingKey;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRatingRepository extends JpaRepository<ArticleRating, ArticleRatingKey> {

  //ToDo - Verify the query
  List<ArticleRating> findByArticleId(Integer articleId);

  List<ArticleRating> findByWebuserId(Long webuserId);

  List<ArticleRating> findByWebuserIdAndArticleId(Long webuserId, Integer ArticleId);
}
