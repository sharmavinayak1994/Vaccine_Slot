package com.java.practice;

public class BivaluedArray {
	
	public int bivaluedCount(int[] arr) {
		
		if(arr.length ==2) {
			return arr.length;
		}
		
		int output=0;
		for(int i=0; i<arr.length; i++) {
			int startVal = arr[i];
			int prevNum = startVal;
			int count =0;
			int length = 0;
			for(int j=i+1; j<arr.length; j++) {
				length = (j+1) - i;
				if(arr[j]!=startVal && arr[j]!=prevNum) {
					startVal = arr[j];
					count++;
					if(count==2) { 	
						length = (j+1) - i;
						break;
					}
				}
			}
			if(length>output)
				output = length;
		}
		return output;
	}
	
	public static void main(String[] args) {
		BivaluedArray ba = new BivaluedArray();
		int[] input = new int[] {1, 2, 1, 2, 2, 3, 3, 2, 3};
		System.out.println(ba.bivaluedCount(input));
	}

}
