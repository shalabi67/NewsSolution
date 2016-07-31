package com.news.notification.devices;

import com.news.notification.UserNewsNotification;

import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TestingDevice extends Device {
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_RESET = "\u001B[0m";
	@Override
	public synchronized void notifyDevice(UserNewsNotification data){
		System.out.println(ANSI_GREEN + "----------------------------Notification---------------------------------!" + ANSI_RESET);
		System.out.println(ANSI_GREEN + String.format("User Id: %s", data.getUserId()) + ANSI_RESET);
		System.out.println(ANSI_GREEN + String.format("News Id: %s", data.getNewsId()) + ANSI_RESET);
		System.out.println(ANSI_GREEN + String.format("Data: %s", data.getNewsData()) + ANSI_RESET);
		System.out.println(ANSI_GREEN + "----------------------------End Of Notification---------------------------------!" + ANSI_RESET);
		
		RestTemplate restTemplate = new RestTemplate();
		String url = this.getUsersUrl(data);
		restTemplate.postForObject(url, 4, String.class);
		
	}
	
}
