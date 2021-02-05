package com.example.bootiful.article.domain;

import com.example.bootiful.author.domain.Author;
import com.example.bootiful.comment.domain.ArticleComment;
import com.example.bootiful.rating.domain.ArticleRating;
import com.example.bootiful.tag.dao.Tag;
import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

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
public class Article {

    @Id
    @GeneratedValue
    private Integer id;

    @Temporal(TemporalType.DATE)
    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy")
    private Date publicationDate;

    @Temporal(TemporalType.TIME)
    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "hh:mm:ss")
    private Date publicationTime;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy hh:mm:ss")
    private Date creationDateTime;

    private String title;

    @ManyToMany(mappedBy = "articles", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Author> authors;

    @OneToMany(mappedBy = "article")
    List<ArticleRating> ratings;

    @OneToMany(mappedBy = "article")
    List<ArticleComment> comment;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "label", column = @Column(name = "article_tag"))
    })
    private Tag label;


    @Override
    public int hashCode() {
        final int prime = 21;
        int result = 1;
        result = prime * result + (((publicationDate == null)) ? 0 : publicationDate.hashCode());
        result = prime * result + (((publicationTime == null)) ? 0 : publicationTime.hashCode());
        result = prime * result + (((creationDateTime == null)) ? 0 : creationDateTime.hashCode());
        result = prime * result + (((title == null)) ? 0 : title.hashCode());
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
        Article other = (Article) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            } else if (!id.equals(other.id)) {
                return false;
            }
        }
        if (publicationDate == null) {
            if (other.publicationDate != null) {
                return false;
            } else if (!publicationDate.equals(other.publicationDate)) {
                return false;
            }
        }
        if (publicationTime == null) {
            if (other.publicationTime != null) {
                return false;
            } else if (!publicationTime.equals(other.publicationTime)) {
                return false;
            }
        }
        if (creationDateTime == null) {
            if (other.creationDateTime != null) {
                return false;
            } else if (!creationDateTime.equals(other.creationDateTime)) {
                return false;
            }
        }
        if (title == null) {
            if (other.title != null) {
                return false;
            } else if (!title.equals(other.title)) {
                return false;
            }
        }
        return true;
    }
}