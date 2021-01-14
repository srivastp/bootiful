package com.example.bootiful.config;

import com.example.bootiful.config.contributor.TotalUsersInfoContributor;
import guru.springframework.norris.chuck.ChuckNorrisInfoContributor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChuckNorrisConfig {

    @Bean
    public ChuckNorrisInfoContributor chuckNorrisInfoContributor(){
        return new ChuckNorrisInfoContributor();
    }

    @Bean
    public TotalUsersInfoContributor totalUsersInfoContributor(){
        return new TotalUsersInfoContributor();
    }
}
