package com.news.notification;

import com.news.notification.devices.Device;

public class NotificationTask implements Runnable {
	private UserNewsNotification data;
	private String url;
	public NotificationTask(UserNewsNotification data, String url) {
		this.data = data;	
		this.url = url;
	}
	
	public void run() {	
		Device device = Device.create(data.getDevice(), url);
		device.notifyDevice(data);
	}

}
