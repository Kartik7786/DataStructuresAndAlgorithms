package com.arrays;

import java.util.Arrays;

public class RemoveAllInstancesInArray {
	public static int removeElement(int[] nums, int val) {

		Arrays.sort(nums);
		int start = -1;
		int end = -1;
		int result = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == val && start == -1)
				start = i;
			else if (start > -1 && (nums[i] != val|| i == nums.length - 1)) {
				end = i;
				break;
			}
		}

		if (start == -1 || end == -1)
			return 0;

		result = nums.length -1 -(end-start);

		while (start < end && end < nums.length) {
			nums[start] = nums[end];
			start++;
			end++;
		}

		return result;
	}

	public static void main(String[] args) {
		int arr[] = { 2, 3, 2, 3, 2 };
		removeElement(arr, 3);
	}
}
