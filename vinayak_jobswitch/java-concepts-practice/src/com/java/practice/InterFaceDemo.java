package com.java.practice;

@FunctionalInterface
interface inter {
	public void show();
}

public class InterFaceDemo {
	public static void main(String[] args) {
		inter demo =() -> System.out.println("this is new");
		demo.show();
	}
}
