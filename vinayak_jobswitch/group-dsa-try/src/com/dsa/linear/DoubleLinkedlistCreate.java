package com.dsa.linear;

public class DoubleLinkedlistCreate {

	public DoubleLinkedList initialize(int data) {

		DoubleLinkedList dList = new DoubleLinkedList(new DNode(data));
		return dList;

	}

	public void addNode(DoubleLinkedList dList, int data) {
		if (dList != null && dList.node != null) {

			DNode tail = dList.node;
			while (tail.next != null) {
				tail = tail.next;
			}
			DNode newNode = new DNode(data);
			newNode.next = tail.next;
			newNode.prev = tail;
			tail.next = newNode;

		} else {
			dList.node = new DNode(data);
		}
	}

	public void addNodeFirst(DoubleLinkedList dList, int data) {
		if (dList != null) {
			DNode newHead = new DNode(data);
			newHead.prev = null;
			dList.node.prev = newHead;
			newHead.next = dList.node;
			dList.node = newHead;

		} else {
			dList = new DoubleLinkedList(new DNode(data));
		}
	}

	public void addAfter(DoubleLinkedList dList, int newData, int checkData) {
		System.out.println("adding after : " + checkData);
		DNode newNode = new DNode(newData);
		DNode traverse = dList.node;
		while (traverse != null && traverse.data != checkData) {
			traverse = traverse.next;
		}
		if (traverse != null) {
			newNode.prev = traverse;
			newNode.next = traverse.next;
			if (traverse.next != null) {
				traverse.next.prev = newNode;
			}
			traverse.next = newNode;
		} else {
			System.out.println("no such data exist");
		}
	}

	public void deleteAfter(DoubleLinkedList dList, int data) {
		if (dList != null && dList.node != null) {
			DNode traverse = dList.node;
			while (traverse != null && traverse.data != data) {
				traverse = traverse.next;
			}
			if (traverse.next != null) {
				if (traverse.next.next == null) {
					traverse.next = null;
				} else {
					traverse.next.next.prev = traverse.next.prev;
					traverse.next = traverse.next.next;

				}
			} else {
//				traverse =null;
				traverse = traverse.prev;
				traverse.next = null;
			}
		}
	}

	public void swapper(DoubleLinkedList dList, int n) {
		int count = 1;
		int size = length(dList);
		DNode traverse = dList.node;
		DNode tail = dList.node;
		while(count < n) {
			traverse = traverse.next;
			count=count+1;
		}
		count = 0;
		while(count < size-n) {
			count++;
			tail= tail.next;
		}
	
		
	}

	private int length(DoubleLinkedList dList) {
		int size = 0;
		DNode traverse = dList.node;
		while (traverse != null) {
			traverse = traverse.next;
			size += 1;
		}
		return size;
	}

	public void traverseHeadFirst(DoubleLinkedList dList) {
		System.out.println("here is your Dlist");
		if (dList != null) {
			DNode tail = dList.node;
			while (tail != null) {
				System.out.println("element : " + tail.data);
				tail = tail.next;

			}
		}
	}

	public void traverseTailFirst(DoubleLinkedList dList) {

		if (dList != null) {
			System.out.println("Printing data backwards");
			DNode tail = dList.node;
			while (tail.next != null) {
				tail = tail.next;
			}
			while (tail != null) {
				System.out.println(tail.data);
				tail = tail.prev;
			}
		}
	}

	public static void main(String[] args) {
		DoubleLinkedlistCreate creator = new DoubleLinkedlistCreate();
		DoubleLinkedList dList = creator.initialize(1);
		creator.addNode(dList, 2);
		creator.addNode(dList, 3);
		creator.addNode(dList, 4);
		creator.addNode(dList, 5);
		creator.addNode(dList, 6);
		creator.addAfter(dList, 100, 4);
		creator.addNodeFirst(dList, 0);
		creator.deleteAfter(dList, 6);
		creator.traverseHeadFirst(dList);
		//creator.traverseTailFirst(dList);
		creator.swapper(dList, 2);
		creator.traverseHeadFirst(dList);
		
	}
}
