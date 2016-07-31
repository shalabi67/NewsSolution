package com.news.UserManagement;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class UserManagementApplication implements CommandLineRunner {
	@Value("${userManagementServiceUrl}")
	private String serviceUrl;
    
	public static void main(String[] args) {
		SpringApplication.run(UserManagementApplication.class, args);
		
	}


	@Override
	public void run(String... arg0) throws Exception {
		long[] userIds = {1,2,3};
		RestTemplate restTemplate = new RestTemplate();
		while(true) {			
			for(long id : userIds) {
				String url = serviceUrl + id;
				try {					
					restTemplate.postForObject(url, true, String.class);
					Thread.sleep(4000);
					restTemplate.postForObject(url, false, String.class);
				}
				catch(Exception e) {
					//eat exception
					System.out.println(e.getMessage());
				}

			}

		}
	}


}