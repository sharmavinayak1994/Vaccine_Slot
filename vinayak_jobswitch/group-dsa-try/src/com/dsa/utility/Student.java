package com.dsa.utility;

public class Student {

	public int age;
	public String Name;
	
	public Student(int age, String name) {
		super();
		this.age = age;
		Name = name;
	}

	@Override
	public String toString() {
		return "Student [age=" + age + ", Name=" + Name + "]";
	}
	
}
