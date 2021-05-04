package com.java.practice;

public class Beta extends Baap {
	
	public int age; 

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public void print() {
		System.out.println("This is from Beta");
	}
	
	protected void defaultTry() {
		super.defaultTry();
		System.out.println("Testing in Beta");
	}
		
	Beta(int value){
		super(value);
	}
	
	public static void main(String[] args) {
		Beta b = new Beta(10);
		b.print();
		b.defaultTry();
		b.staticTest();
	}
	
}
