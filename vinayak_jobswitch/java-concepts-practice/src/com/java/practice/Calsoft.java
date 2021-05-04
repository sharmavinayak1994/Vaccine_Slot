package com.java.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class Calsoft {
	
	public void duplicaterFinder(int[] arr){
		
		//ArrayList<Integer> values = new ArrayList<Integer>();
		
		int range = arr.length;
		int first_value = arr[0];
		int last_value = arr[arr.length-1];
		
		HashMap<Integer, Integer> dupes = new HashMap<Integer, Integer>();
				
		for(int i=0; i<arr.length;i++) {
			if(dupes.containsKey(arr[i])) {
				dupes.put(arr[i], dupes.get(arr[i])+1);
			}else {
				dupes.put(arr[i],1);
			}
		}
		
		for(Map.Entry<Integer, Integer> map : dupes.entrySet()) {
			if(map.getValue()>1) {
				System.out.println(map.getKey());
			}
		}
		int i=0;
		while(i+1<arr.length) {
			
			while(arr[i] == arr[i+1]) {
				i=i+1;
			}
			
			if(arr[i+1]-arr[i] > 1) {
				int temp = arr[i];
				while(temp<arr[i+1]) {
					temp+=1;
					System.out.print(temp);
				}
			}
			
			i++;
		}
		
		
	}
	
	public int[] addValue(int []arr) {
		
		int[] arrNew = new int[arr.length+3];
		int temp = arr[arr.length-1];
		for(int i=arr.length; i<arrNew.length; i++) {
			arrNew[i] = temp+1;
			temp = temp+1;
		}
		
		System.arraycopy(arr, 0, arrNew, 0, arr.length);
		
		arr = arrNew;
		
		/*for(int i=0 ;i<arr.length;i++) {
			
			System.out.println(arr[i]);
		}*/
		return arr;
	}
	
	public static void main(String[] args) {
		Calsoft cal = new Calsoft();
		int arr[] = new int[] {1, 2, 3};
		//cal.duplicaterFinder(arr);
		arr= cal.addValue(arr);
		
		for(int i=0; i<arr.length ;i++) {
			System.out.println(arr[i]);
		}
	}
	
	//missing nums: 4,6,8
	//repeating nums: 1,5,9
	//1, 1, 2, 3, 5, 5, 7, 9, 9, 9
}
