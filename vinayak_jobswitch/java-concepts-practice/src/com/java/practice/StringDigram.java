package com.java.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StringDigram {

	public int distance(String str) {
		boolean flag = false;
		int revIndex = str.length() - 1;
		StringBuilder temp1 = new StringBuilder();
		StringBuilder temp2;
		List<Integer> digram = new ArrayList<Integer>();
		for (int i = 0; i < str.length(); i++) {
			temp1.setLength(0);
			temp1.append(str.charAt(i));
			temp1.append(str.charAt(i+1));
			temp2 = new StringBuilder(str.substring(i+1, str.length()));
			boolean check = true;
			int distance = 0;
			while (check) {
				if (temp2.toString().contains(temp1.toString())) {
					flag = true;
					distance += temp2.indexOf(temp1.toString());
					int sub = temp2.indexOf(temp1.toString()) +2;
					temp2 = new StringBuilder(temp2.toString().substring(sub, temp2.length()));
				}else {
					check = false;
				}
			}
			digram.add(distance+3);
			if(i+1 == revIndex) {
				break;
			}
		}
		if(flag) {
			Collections.sort(digram);
			return digram.get(digram.size()-1);
		}else {
			return -1;
		}
		
	}
	
	public static void main(String[] args) {
		StringDigram sd = new StringDigram();
		System.out.println(sd.distance(""));
	}

}
