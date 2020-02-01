package com.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	public static List<List<Integer>> threeSum(int[] nums) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();

		if (nums.length == 0 || nums.length == 2)
			return result;

		Arrays.sort(nums);

		for (int i = 0; i <= nums.length - 3; i++) {
			ArrayList<Integer> arr = null;
			if (i == 0 || nums[i - 1] != nums[i]) {
				int start = i + 1;
				int end = nums.length - 1;
				while (start < end) {
					System.out.println(start + " " + end);
					if (nums[i] + nums[start] + nums[end] == 0) {
						arr = new ArrayList<Integer>();
						arr.add(nums[i]);
						arr.add(nums[start]);
						arr.add(nums[end]);
						result.add(arr);
						start++;
					}

					if (nums[i] + nums[start] + nums[end] < 0) {

						start++;
					}

					if (nums[i] + nums[start] + nums[end] > 0) {
						end--;

					}

					while (start < end && nums[start] == nums[start + 1])
						start++;
					while (start < end && nums[end] == nums[end - 1])
						end--;
					start++;
				}
			}

		}

		return result;
	}

	public static void main(String[] args) {
		int[] arr = { -1, 0, 1, 0 };
		threeSum(arr);
		System.out.println("ThreeSum");
	}
}
