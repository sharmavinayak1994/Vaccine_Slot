package com.java.practice;

public class ShiftZero {
	
	public void moveZeroes(int[] nums) {
        int lastNonZeroIndex = 0;
        for(int i=0; i<nums.length; i++) {
        	if(nums[i]!=0) {
        		nums[lastNonZeroIndex++] = nums[i];
        	}
        }
        while(lastNonZeroIndex<nums.length) {
        	nums[lastNonZeroIndex] = 0;
        	lastNonZeroIndex ++;
        }
    }
	
	public static void main(String[] args) {
		ShiftZero shift = new ShiftZero();
		int nums [] = {1,0,2,0,3,4,5};
		shift.moveZeroes(nums);
	}

}
