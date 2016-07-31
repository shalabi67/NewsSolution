package com.news.notification.devices;

import com.news.notification.UserNewsNotification;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class Device {
	protected String usersUrl;
	public static Device create(DeviceType type, String usersUrl) {
		TestingDevice testingDevice =  new TestingDevice();
		testingDevice.usersUrl = usersUrl;
		return testingDevice;
	}
	public String getUsersUrl(UserNewsNotification data) {
		return String.format("%s/%s/news/%s", usersUrl, data.getUserId(), data.getNewsId());
	}
	
	public abstract void notifyDevice(UserNewsNotification data);
}
