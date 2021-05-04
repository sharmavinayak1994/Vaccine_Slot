package com.java.practice;

public class WallMart {
	// 1 2 3 4 5 6 7 8 9;
	public static void main(String[] args) {

		PrintNumber pn = new PrintNumber(100);
		Thread t1 = new Thread(() -> {
			try {
				pn.printNum1();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		},"T1");

		Thread t2 = new Thread(() -> {
			try {
				pn.printNum2();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		},"T2");

		Thread t3 = new Thread(() -> {
			try {
				pn.printNum3();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		},"T3");
		
		t1.start();
		t2.start();
		t3.start();
	}
}

class PrintNumber {

	int counter;
	int localCount = 2;
	int print = 0;

	public void printNum1() throws InterruptedException {
		synchronized (this) {
			while (this.counter > 0) {
				while (localCount != 2)
					wait();

				System.out.println(print + " " + Thread.currentThread().getName());
				localCount--;
				counter--;
				print++;
				notifyAll();
			}
		}

	}

	public void printNum2() throws InterruptedException {
		synchronized (this) {
			while (this.counter > 0) {
				while (localCount != 1)
					wait();

				System.out.println(print + " " + Thread.currentThread().getName());
				localCount--;
				counter--;
				print++;
				notifyAll();
			}
		}

	}

	public void printNum3() throws InterruptedException {
		synchronized (this) {
			while (this.counter > 0) {
				while (localCount != 0)
					wait();

				System.out.println(print + " " + Thread.currentThread().getName());
				localCount--;
				counter--;
				print++;
				notifyAll();
				this.localCount =2;
			}
		}

	}

	PrintNumber(int counter) {
		this.counter = counter;
	}

}
