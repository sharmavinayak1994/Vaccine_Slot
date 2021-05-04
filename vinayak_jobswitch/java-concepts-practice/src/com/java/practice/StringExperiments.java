package com.java.practice;

public class StringExperiments {
	
	public static void main(String[] args) {
		String a = new String("VINAYAK");
		String b = new String("VINAYAK");
		
		System.out.println(a.equals(b));
		
		String x = "VINAYAK";
		String y = "VINAYAK";
		
		System.out.println(x==y);
		System.out.println(a==x);
		System.out.println(b==x);
	}

}
