package com.emirhanuzun.springcore.config;

import com.emirhanuzun.springcore.common.Coach;
import com.emirhanuzun.springcore.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean("aquatic")
    public Coach swimCoach(){
        return new SwimCoach();
    }

}
