package com.java.practice;

public class ExcaelColumn {
	 public static void main(String[] args) {
		ExcaelColumn exe = new ExcaelColumn();
		System.out.println(exe.tryTwo("ABCDEF"));
	}
	 
	public int tryTwo(String s) {
		if(s.length()==1) {
			return (s.charAt(0)-65 +1);
		}else {
			double intVal = 0;
			while(s.length()>0) {
				char c = s.charAt(0);
				double baseVal = Math.pow(26,s.length()-1);
				baseVal = baseVal*(c-65+1);
				intVal+=baseVal;
				if(s.length()==1) {
					break;
				}
				s=s.substring(1, s.length());
			}
			return (int)intVal;
		}
	} 
}
