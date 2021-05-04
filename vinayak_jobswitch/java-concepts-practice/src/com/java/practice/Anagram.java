package com.java.practice;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Anagram {
	public boolean isAnagram(String s, String t) {
        boolean sach = false;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        if(s.length() != t.length()){
            return sach;
        }else{
            for(int i=0;i<s.length(); i++){
                if(map.get(s.charAt(i))==null){
                    map.put(s.charAt(i), 1);
                }else{
                   map.put(s.charAt(i), map.get(s.charAt(i))+1) ;
                }
                
                if(map.get(t.charAt(i)) == null){
                    map.put(t.charAt(i), 1);
                }else{
                    map.put(t.charAt(i), map.get(t.charAt(i))+1);
                }
            }
            for(Map.Entry<Character, Integer> entry : map.entrySet()){
                int val = entry.getValue().intValue();
                if((val%2) != 0){
                    sach = false;
                    break;
                }else{
                    sach = true;
                }
            }
        }
        return sach;
    }
	public static void main(String[] args) {		
		Anagram ana = new Anagram();
		System.out.println(ana.isAnagram("anagram", "marnaga"));
		
		String a = "vina";
		String b = "yak";
		String c = a.concat(b);
		System.out.println(a);
		System.out.println(c);;
		StringBuilder sb = new StringBuilder(c);
		sb.substring(0,1);
		
		int x=-1;
		int y =1;
		int sum =0;
		for(int i=0;i<=10;i++) {	
			sum = x+y;
			System.out.println(sum);
			x=y;
			y=sum;
		}
		
		AtomicInteger i = new AtomicInteger();
		i.incrementAndGet();
		
		
		
	}
}
