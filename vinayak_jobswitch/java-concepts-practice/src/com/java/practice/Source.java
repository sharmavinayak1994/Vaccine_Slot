package com.java.practice;

public class Source extends Exception{
	
	
	
		public static void Order(String s)
		{
			System.out.println("String");
		}
		public static void Order(Object o)
		{
			System.out.println("Object");
		}
		public static void main (String [] args)
		{
			Order(null);
		}
	
		Source(String s){
			super(s);
		}
}
