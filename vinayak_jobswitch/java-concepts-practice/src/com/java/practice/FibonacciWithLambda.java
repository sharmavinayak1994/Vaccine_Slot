package com.java.practice;

import java.util.stream.Stream;

public class FibonacciWithLambda {

	public static void main(String[] args) {
		int fib[]= {0,1};
		Stream<Integer> fibo = Stream.generate(() -> {
			int result  = fib[1];
			int fib3 = fib[0]+fib[1];
			fib[0]=fib[1];
			fib[1] = fib3;
			return result;
		});
		
		fibo.forEach(i->System.out.println(i));
	}
	
}
