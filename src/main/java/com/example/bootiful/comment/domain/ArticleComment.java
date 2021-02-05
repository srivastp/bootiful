package com.example.bootiful.comment.domain;

import com.example.bootiful.article.domain.Article;
import com.example.bootiful.rating.domain.ArticleRatingKey;
import com.example.bootiful.webuser.domain.Webuser;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIdentityInfo(
    generator = ObjectIdGenerators.PropertyGenerator.class,
    property = "id")
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
//@Data
@Getter
@Setter
@Entity
public class ArticleComment {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  @ManyToOne
  @MapsId("articleId")
  @JoinColumn(name = "article_id")
  Article article;

  @ManyToOne
  @MapsId("webuserId")
  @JoinColumn(name = "webuser_id")
  Webuser webuser;

  @Column
  String text;

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (((id == null)) ? 0 : id.hashCode());
    //result = prime * result + (((comment == null)) ? 0 : comment.hashCode());
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
    ArticleComment other = (ArticleComment) obj;
    if (id == null) {
      if (other.id != null) {
        return false;
      } else if (!id.equals(other.id)) {
        return false;
      }
    }
    /*if (comment == null) {
      if (other.comment != null) {
        return false;
      } else if (!comment.equals(other.comment)) {
        return false;
      }
    }*/
    return true;
  }
}
