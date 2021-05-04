package com.java.pacrtice.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo {
	public static void main(String[] args) {
		int coreCount = Runtime.getRuntime().availableProcessors();
		ExecutorService service = Executors.newFixedThreadPool(coreCount);
		System.out.println("available cores -----> " + coreCount);
		for (int i = 0; i <= 5; i++) {
			service.execute(new Task());
		}
		
	}
}

class Task implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i <= 10; i++) {
			System.out.println("running task " + i + " " + Thread.currentThread().getName());
		}
	}

}