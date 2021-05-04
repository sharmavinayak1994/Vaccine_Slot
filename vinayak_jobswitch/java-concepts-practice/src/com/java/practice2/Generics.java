package com.java.practice2;

import java.util.ArrayList;
import java.util.List;

public class Generics {

	/** 
	 * In this class we will learn about generic in java*
	 * Generic are compile time feature, when complier compiles the code 
	 * it eventually converts generic <T> to <Object> 
	 * */
	
	public<T extends Number > double addValues(T a, T b){
		
		
		if(a instanceof Number && b instanceof Number) {
			double sum =a.doubleValue()+b.doubleValue();
			return sum;
		}
		return 0;
	}
	
	public <T extends Number> List<Double> addListElements(List<T> l1, List<T> l2){
		double sum;
		List<Double> output = new ArrayList<>();
		for(int i=0; i<l1.size();i++) {
			sum = l1.get(i).doubleValue() + l2.get(i).doubleValue();
			output.add(sum);
		}
		
		return output;
		
	}
	
	public void print(Integer i) {
		System.out.println(i + "from integer func");
	}
	
	public void print(String s) {
		System.out.println(s + "from String func");
	}
	
	public static void main(String[] args) {
		Generics gg = new Generics();
		System.out.println(gg.addValues(11.44, 12.23));
		
		int i =22;
		short a =10;
		
		//a=(short)i;
		
		System.out.println(i+a);
		Integer ii = null;
		gg.print(ii);
	}
}
