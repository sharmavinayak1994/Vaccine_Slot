package com.java.practice;

public class DuplicaitesInSortedArray {

	public int removeDuplicates(int[] nums) {
		if (nums.length == 0)
			return 0;
		int i = 0;
		for (int j = 1; j < nums.length; j++) {
			if (nums[j] != nums[i]) {
				i++;
				nums[i] = nums[j];
			}
		}
		return i + 1;

	}

	void print(int[] nums, int length) {
		for (int i = 0; i < length; i++) {
			System.out.print(nums[i]);
		}
	}

	void print(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i]);
		}
	}

	public static void main(String[] args) {
		DuplicaitesInSortedArray dupe = new DuplicaitesInSortedArray();
		int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
		int length = dupe.removeDuplicates(nums);
		System.out.println(length);
		dupe.print(nums);
	}
}
