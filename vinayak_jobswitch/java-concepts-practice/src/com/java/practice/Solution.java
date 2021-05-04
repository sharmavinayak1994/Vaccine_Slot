package com.java.practice;

public class Solution {
	
	 public String reverseVowels(String s) {
	        StringBuilder str = new StringBuilder(s);
	        int reverseIndex = s.length()-1;
	        char temp; 
	        int i =0;
	        while(i<reverseIndex){
	            if("aeiou".indexOf(s.charAt(i))>=0 || "AEIOU".indexOf(s.charAt(i))>=0){
	                temp = s.charAt(i);
	                while(reverseIndex > i){
	                    if("aeiou".indexOf(s.charAt(reverseIndex))>=0 || "AEIOU".indexOf(s.charAt(reverseIndex))>=0){
	                        str.setCharAt(i, s.charAt(reverseIndex));
	                        str.setCharAt(reverseIndex, temp);
	                        reverseIndex--;
	                        break;
	                    }else {
	                    	reverseIndex--;
	                    }
	                }
	            }
	            i++;
	        }
	        return str.toString();
	    }

	 public static void main(String[] args) {
		Solution soln = new Solution();
		System.out.println(soln.reverseVowels("leetcode"));
	}
}
