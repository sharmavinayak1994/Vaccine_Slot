package com.java.practice;
import java.util.*;

public class AnagramApproach {
	public void vaildate(String s, String t) {
		List<Character> original = new ArrayList<Character>();
		List<Character> ana = new ArrayList<Character>();
		for(int i=0;i<s.length(); i++) {
			original.add(s.charAt(i));
			ana.add(t.charAt(i));
		}
		
		Collections.sort(original);
		Collections.sort(ana);
		System.out.println(original.equals(ana));
	}
	
	public static void main(String[] args) {
		AnagramApproach app = new AnagramApproach();
		app.vaildate("abc", "abc");
	}
}
