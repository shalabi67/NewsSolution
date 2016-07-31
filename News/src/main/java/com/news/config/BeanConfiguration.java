package com.news.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

import com.news.RecievingService.NewsProcessorTask;
import com.news.framework.News;

@Configuration

public class BeanConfiguration {
	@Bean
	@Scope(value="prototype", proxyMode = ScopedProxyMode.NO)		 
    public NewsProcessorTask newsProcessorTask(News news) {
        return new NewsProcessorTask(news);
    }
}
