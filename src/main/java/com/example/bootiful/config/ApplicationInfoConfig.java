package com.example.bootiful.config;

import com.example.bootiful.config.actuator.TotalUsersInfoContributor;
import guru.springframework.norris.chuck.ChuckNorrisInfoContributor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationInfoConfig {

    @Bean
    public ChuckNorrisInfoContributor chuckNorrisInfoContributor(){
        return new ChuckNorrisInfoContributor();
    }

    @Bean
    public TotalUsersInfoContributor totalUsersInfoContributor(){
        return new TotalUsersInfoContributor();
    }
}
