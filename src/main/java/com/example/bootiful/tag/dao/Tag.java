package com.example.bootiful.tag.dao;

import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class Tag {
    private String label;
}
