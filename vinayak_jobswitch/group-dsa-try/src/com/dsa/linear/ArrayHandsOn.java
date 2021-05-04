package com.dsa.linear;

import java.util.Arrays;

public class ArrayHandsOn {

	void show() {
		
		Integer arr[] =new Integer[]{1,11,3,8,6};
		
		int max = arr[0];
		
		Arrays.sort(arr);
		
		System.out.println(arr[3]);
		
		for(int num : arr) {
			if(num > max) {
				max = num;
			}
		}
		System.out.println(max);
		
	}
	
	void fibbonacci() {
		int a=0;
		int b=1;
		int sum= 0;
		for(int i=0;i<10;i++) {
			System.out.print(a+" ");
			sum=a+b;
			a=b;
			b=sum;
			
		}
	}
	
	public static void main(String args[]) {
		ArrayHandsOn test = new ArrayHandsOn();
		test.fibbonacci();
		test.show();
	}
	
}
