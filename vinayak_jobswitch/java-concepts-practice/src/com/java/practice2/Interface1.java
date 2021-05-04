package com.java.practice2;

public interface Interface1 {
	
	int i =10;

	public void display(String value);
	
	public default  void  testMethod() {
		
		System.out.println("Interface 1");
	}
		
	
	
}
