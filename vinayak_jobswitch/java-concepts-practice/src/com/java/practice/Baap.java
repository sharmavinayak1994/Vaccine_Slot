package com.java.practice;

public class Baap {
	
	public int value;
	
	private int sum ;
	
	final int random = 3412;
	
	public void print() {
		System.out.println("This is from baap class " + value);
	}
	
	void defaultTry() {
		System.out.println("this is to test default access modifer");
	}
	
	public int adder(int a, int b) {
		return a+b;
	}
	
	public static void staticTest() {
		System.out.println("Static method parent");
	}
	
	public void setValue(int value) {
		value = this.value;
	}
	
	public int getValue() {
		return value;
	}
	
	Baap(int value){
		value = this.value;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}
	
}
