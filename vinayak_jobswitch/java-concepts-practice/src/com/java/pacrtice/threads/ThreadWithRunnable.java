package com.java.pacrtice.threads;

public class ThreadWithRunnable implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Yaha dhoom machayenge");
		for(int i = 0; i< 5; i++) {
			System.out.println(Thread.currentThread().getName() + " "+ i);
		}
	}
	
	public static void main(String[] args) {
		for(int i=0;i<2;i++) {
			System.out.println("creating threads");
			Thread t = new Thread(new ThreadWithRunnable());
			t.start();
			try {
				System.out.println(t.getState());
				t.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
