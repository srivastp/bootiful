package com.example.bootiful.webuser.domain;

import com.example.bootiful.comment.domain.ArticleComment;
import com.example.bootiful.rating.domain.ArticleRating;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
public class Webuser {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String username;

  @Column(nullable = false)
  private String firstName;

  @Column(nullable = false)
  private String lastName;

  @OneToMany(mappedBy = "webuser")
  List<ArticleRating> ratings;

  @OneToMany(mappedBy = "webuser")
  List<ArticleComment> comment;

  @Override
  public int hashCode() {
    final int prime = 21;
    int result = 1;
    result = prime * result + (((id == null)) ? 0 : id.hashCode());
    result = prime * result + (((firstName == null)) ? 0 : firstName.hashCode());
    result = prime * result + (((lastName == null)) ? 0 : lastName.hashCode());
    result = prime * result + (((username == null)) ? 0 : username.hashCode());
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
    Webuser other = (Webuser) obj;
    if (id == null) {
      if (other.id != null) {
        return false;
      } else if (!id.equals(other.id)) {
        return false;
      }
    }
    if (firstName == null) {
      if (other.firstName != null) {
        return false;
      } else if (!firstName.equals(other.firstName)) {
        return false;
      }
    }
    if (lastName == null) {
      if (other.lastName != null) {
        return false;
      } else if (!lastName.equals(other.lastName)) {
        return false;
      }
    }
    if (username == null) {
      if (other.username != null) {
        return false;
      } else if (!username.equals(other.username)) {
        return false;
      }
    }
    return true;
  }
}