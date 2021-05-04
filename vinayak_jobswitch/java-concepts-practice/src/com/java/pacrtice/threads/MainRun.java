package com.java.pacrtice.threads;

/** 
 * This class is written by vinayak sharma,
 * to demonstrate Daemon thread**/
class DaemonThread implements Runnable {

	@Override
	public void run() {
		System.out.println("Daemon is running");
		if (Thread.currentThread().isDaemon()) {
			System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getPriority());
			for (int i = 0; i <= 20; i++) {
				System.out.println(i + " " + Thread.currentThread().getName() + " " + "Running");
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				//we noticed that entire for loop is not executed as user thread below completes it cycle first.
			}
		}
	}

}

class UserThread implements Runnable {
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getPriority() + " " + Thread.currentThread().getName());
		for (int i = 0; i <= 10; i++) {
			System.out.println(i + " " + Thread.currentThread().getName() + " " + "Running");
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

public class MainRun {
	public static void main(String[] args) {
		Thread daemon = new Thread(new DaemonThread());
		daemon.setName("Vinayak daemon");
		daemon.setDaemon(true);

		Thread user = new Thread(new UserThread());
		user.setName("Vinayak User");

		daemon.start();
		user.start();
		
		System.out.println(user.getState());
	}
}
