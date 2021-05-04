package com.dsa.linear;

import java.util.HashMap;
import java.util.Map;

public class DuplicatesInArray {

	public int duplicateCount(int arr[]) {
		int temp =0 ;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0;i<arr.length;i++) {
			if(map.get(arr[i]) == null) {
				map.put(arr[i], 1);
			}else {
				map.put(arr[i], map.get(arr[i])+1);	
			}
			
		}
		for(Map.Entry value: map.entrySet()) {
			if(!value.getValue().equals(1)) {
				temp++;
			}
		}
		return temp;
	}
		
	public static void main(String[] args) {
		DuplicatesInArray dupe = new DuplicatesInArray();
		//int arr[] = {1,2,3,2,5,3,3,5,7,8};
		int arr[] = {1001,1001};
		System.out.println(dupe.duplicateCount(arr));
	}
}
