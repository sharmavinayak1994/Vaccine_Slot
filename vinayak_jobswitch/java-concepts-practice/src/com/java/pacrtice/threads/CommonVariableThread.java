package com.java.pacrtice.threads;

public class CommonVariableThread {
	
	public static void main(String[] args) {
		Book b = new Book();
		Thread t1 = new Thread(()->{
			while(b.getCommon().count >= 4) {
				b.reducer();
			}
		}, "Thread1");
		
		Thread t2 = new Thread(()->{
			while(b.getCommon().count >= 0) {
				b.reducer();
			}
		}, "Thread2");
		
		t1.start();
		t2.start();
		
	}

}

class Ticket{
	int count = 10;
	
	void reduceCount() {
		this.count--;
		System.out.println(Thread.currentThread().getName()+ " " + this.count);
	}
}

class Book{
	
	Ticket c = new Ticket();
	
	public void reducer() {
		synchronized (this.c) {
			c.reduceCount();
		}
	}
	
	Ticket getCommon() {
		return this.c;
	}
	                   
	
}