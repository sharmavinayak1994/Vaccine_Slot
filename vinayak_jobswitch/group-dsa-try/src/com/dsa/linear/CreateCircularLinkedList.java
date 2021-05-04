package com.dsa.linear;

public class CreateCircularLinkedList {

	public CircularLinkedList initialize(int data) {
		Node node = new Node(data);
		CircularLinkedList cList = new CircularLinkedList(node);
		cList.node.next = cList.node;
		return cList;
	}

	public int length(CircularLinkedList cList) {
		Node headRef = cList.node;
		Node traverse = cList.node.next;
		int count = 0;
		while (traverse != headRef) {
			traverse = traverse.next;
			count += 1;
		}
		return count;
	}

	public void addNode(CircularLinkedList list, Node addNew) {
		if (list != null) {
			if (list.node == null) {
				list.node = addNew;
			} else {
				Node headRef = list.node;
				Node traverse = list.node.next;
				while (traverse != null && traverse.next != headRef) {
					traverse = traverse.next;
				}
				if (traverse == null) {
					traverse = addNew;
					traverse.next = headRef;
				} else {
					addNew.next = headRef;
					traverse.next = addNew;
				}
			}
		}
	}

	public void addNodeAtFirst(CircularLinkedList cList, Node addNew) {

		Node headRefinit = cList.node;
		Node traverse = cList.node.next;
		while (traverse.next != headRefinit) {
			traverse = traverse.next;
		}

		if (cList != null) {
			addNew.next = headRefinit;
			cList.node = addNew;
			traverse.next = cList.node;
			System.out.println();
		}

	}

	public void splitListinHalf(CircularLinkedList cList) {

		/**
		 * also we can use logic of finding middle with two pointer and do everything in
		 * one loop
		 **/

		if (cList != null && cList.node != null) {
			int length = length(cList);
			int count = 1;
			Node headRef = cList.node;
			Node traverse = cList.node;
			while (count <= length / 2) {
				traverse = traverse.next;
				count += 1;
			}

			Node secondHead = traverse.next;
			Node secondTraverse = secondHead.next;
			while (count <= length && secondTraverse.next != headRef) {
				secondTraverse = secondTraverse.next;
				count += 1;
			}

			traverse.next = headRef;
			cList.node = headRef;
			secondTraverse.next = secondHead;
			CircularLinkedList cListNew = new CircularLinkedList(secondHead);
			traverse(cList);
			System.out.println("seconf half");
			traverse(cListNew);

		}
	}

	public void traverse(CircularLinkedList cList) {
		if (cList.node != null && cList.node.next != null) {
			Node headRef = cList.node;
			Node traverse = cList.node.next;
			System.out.println(headRef.data);
			while (traverse != headRef) {
				System.out.println(traverse.data);
				traverse = traverse.next;
			}
		} else {
			if (cList.node != null) {
				System.err.println(cList.node.data);
			} else {
				System.out.println("List is empty");
			}
		}

	}

	public static void main(String[] args) {
		CreateCircularLinkedList cListCreate = new CreateCircularLinkedList();
		CircularLinkedList cList = cListCreate.initialize(0);
		cListCreate.addNode(cList, new Node(1));
		cListCreate.addNode(cList, new Node(2));
		cListCreate.addNode(cList, new Node(3));
		cListCreate.addNode(cList, new Node(4));
		cListCreate.addNode(cList, new Node(5));
		cListCreate.addNodeAtFirst(cList, new Node(99));
		cListCreate.traverse(cList);
		System.out.println("**********splitting***********");
		cListCreate.splitListinHalf(cList);
	}
}
