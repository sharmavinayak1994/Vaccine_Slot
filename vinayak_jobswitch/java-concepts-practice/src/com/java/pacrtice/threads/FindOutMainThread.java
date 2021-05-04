package com.java.pacrtice.threads;

public class FindOutMainThread extends Thread {

	public void run() {
		System.out.println("Activity");
		for(int i=0; i<5; i++) {
			System.out.println(i + " " + Thread.currentThread().getName());
		}
	}
	
	public static void main(String[] args) {
		FindOutMainThread t = new FindOutMainThread();
		t.run();
	}
	
}
