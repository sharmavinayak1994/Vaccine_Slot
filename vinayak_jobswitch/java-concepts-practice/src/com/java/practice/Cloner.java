package com.java.practice;

import java.lang.Cloneable;

/**
 * To understand cloning please refer this 
 * **/

public class Cloner implements Cloneable {

	int a,b;
	
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	public static void main(String[] args) throws CloneNotSupportedException {
		Cloner cloner = new Cloner();
		cloner.a =10;
		cloner.b = 20;
		Cloner clonee = (Cloner)cloner.clone();
		
		System.out.println(clonee.a);
		System.out.println(clonee.b);
		
		System.out.println(clonee.a=clonee.a+10);
		
		System.out.println(cloner.a);
	}
}
