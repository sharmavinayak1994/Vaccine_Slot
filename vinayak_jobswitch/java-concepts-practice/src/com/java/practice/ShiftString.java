package com.java.practice;

public class ShiftString {

	public int rotateWords(String input, int k) {
		String arr[] = input.split(" ");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			int index = 0;
			int length = arr[i].length();
			for (int j = 0; j < arr[i].length(); j++) {
				index = (length - k) + j;
				if (index >= length) {
					index = index - length;
				}
				sb.append(arr[i].charAt(index));
			}
			sb.append(" ");
		}
		sb.toString().trim();
		System.out.println(sb.toString());
		if (input.equalsIgnoreCase(sb.toString().trim())) {
			return 0;
		} else {
			return 1;
		}
	}
	
	public static void main(String[] args) {
		ShiftString ss = new ShiftString();
		System.out.println(ss.rotateWords("llohe ereth", 2));
		char c = 6;
		int i = c;
		System.out.println(i);
	}
}
