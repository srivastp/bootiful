package com.example.bootiful.webuser.dao;

import com.example.bootiful.article.domain.Article;
import com.example.bootiful.webuser.domain.Webuser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WebuserRepository extends JpaRepository<Webuser, Long> {

}
