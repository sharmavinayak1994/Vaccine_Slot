package com.dsa.nonlinear;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeTraversal {
	
	public void inorderTrverse(Node root) {
		
		if(root==null)
			return;
		
		inorderTrverse(root.left);
		System.out.println(root.data);
		inorderTrverse(root.right);
		
	}
	
	public void inorderWithLoop(Node root) {
		Node node = root;
		if(root == null) {
			System.out.print("There is no tree to traverse, SAD!");
		}
		
		Stack<Node> stack = new Stack<Node>();
		
		if(node.left==null && node.right==null) {
			System.out.print(node.data + " ");
		}
		
		while(node !=null || stack.size()>0) {
			
			while(node!=null) {
				stack.push(node);
				node = node.left;
			}
			node =stack.pop();
			System.out.println(node.data);
			node = node.right;
		}
	}

	public void preorderTraversal(Node root) {
		if(root==null) {
			return;
		}
		System.out.print(root.data + " ");
		preorderTraversal(root.left);
		preorderTraversal(root.right);
	}
	
	
	public void preorderWithLoop(Node root) {
		
		Stack<Node> stack = new Stack<Node>();
		Node node = root;
		
		while(node!=null || stack.size()>0) {
			while(node!=null) {
				System.out.print(node.data+ " ");
				if(node.right!=null) {
					stack.push(node.right);
				}
				node = node.left;
			}
			if(!stack.isEmpty()) {
				node=stack.pop();
			}
		}
		
	}
	
	public void postorderTraverse(Node root) {
		
		if(root==null)
			return;
		postorderTraverse(root.left);
		postorderTraverse(root.right);
		System.out.print(root.data + " ");
	}
	/*this code is from geeksforgeeks*/
	public void postorderWithLoop(Node root) {
		if(root==null)
			return;
		
		Node node= root;
		Stack<Node> stack = new Stack<Node>();
		
		while(true) {
			while(node!=null) {
				stack.push(node);
				stack.push(node);
				node = node.left;
			}
			if(stack.isEmpty())
				return;
			
			node = stack.pop();
			if(!stack.isEmpty() && stack.peek() == node ) {
				node = node.right;
			}else {
				System.out.print(node.data + " ");
				node = null;
			}
		}
		
	}
	
	//This is code is based on my understanding.
	public void postOrderMyWay(Node root) {
		if(root ==null)
			return;
		
		Node current = root;
		Stack<Node> stack = new Stack<Node>();
		
		while(current!=null || stack.size()>0) {
			
			if(current!=null) {
				stack.push(current);
				current = current.left;
			}else {
				Node temp = stack.peek().right;
				if(temp == null) {
					temp = stack.pop();
					System.out.print(temp.data+" ");
					while(stack.size()>0 && temp==stack.peek().right) {
						temp = stack.pop();
						System.out.print(temp.data+" ");
					}
				}else {
					current = temp;
				}
			}
		}
		
	}
	
	public void levelOrderTraversal(Node root) {
		if(root == null)
			return;
		
		Node current = root;
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(current);
		
		while(!queue.isEmpty()) {
			current = queue.poll();
			System.out.print(current.data +" ");
			if(current.left!=null)
				queue.add(current.left);
			if(current.right!=null)
				queue.add(current.right);
		}
	}
	
	public static void main(String[] args) {
		Node root = new Node(0);
		root.left=new Node(5);
		root.right =new Node(10);
		root.left.left = new Node(6);
		root.left.right = new Node(12);
		root.right.left = new Node(3);
		root.right.right = new Node(9);
		
		TreeTraversal tree = new TreeTraversal();
		//tree.inorderWithLoop(root);
		//tree.preorderTraversal(root);
		//tree.preorderWithLoop(root);
		//tree.postorderTraverse(root);
		//System.out.println();
		//tree.postorderWithLoop(root);
		//System.out.println();
		tree.postOrderMyWay(root);
		System.out.println();
		tree.levelOrderTraversal(root);
	}
}
