package com.java.pacrtice.threads;

import java.util.*;

public class ProducerConsumerTest {

	public static void main(String[] args) {
		ProducerConsumer pc = new ProducerConsumer();
		Thread t1 = new Thread(() -> {
			try {
				pc.consumer();
			} catch (InterruptedException e) {

				System.out.println(e.getMessage() + " " + "consumer phata");
			}
		});

		Thread t2 = new Thread(() -> {
			try {
				pc.producer();
			} catch (InterruptedException e) {
				System.out.println(e.getMessage() + " " + "producer phata");
			}
		});

		t1.start();
		t2.start();
	}

}

class ProducerConsumer {

	List<Integer> list = new ArrayList<Integer>();
	int i = 0;

	public void producer() throws InterruptedException {

		synchronized (this) {
			while (true) {
				while (list.isEmpty()) {
					list.add(i);
					i++;
					notify();
				}
				System.out.println("list has values");
				wait();
			}
		}
	}

	public void consumer() throws InterruptedException {

		synchronized (this) {
			while (true) {
				while (list.isEmpty()) {
					wait();
				}
				System.out.println("consuming value " + list.remove(0));
				notify();
			}
		}
	}

}
