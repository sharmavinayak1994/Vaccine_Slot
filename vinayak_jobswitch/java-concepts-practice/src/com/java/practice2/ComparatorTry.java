package com.java.practice2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorTry {
	
	public void sortDescending(List<Integer> values) {
		
		Collections.sort(values, (a,b)->{
			return a-b > 0?-1:1;
		});
		
		for(Integer i : values) {
			System.out.print(i+ " ");
		}
		
	}
	
	public static void main(String[] args) {
		ComparatorTry cty = new ComparatorTry();
		List<Integer> values = new ArrayList<Integer>();
		values.add(5);
		values.add(1);
		values.add(10);
		values.add(12);
		values.add(4);
		
		cty.sortDescending(values);
		
		Comparator<Integer> comp = new Comparator<Integer>() {
			
			public int compare(Integer a,Integer b) {
				return a > b ? -1:1;
			}
		};
	}
	
}
