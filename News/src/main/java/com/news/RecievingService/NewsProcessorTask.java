package com.news.RecievingService;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.news.NewsApplication;
import com.news.models.ICategoryRepository;
import com.news.models.IUserNewsRepository;
import com.news.models.IUserRepository;
import com.news.models.News;
import com.news.models.User;
import com.news.models.UserNews;
import com.news.notification.UserNewsNotification;
import com.news.notification.devices.DeviceType;

@Component
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class NewsProcessorTask implements Runnable {
	public static final int maxUsers = 4;
	//public static User[] users = null;
	@Autowired
	private IUserRepository userRepository;
	
	@Autowired
	private INewsRepository newsRepository;
	
	@Autowired
	IUserNewsRepository userNewsRepository;
	
	
	@Autowired
	NewsApplication application;
	
	public String serviceUrl;
	public com.news.framework.News news;
	
	public NewsProcessorTask(String serviceUrl, IUserRepository userRepository, ICategoryRepository categoryRepository, com.news.framework.News news) {
		this.news = news;
		this.userRepository = userRepository;
		this.serviceUrl = serviceUrl;
		
		
	}
	public NewsProcessorTask( com.news.framework.News news) {
		this.news = news;
	}
	
	public void run() {
		this.serviceUrl = application.getNotificationServiceUrl();
		News news = News.create(this.news);
		Set<User> users = userRepository.getActiveUsers(news.getCategory());
		
		createUserNews(news, users);
		notifyUsers(users, news);

	}
	
	
	//@Transactional(isolation=Isolation.READ_UNCOMMITTED)
	@Transactional()
	public void createUserNews(News news, Set<User> users) {
		newsRepository.save(news);
		for(User user : users) {
			UserNews userNews = new UserNews(user.getId(), news.getId());
			userNewsRepository.save(userNews);
		}
	}
	
	private void notifyUsers(Set<User> users, News news) {
		for(User user : users) {
			if(user.isLoggedin()) {
				notifyUser(user, news);
			}
		}
		
	}
	
	private void notifyUser(User user, News news) {
		RestTemplate restTemplate = new RestTemplate();
		UserNewsNotification data = new UserNewsNotification(DeviceType.Testing, user, news);
		
		restTemplate.postForObject(serviceUrl, data, String.class);
	}

}
