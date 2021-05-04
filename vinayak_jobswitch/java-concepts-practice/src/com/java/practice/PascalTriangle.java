package com.java.practice;

import java.util.*;

public class PascalTriangle {

	public List<List<Integer>> generate(int numRows) {
		ArrayList<List<Integer>> answer = new ArrayList<List<Integer>>();
		List<Integer> prev = new ArrayList<Integer>();
		int i = 1;
		while (i <= numRows) {
			int j = i;
			List<Integer> temp = new ArrayList<Integer>();
			if (j == 1) {
				temp.add(1);
			} else {
				for (int k = 0; k < j; k++) {
					if (k == 0 || k == j - 1) {
						temp.add(1);
					} else {
						temp.add(prev.get(k - 1) + prev.get(k));

					}
				}
			}
			prev = temp;
			answer.add((ArrayList<Integer>) prev);
			i++;
		}
		return answer;
	}
	
	 public int hammingWeight(int n) {
	        int count = 0;
	        String str = Integer.toString(n);
	        System.out.println(str);
	        for(int i=0;i<str.length();i++){
	            if(str.charAt(i) == '1'){
	                count+=1;
	            }
	        }
	        return count;
	    }

	public static void main(String[] args) {
		PascalTriangle ptri = new PascalTriangle();
		List<List<Integer>> answer = ptri.generate(5);
		System.out.println(ptri.hammingWeight(00000000000000000000000000001011));
	}
}
