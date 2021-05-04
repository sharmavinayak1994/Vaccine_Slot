package com.java.practice;

public class StringReverse {
	
	public void reverser(String str) {
		
		if((str==null) || (str.length()<=1)) {
			System.out.println(str);
		}else {
			System.out.println(str.charAt(str.length()-1));
			reverser(str.substring(0, str.length()-1));
		}
	}
	
	public static void main(String[] args) {
		StringReverse rev = new StringReverse();
		rev.reverser("VINAYAK");
	}

}
