package com.news.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.news.models.IUserNewsRepository;
import com.news.models.IUserRepository;
import com.news.models.User;
import com.news.models.UserNews;

@Service
public class UsersService {	
    @Autowired
    IUserRepository userRepository;
    
    @Autowired
    IUserNewsRepository userNewsRepository;
    
    public void login(User user) {
    	user.setStatus(2);
    	userRepository.save(user);
              
    }
    
    public void logOut(User user) {
    	user.setStatus(1);
    	userRepository.save(user);
    }
    
    public void notificationRecieved(UserNews userNews) {    		
    	userNews.setStatus(4);
    	userNewsRepository.save(userNews);
    }

}
