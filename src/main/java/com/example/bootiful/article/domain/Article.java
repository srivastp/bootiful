package com.example.bootiful.article.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Data
@Entity
public class Article {

    @Id
    @GeneratedValue
    Integer id;

    @Temporal(TemporalType.DATE)
    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy")
    Date publicationDate;

    @Temporal(TemporalType.TIME)
    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "hh:mm:ss")
    Date publicationTime;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy hh:mm:ss")
    Date creationDateTime;

    String title;

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}