package com.java.practice;

import java.util.HashMap;
import java.util.Map.Entry;

public class FirstUniqueChar {
	
	public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i=0; i<s.length(); i++){
            if(map.get(s.charAt(i)) == null){
                map.put(s.charAt(i), i);
            }else{
                map.put(s.charAt(i), -1);
            }
        }
        for(Entry<Character, Integer> entry : map.entrySet()){
            if(entry.getValue() > -1){
                return entry.getValue(); 
            }
        }
        return -1;
    }
	
	public static void main(String[] args) {
		FirstUniqueChar sol = new FirstUniqueChar();
		System.out.println(sol.firstUniqChar("leetcode"));
	}

}