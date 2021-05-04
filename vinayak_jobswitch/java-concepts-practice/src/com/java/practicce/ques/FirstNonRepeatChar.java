package com.java.practicce.ques;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class FirstNonRepeatChar {
	
	public Character FirstUniqueChar(String S) {
		if(S == null)
			return null;
		
		HashMap<Character, Integer> map = new LinkedHashMap<Character, Integer>();
		for(int i=0;i<S.length();i++) {
			if(map.containsKey(S.charAt(i))) 
				map.put(S.charAt(i), map.get(S.charAt(i))+1);
			else 
				map.put(S.charAt(i), 1);
		}
		for(Character str : map.keySet()) {
			if(map.get(str)==1) {
				return str;
			}
		}
		return '0';
	}
	
	public static void main(String[] args) {
		FirstNonRepeatChar fnc = new FirstNonRepeatChar();
		System.out.println(fnc.FirstUniqueChar("effkegmmk"));
	}
}
