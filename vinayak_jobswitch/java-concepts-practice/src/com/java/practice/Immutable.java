package com.java.practice;

import java.util.*;

public final class Immutable {
	
	private final String str;
	
	final Integer val = 10;
	
	final StringBuffer sb;
	
	private final List<Integer> values;
	
	public String getStr() {
		return str;
	}

	public List<Integer> getValues() {
		//List<Integer> duplicate = new ArrayList<Integer>(this.values);
		return values;
	}
	
	public Immutable(String str, List<Integer> values, StringBuffer sb) {
		super();
		this.str = str;
		this.values = Collections.unmodifiableList(values);
		this.sb = sb;
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		Immutable imu = new Immutable("VINAYAK", list, new StringBuffer("VINAYAK_SB")); 
		//imu.getValues().add(3);  --> gives run time exception of unsupported operation 
		imu.sb.append("SHARMA");
		//imu.sb = new StringBuffer("Sharma"); --> Compile time error.
		System.out.println(imu.sb.toString());
		for(Integer value : imu.getValues()) {
			System.out.println(value);
		}
		//System.out.println(t);
		
	}
}
