package com.news.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.news.models.IUserNewsRepository;
import com.news.models.IUserRepository;
import com.news.models.User;
import com.news.models.UserNews;
import com.news.models.UserNewsId;

@RestController
public class UsersController {
	@Autowired
	UsersService usersService;
	
	@Autowired
	IUserRepository userRepository;
	
	@Autowired
	IUserNewsRepository userNewsRepository;


    @RequestMapping(path = "/users/{id}", method = RequestMethod.POST)
    String changeLoginState(@RequestBody boolean data, @PathVariable Integer id) {
    	User user = userRepository.findOne(id);
    	if(data){
    		usersService.login(user);
    	}
    	else {
    		usersService.logOut(user);
    	}
    	
    	return "";
    }
    
    @RequestMapping(path = "/users/{userId}/news/{newsId}", method = RequestMethod.POST)
    String changeUserNews(@RequestBody int data, @PathVariable Integer userId, @PathVariable Integer newsId) {
    	UserNews userNews = userNewsRepository.findOne(new UserNewsId(userId, newsId));
    	if(userNews == null) {
    		//Phantom problem
    		return "";   // it is ok the system will resends this message, the impact is the user will receive double messages.
    	}
    	
    	usersService.notificationRecieved(userNews);
    	return "";
    }
}
