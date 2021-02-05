package com.example.bootiful.rating.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
//@Data
@Getter
@Setter
@Embeddable
public class ArticleRatingKey implements Serializable {

  @Column(name = "article_id")
  private Integer articleId;

  @Column(name = "webuser_id")
  private Long webuserId;

  @Override
  public int hashCode() {
    final int prime = 21;
    int result = 1;
    result = prime * result + (((articleId == null)) ? 0 : articleId.hashCode());
    result = prime * result + (((webuserId == null)) ? 0 : articleId.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    ArticleRatingKey other = (ArticleRatingKey) obj;
    if (articleId == null) {
      if (other.articleId != null) {
        return false;
      } else if (!articleId.equals(other.articleId)) {
        return false;
      }
    }
    if (webuserId == null) {
      if (other.webuserId != null) {
        return false;
      } else if (!webuserId.equals(other.webuserId)) {
        return false;
      }
    }
    return true;
  }
}