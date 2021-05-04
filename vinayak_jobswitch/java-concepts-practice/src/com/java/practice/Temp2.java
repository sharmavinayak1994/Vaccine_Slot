package com.java.practice;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class Temp 
{
    public static void throwit() 
    {
        throw new RuntimeException();
    }
//    public static void main(String args[])
//    {
//        try 
//        {
//            System.out.println("Hello world ");
//            //throwit();
//            System.out.println("try block ");
//        }
//        finally 
//        {
//                   System.out.println("False");
//        }
//        
//        HashMap<String, String> map = new HashMap<>();
//        map.put(null, "vinayak");
//        System.out.println(map.get("vinayak"));
//        
//        Iterator<Map.Entry<String,String>>itr = map.entrySet().iterator();
//        
//        for(Map.Entry<String, String> entries : map.entrySet()) {
//        	
//        }
//    }
}

public class Temp2 extends Temp{
	
	public static void throwit() {
		Temp2.throwit();
	}
	public void print() {
		
	}
	public static void main(String[] args) {
		Temp2 temp = new Temp2();
		temp.print();
		Temp2.throwit();
	}
}
		
				 


