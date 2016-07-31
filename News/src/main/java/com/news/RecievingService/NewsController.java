package com.news.RecievingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.news.framework.News;

@RestController
public class NewsController {
	@Autowired
	NewsService newsService;

    @RequestMapping(value ="/news", method = RequestMethod.POST)
    public String addNews(@RequestBody News news) {
    	newsService.processNews(news);
    	
    	return "Success";
    }
    @RequestMapping(value ="/news", method = RequestMethod.GET)
    public String getNews() {
    	return "Success";
    }
    
    @RequestMapping(value ="/", method = RequestMethod.GET)
    public String welcome() {
    	return "Welcome to the news system";
    }
}
