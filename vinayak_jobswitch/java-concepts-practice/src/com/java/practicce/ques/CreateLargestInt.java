package com.java.practicce.ques;

import java.util.ArrayList;
import java.util.Collections;

public class CreateLargestInt {

	public String createLargestNumber(int[] arr) {
		
		ArrayList<String> values =  new ArrayList<String>();
		for(int i=0; i<arr.length; i++) {
			values.add(Integer.toString(arr[i]));
		}
		
		Collections.sort(values, (a,b)->{
			String ab = a+b;
			String ba = b+a;
			return ab.compareTo(ba)>0 ? -1:1;
		});
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<values.size(); i++) {
			sb.append(values.get(i));
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		CreateLargestInt cli = new CreateLargestInt();
		System.out.println(cli.createLargestNumber(new int[] {1, 34, 9, 3, 98, 9, 76, 45, 4}));
	}
	
}
