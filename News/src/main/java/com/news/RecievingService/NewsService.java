package com.news.RecievingService;

import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import com.news.NewsApplication;
import com.news.config.BeanConfiguration;
import com.news.framework.News;
import com.news.framework.ThreadPool;

@Service
public class NewsService {	
	@Autowired
	BeanConfiguration beanConfiguration;
	
	@Autowired
	NewsApplication application;
	
    
    @Async
    public Future<Integer> processNews(News news) {
    	NewsProcessorTask task = beanConfiguration.newsProcessorTask(news);
    	ThreadPool.executeTask(task);
        
        return new AsyncResult<Integer>(0);
    }

}
