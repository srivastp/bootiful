package com.example.bootiful.config.actuator;

import com.example.bootiful.article.dao.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;

import java.util.HashMap;
import java.util.Map;

//@Component
public class TotalUsersInfoContributor implements InfoContributor {

    @Autowired
    ArticleRepository articleRepository;

    @Override
    public void contribute(Info.Builder builder) {
        Map<String, Integer> articleDetails = new HashMap<>();
        int articleCount = articleRepository.findAll().size();
        articleDetails.put("total", articleCount);
        articleDetails.put("active", 4);
        articleDetails.put("inactive", 6);
        builder.withDetail("articles", articleDetails);
    }
}