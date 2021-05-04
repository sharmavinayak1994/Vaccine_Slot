package com.java.pacrtice.threads;

public class SyncThread implements Runnable{

	String name;
	
	public SyncThread(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}
	
	@Override
	public void run() {
		Thread.currentThread().setName(name);
		int i=0;
		Resource resource = Resource.getInstance();
		while(i<5) {
			try {
				//notify();
				resource.incrementI();
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
			
			i++;
		}
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new SyncThread("Vinayak"));
		Thread t2 = new Thread(new SyncThread("Meenal"));
		
		t1.start();
		t1.sleep(2000);
		//t1.join();
		t2.start();
	}

}

class Resource{
	
	private static Resource resource;
	
	public static Integer i = 0;
	
	public void incrementI() throws InterruptedException {
		
		synchronized (i) {
			i=i+1;
			System.out.println(Thread.currentThread().getName() + " " + i);
			wait();
			//notify();
		}
		
	}
	
	public void incrementIeven() throws InterruptedException {
		synchronized (i) {
			i=i+1;
			System.out.println(Thread.currentThread().getName() + " " + i);
			notify();
			//wait();
		}
		
	}
	
	private Resource() {
		
	}
	
	public static Resource getInstance() {
		if(resource!=null)
			return resource;
		else {
			resource = new Resource();
			return resource;
		}
	}
	
}
