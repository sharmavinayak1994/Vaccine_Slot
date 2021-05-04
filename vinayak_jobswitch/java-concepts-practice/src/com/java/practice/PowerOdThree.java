package com.java.practice;

public class PowerOdThree {

	 public boolean isPowerOfThree(int n) {
	        if(n==0){
	            return false;
	        }
	        
	        while((n != -1) && (n!=1)){
	            int check = n%3;
	            if(check != 0){
	                return false;
	            }else{
	                n=n/3;
	            }   
	        }
	        return 
	            true;
	        
	    }
	 public static void main(String[] args) {
		PowerOdThree pot = new PowerOdThree();
		System.out.println(pot.isPowerOfThree(-3));
	}
}
