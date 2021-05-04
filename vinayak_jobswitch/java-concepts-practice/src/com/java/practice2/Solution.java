package com.java.practice2;

import java.util.Stack;

public class Solution {

	public void simplify(String input) {
		// /a/.b/../../c/
		// /a/b/../../c/
		if(input == null)
			return;
		
		int length = input.length();
		int i=0;
		Stack<Character> values =new Stack<Character>();
		while(i<length) {
			Character val = input.charAt(i);
			if(!val.equals('.')) {
				values.push(input.charAt(i));
				i++;
			}else {
				StringBuilder sb =new StringBuilder();
				while(input.charAt(i)=='.' || input.charAt(i)=='/') { // ../
					sb.append(input.charAt(i));
					i++;
					if(sb.length()==3) {
						break;
					}
				}
				if(sb.toString().equals("../")) {
					 
					 //boolean flag = values.peek().equals('/');
					 Character checkSlash = values.pop();
					 while(!values.peek().equals(checkSlash) && !values.empty()) {
						 values.pop();
					 }
					
				}
				
			}
			
			
		}
		
		while(!values.isEmpty()) {
			System.out.print(values.pop());
		}
		
		
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		//s.simplify("/a///b///c///d///");
		
		System.out.println("nifty".getClass().getSimpleName());
	}
	
}
