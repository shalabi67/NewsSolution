package com.news;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableConfigurationProperties
@EnableTransactionManagement
public class NewsApplication {
	@Value("${notificationServiceUrl}")
	private String notificationServiceUrl;
	
	@Value("${userManagementServiceUrl}")
	private String usersServiceUrl;
	
	public String getUsersServiceUrl() {
		return usersServiceUrl;
	}
	
	public String getNotificationServiceUrl() {
		return notificationServiceUrl;
	}	

	public static void main(String[] args) {
		SpringApplication.run(NewsApplication.class, args);
	}
}
