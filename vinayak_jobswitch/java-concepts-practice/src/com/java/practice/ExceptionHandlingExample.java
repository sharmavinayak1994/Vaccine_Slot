package com.java.practice;

public class ExceptionHandlingExample {

	public void divide(int a, int b){
		if(b==0) {
			throw new ArithmeticException("Tried to do division by 0");
		}
		System.out.println(a/b);
	}
}
