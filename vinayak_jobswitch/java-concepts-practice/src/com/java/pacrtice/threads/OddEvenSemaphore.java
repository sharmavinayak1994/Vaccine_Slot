package com.java.pacrtice.threads;

import java.util.concurrent.Semaphore;

public class OddEvenSemaphore {
	public static void main(String[] args) {

		SharedPrinter sp = new SharedPrinter();
		Thread odd = new Thread(() -> {
			for (int i = 1; i < 10; i = i + 2)
				sp.printOdd(i);
		}, "oddThread");

		Thread even = new Thread(() -> {
			for (int i = 0; i < 10; i = i + 2)
				sp.printEven(i);
		}, "evenThread");
		
		odd.start();
		even.start();
	}
}

class SharedPrinter {

	Semaphore semEven = new Semaphore(0);
	Semaphore semOdd = new Semaphore(1);

	public void printEven(int num) {
		try {
			semEven.acquire();
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(Thread.currentThread().getName() + " " + num);
		semOdd.release();
	}

	public void printOdd(int num) {
		try {
			semOdd.acquire();
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(Thread.currentThread().getName() + " " + num);
		semEven.release();
	}

}