package com.java.practice;

import java.util.Arrays;

public class StringPoolConcept {
	public static void main(String[] args) {
		String s1 = "vinayak";
		String s2 = "vinayak";
		System.out.println(s1==s2);
		
		int[] arr = new int[]{1,2,3,4,5};
		
		int[] copyArr = Arrays.copyOfRange(arr, 2,5);
		
		for(int i: copyArr) {
			System.out.println(i);
		}
	}
}
