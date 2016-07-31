package com.news.notification;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RestController
public class NotificationController {
	@Autowired
	NotificationService notificationService;


    @RequestMapping(value ="/notifications", method = RequestMethod.POST)
    public String notify(@RequestBody UserNewsNotification data) {
    	notificationService.notifyUser(data);
    	
    	return "Success";
    }
    
    //TODO: convert to support concurrency
    private final List<SseEmitter> emitters = new ArrayList<>();
    @ResponseBody
    @RequestMapping(path = "/notifications/message", method = RequestMethod.POST)
    public UserNewsNotification sendMessage(@Valid UserNewsNotification message) {
    	try
    	{
    		for(SseEmitter emitter : emitters) {
	        //emitters.forEach((SseEmitter emitter) -> {
	            try {
	                emitter.send(message, MediaType.APPLICATION_JSON);
	            	//emitter.send(SseEmitter.event().name("dapEvent").data(message));
	                //emitter.complete();
	            } catch (Exception e) {
	                emitter.complete();
	                emitters.remove(emitter);
	                e.printStackTrace();
	            }
	        //});
    		}
    	}
    	catch(Exception e) {
    		 e.printStackTrace();
    	}
        return message;
    }
    @RequestMapping(path = "/notifications/stream", method = RequestMethod.GET)
    public SseEmitter stream() throws IOException {

        SseEmitter emitter = new SseEmitter();

        emitters.add(emitter);
        emitter.onCompletion(() -> emitters.remove(emitter));

        return emitter;
    }
    
    @RequestMapping(value ="/notifications", method = RequestMethod.GET)
    public String getNotifications() {
    	return "Success";
    }
}
