package com.news.RecievingService;

import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import com.news.NewsApplication;
import com.news.framework.News;
import com.news.framework.ThreadPool;
import com.news.models.ICategoryRepository;
import com.news.models.IUserRepository;
import com.news.models.User;

@Service
public class UserNewsService {	
	@Autowired
	private IUserRepository userRepository;
	
	@Autowired
	private ICategoryRepository categoryRepository;
	
	@Autowired
	NewsApplication application;
	
    
    @Async
    public Future<Integer> processNews(News news) {
    	//initUsers();
        ThreadPool.executeTask(new NewsProcessorTask(application.getNotificationServiceUrl(),userRepository, categoryRepository, news));  
    	
        //NewsProcessorTask task = new NewsProcessorTask(application.getNotificationServiceUrl(),userRepository, categoryRepository, news);
    	//task.run();
        
        return new AsyncResult<Integer>(0);
    }
    /*
	private void initUsers() {
		if(NewsProcessorTask.users == null) {
    		int i = 0;
    		Iterable<User> iter = userRepository.findAll();
    		NewsProcessorTask.users = new User[NewsProcessorTask.maxUsers];
    		for(User user : iter) {
    			if(i > NewsProcessorTask.maxUsers -1)
    				break;
    			NewsProcessorTask.users[i++] = user;
    		}
		}
	}
	*/

}
