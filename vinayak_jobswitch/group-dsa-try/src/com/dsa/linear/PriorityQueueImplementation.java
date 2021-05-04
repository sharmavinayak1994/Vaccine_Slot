package com.dsa.linear;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueImplementation {

	public Queue<Integer> createQueueWithList(ArrayList<Integer> list) {
		Queue<Integer> priority = new PriorityQueue<Integer>();
		Iterator<Integer> itetarte = list.iterator();
		while (itetarte.hasNext()) {
			priority.add(itetarte.next());
		}
		return priority;
	}

	public PriorityQueue<Integer> createQueueWithArray(int arr[]) {

		PriorityQueue<Integer> pqueue = new PriorityQueue<>();
		for (int x : arr) {
			pqueue.add(x);
		}
		return pqueue;
	}

	public int findMaxSum(PriorityQueue<Integer> pqueue, int k) {
		while (k-- > 0) {
			System.out.println(pqueue.peek());
			int temp = pqueue.poll();
			if (temp < 0)
				temp = temp * -1;

			pqueue.add(temp);
			System.out.println(pqueue.peek());
		}
		int sum = 0;
		for (int x : pqueue) {
			sum = sum + x;
		}
		return sum;
	}

	public void traverseQueue(Queue priority) {

		while (!priority.isEmpty()) {
			System.out.println(priority.poll());
		}

	}

	public static void main(String[] args) {
		PriorityQueueImplementation queue = new PriorityQueueImplementation();
		ArrayList<Integer> list = new ArrayList<>();
		list.add(-10);
		list.add(15);
		list.add(-25);
		list.add(4);
		list.add(3);
		list.add(1);
		Queue<Integer> priority = queue.createQueueWithList(list);
//		queue.traverseQueue(priority);
//		int arr[] = {-2,0,5,-1,2};
//		PriorityQueue<Integer> pqueue = queue.createQueueWithArray(arr);
//		queue.traverseQueue(pqueue);
		System.out.println(queue.findMaxSum((PriorityQueue<Integer>) priority, 1));
	}

}
