package com.arrays;

public class RemoveDuplicatesFromSortedArray {

	public static int removeDuplicates(int[] nums) {

		int i = 0;
		int j = 1;
		int length = 0;
		for (; i < nums.length; i++) {
			for (; j < nums.length; j++) {
				if (nums[i] == nums[j])
					continue;
				else {
					if (i < nums.length - 1) {
						nums[i + 1] = nums[j];
						length++; 

					}
					break;

				}

			}
		}
		return length + 1;
	}

	public static void main(String[] args) {
		int[] arr = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
		removeDuplicates(arr);
	}
}
