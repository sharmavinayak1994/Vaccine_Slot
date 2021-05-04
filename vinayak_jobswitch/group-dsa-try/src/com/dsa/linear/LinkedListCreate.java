package com.dsa.linear;

import java.util.HashSet;

public class LinkedListCreate {

	LinkedList list = new LinkedList();

	public LinkedList initialize() {
		list.head = new Node(1);
		return list;
	}

	public int length(Node node) {

		if (node == null) {

			return 0;
		}
		return 1 + length(node.next);
	}

	public boolean contains(Node node, int lookup) {
		if (node == null) {
			return false;
		}
		if (node.data == lookup) {
			return true;
		}

		return contains(node.next, lookup);
	}

	public void getNthFromLast(LinkedList list, int nLast) {
		/** 
		 * there is also another method to do get nth Value that is to
		 * calculate the length of the list and perform length minus n to get the nth
		 * value from last**/
		
		Node refPointer = list.head;
		Node valuePointer = list.head;
		int count = 0;
		while(count < nLast) {
			if(refPointer!=null) {
			refPointer = refPointer.next;
			}else {
				System.out.println("Number of nodes are less than mentioned nth value");
			}
			count++;
		}
		
		while(refPointer!=null) {
			valuePointer = valuePointer.next;
			refPointer=refPointer.next;
		}
		System.out.println(nLast +"nd value form last is :" + valuePointer.data );
	}

	public void addNode(LinkedList list, Node node) {

		if (list.head == null) {
			list.head = node;
		} else {

			if (list.head.next == null) {
				list.head.next = node;
			} else {
				Node n = list.head;
				while (n.next != null) {
					n = n.next;
				}
				n.next = node;
			}
		}
	}

	public void addNodeFirst(LinkedList list, Node node) {
		if (list.head == null) {
			list.head = node;
		} else {
			Node temp = list.head;
			list.head = node;
			list.head.next = temp;
		}
	}

	public void findMiddleNode(LinkedList list) {

		if (list != null && list.head != null) {
			Node slowpointer = list.head;
			Node fastpointer = list.head;
			while (fastpointer != null && fastpointer.next != null) {
				slowpointer = slowpointer.next;
				fastpointer = fastpointer.next.next;
			}
			System.out.println("middle :" + slowpointer.data);
		}
	}

	public void insertMiddle(LinkedList list, Node node) {
		if (list != null && list.head != null) {
			Node slowpointer = list.head;
			Node fastpointer = list.head;
			while (fastpointer != null && fastpointer.next != null) {
				slowpointer = slowpointer.next;
				fastpointer = fastpointer.next.next.next;
			}
			Node temp = slowpointer.next;
			slowpointer.next = node;
			node.next = temp;
		}
	}

	public void insertAfter(Node prev_node, int newData) {

		if (prev_node != null) {
			Node node = new Node(newData);
			node.next = prev_node.next;
			prev_node.next = node;
		}

	}

	public void deleteLast(LinkedList list) {

		Node traverse = list.head;
		Node delete = list.head.next;
		while (delete.next != null) {
			delete = delete.next;
			traverse = traverse.next;
		}
		traverse.next = null;

	}

	public void deleteFirst(LinkedList list) {

		Node delete = list.head;
		list.head = list.head.next;
		delete = null;
		System.out.println();

	}

	public void deleteMiddle(LinkedList list, int data) {
		if (list != null && list.head != null) {
			Node traverse = list.head;
			Node delete = list.head.next;
			while (delete != null && delete.next != null) {
				if (delete.data == data) {
					traverse.next = delete.next;
					delete = null;
				} else {
					traverse = traverse.next;
					delete = delete.next;
				}
			}
		}
	}

	public void createLoop(LinkedList list) {
		if(list!=null) {
			Node node = list.head;
			while(node.next!=null) {
				node = node.next;
			}
			node.next = list.head;
		}
	}
	
	public void detectLoop(LinkedList list) {
		/** 
		 * there is a method to detect loop using two pointer too. think fo that also
		 * **/
		if(list!=null && list.head!=null) {
			HashSet<Node> loopDetecter = new HashSet<Node>();
			Node check = list.head;
			while(check.next!=null) {
				if(loopDetecter.contains(check)) {
					System.out.println("there is loop at node" + check.data);
					return;
				}else {
					loopDetecter.add(check);
				}
				check =check.next;
				if(check.next == null) {
					System.out.println("There is no loop enjoy");
				}
			}
				
		} 
	}
	public void traverse(LinkedList list) {

		Node print = list.head;
		while (print != null) {
			System.out.println(print.data);
			print = print.next;
		}

	}

	public static void main(String[] args) {
		LinkedListCreate listCreate = new LinkedListCreate();
		LinkedList list = listCreate.initialize();
		Node two = new Node(2);
		Node three = new Node(3);
		Node four = new Node(4);
		Node five = new Node(5);
		Node six = new Node(6);
		Node seven = new Node(7);
		listCreate.addNode(list, two);
		listCreate.addNode(list, three);
		listCreate.addNode(list, four);
		listCreate.addNode(list, five);
		listCreate.addNode(list, six);
		listCreate.addNode(list, seven);
		Node newHead = new Node(0);
		Node newHead2 = new Node(100);
		listCreate.addNodeFirst(list, newHead);
		listCreate.addNodeFirst(list, newHead2);
		System.out.println(" ");
//		listCreate.findMiddleNode(list);
//		System.out.println(" ");
//		Node middle = new Node(111);
//		listCreate.insertMiddle(list, middle);
//		System.out.println(" ----------- ");
//		System.out.println("----- adding after 2 -----");
//		listCreate.insertAfter(list.head.next.next, 88);
//		System.out.println("VALUE 6 IS PRESENT : " + listCreate.contains(list.head, 6));
//		System.out.println("------ deleting last node ------");
//		System.out.println("getting length" + listCreate.length(list.head));
//		listCreate.deleteLast(list);
//		listCreate.traverse(list);
//		System.out.println("------ deleting head ------");
//		listCreate.deleteFirst(list);
//		listCreate.traverse(list);
//		System.out.println("------ deleting middle ------");
//		listCreate.deleteMiddle(list, 3);
//		System.out.println("getting length" + listCreate.length(list.head));
//		listCreate.traverse(list); System.out.println(" ");
//		listCreate.getNthFromLast(list, 10);
		listCreate.createLoop(list);
		listCreate.detectLoop(list);

	}

}
