package com.newsserver;

import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.client.RestTemplate;

import com.news.framework.News;
import com.news.framework.NewsCategory;

@SpringBootApplication
@EnableConfigurationProperties
public class NewsServerApplication implements CommandLineRunner {
	@Value("${recievingServiceUrl}")
	private String serviceUrl;
    
	public static void main(String[] args) {
		SpringApplication.run(NewsServerApplication.class, args);
		
	}


	@Override
	public void run(String... arg0) throws Exception {
		NewsCategory[] newsCategoryList = {NewsCategory.General, NewsCategory.News, NewsCategory.Sports, NewsCategory.General};
		Random randomGenerator = new Random();
		String newsData = "";
		byte start = 0x41;  // charcter a
		byte end = 0x61 + 26;  // charcter Z
		byte count = start;
		RestTemplate restTemplate = new RestTemplate();
		while(true) {
			newsData += (char)count;
			for(byte i=start; i<end;i++) { 
				int randomInt = randomGenerator.nextInt(4);
				News news = News.create(newsCategoryList[randomInt], newsData + (char)i, "my server" + randomInt);
				//System.out.println(news);
				try {
				restTemplate.postForObject(serviceUrl, news, String.class);
				}
				catch(Exception e) {
					//eat exception
					System.out.println(e.getMessage());
				}
				//return;
				Thread.sleep(10);
			}
			count++;
			if(count>end)
				count = start;
		}
	}


}
