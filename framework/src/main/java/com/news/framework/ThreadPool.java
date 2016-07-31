package com.news.framework;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPool  {
	private static ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
	public static  void executeTask(Runnable task) {
		executor.execute(task);
	}
	
}
