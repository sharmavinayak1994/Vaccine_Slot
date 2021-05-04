package com.dsa.nonlinear;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TreeCreator {

	public static void main(String args[]) {
	
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(0);
		tree.root.left = new Node(1);
		tree.root.right = new Node(2);
		tree.root.right.right = new Node(3);
		tree.root.left.left = new Node(4);
		TreeCreator treeCreator = new TreeCreator();
		treeCreator.inOrderTraverse(tree.root);
		System.out.println("------post------");
		treeCreator.postOrderTraverse(tree.root);
		System.out.println("------pre------");
		treeCreator.preOrderTraverse(tree.root);
		treeCreator.iterateOverhash();		
	}
	
	public void inOrderTraverse(Node node) {
		
		if(node == null)
			return;
		
		inOrderTraverse(node.left);
		System.out.println(node.data+" ");	
		inOrderTraverse(node.right);
		
	}
	
	public void preOrderTraverse(Node node) {
		if(node == null)
			return;
		
		System.out.println(node.data);
		preOrderTraverse(node.left);
		preOrderTraverse(node.right);
	}
	
	public void postOrderTraverse(Node node) {
		if(node == null)
			return;
		
		postOrderTraverse(node.left);
		postOrderTraverse(node.right);
		System.out.println(node.data);
	}
	
	public void iterateOverhash() {
		HashMap<Integer, String> hm = new HashMap<>();
		hm.put(1, "Pehla");
		hm.put(2, "dusra");
		hm.put(3, "teesra");
		
		for (Map.Entry<Integer, String> mp : hm.entrySet()) {
			System.out.println(mp.getKey() + " " + mp.getValue());
		}
		
		Iterator hmIterate = hm.entrySet().iterator();
		
		while(hmIterate.hasNext()) {
			Map.Entry<Integer, String> mp = (Map.Entry<Integer, String>)hmIterate.next();
			System.out.println(mp.getKey() + " " + mp.getValue());
		}
		
	}
	
}
