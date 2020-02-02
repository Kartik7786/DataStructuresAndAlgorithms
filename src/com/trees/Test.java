package com.trees;

import java.util.Arrays;

public class Solution {
	public int findPeakElement(int[] nums) {
		return search(nums, 0, nums.length - 1);
	}

	public int search(int[] nums, int l, int r) {
		if (l == r)
			return l;

		if (l <= r) {
			int mid = (l + r) / 2;

			if (mid + 1 >= 0) {
				if (nums[mid] < nums[mid - 1])
					return search(nums, l, mid - 1);
			} else if (nums[mid + 1] < nums.length - 1) {
				if (nums[mid] < nums[mid + 1])
					return search(nums, mid + 1, r);
			} else
				return mid;
		}

		return 0;
	}
}
