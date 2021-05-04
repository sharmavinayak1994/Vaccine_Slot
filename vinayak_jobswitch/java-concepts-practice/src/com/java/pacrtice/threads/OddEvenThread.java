package com.java.pacrtice.threads;

public class OddEvenThread {
	public static void main(String[] args) {
		Common res = new Common();
		
		//creating first thread
		Thread t1 =new Thread(()->{
			for(int i=0;i<5;i++) 
				res.printOddNumber();
		});
		t1.setName("OddThread");		
		t1.start();
		
//		//creating second thread
		Thread t2 =new Thread(()->{
			for(int j=0;j<5;j++)
				res.printEvenNumber();
		});
		t2.setName("EvenThread");
		t2.start();
	}
}

class Common{
	
	int count =0;
	
	public void printOddNumber() {
		synchronized (this) {
			try {
				while(this.count%2==0) {
					//System.out.println(Thread.currentThread().getName() +" is waiting");
					wait();
				}
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
			System.out.println(Thread.currentThread().getName()+ " " + count);
			count++;
			notify();
		}
	}
	
	public void printEvenNumber() {
		synchronized (this) {
			try {
				while(count%2!=0) {
					//System.out.println(Thread.currentThread().getName() +" is waiting");
					wait();
				}
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
			System.out.println(Thread.currentThread().getName()+ " " + count);
			count++;
			notify();
			//System.out.println("Threads are notified");
		}
	}	
}