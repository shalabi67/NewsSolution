package com.news.notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.news.NewsApplication;
import com.news.framework.ThreadPool;

@Service
public class NotificationService {
	@Autowired
	private NewsApplication newsApplication;
    @Async
    public void notifyUser(UserNewsNotification data) {
        ThreadPool.executeTask(new NotificationTask(data, newsApplication.getUsersServiceUrl()));        
    }

}
