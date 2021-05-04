package com.java.pacrtice.threads;

import java.util.concurrent.Future;

class CommonResource{
	public synchronized void acess(String name) {
		for(int i=0; i<=10; i++) {
			System.out.println("Common resource is being accessed by "+name);
		}
	}
}

class MyThread extends Thread {

	CommonResource resource;
	
	public void run() {
		resource.acess(Thread.currentThread().getName());
	}
	
	public MyThread(CommonResource resource) {
		// TODO Auto-generated constructor stub
		this.resource = resource;
	}
}

class YourThread implements Runnable{

	CommonResource resource;
	@Override
	public void run() {
		resource.acess(Thread.currentThread().getName());
	}
	
	YourThread(CommonResource resource){
		this.resource = resource;
	}
}

public class ThreadDemo {
	
	public static void main(String[] args) {
		
		Future<Integer> future;
		
		System.out.println("This is main thread " + Thread.currentThread().getName());
		CommonResource resource = new CommonResource();
		MyThread mt = new MyThread(resource);
		Thread yt = new Thread(new YourThread(resource));
		mt.setName("MyThread");
		yt.setName("yourthread");
		mt.start();
		yt.start();
//		System.out.println("This is main thread completed and waiting for " +  yt.getName());
//		System.out.println("This is main thread completed and waiting for " +  mt.getName());
	}

}
