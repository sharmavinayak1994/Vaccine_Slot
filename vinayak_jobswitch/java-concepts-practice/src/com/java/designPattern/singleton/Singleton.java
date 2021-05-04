package com.java.designPattern.singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Singleton {

	private Singleton() {}
	
	private static class SingletonHolder{
		
		public static final Singleton instance = new Singleton();		
	}
	
	public static Singleton getInstance() {
		return SingletonHolder.instance;
	}
	
	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(10);
		
	}
}

class test{
	
	Runnable r = new Runnable() {
		
		@Override
		public void run() {
			System.out.println("do something");
			
		}
	};
	
	public static void main(String[] args) {
		test test = new test();
		Thread t = new Thread(new Runnable() {
			public void run() {
				System.out.println("dooooo");
			}
		});
		t.start();
	}
	
}