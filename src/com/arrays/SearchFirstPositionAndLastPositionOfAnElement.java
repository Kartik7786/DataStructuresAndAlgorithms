package com.arrays;

public class SearchFirstPositionAndLastPositionOfAnElement {
	public int[] searchRange(int[] nums, int target) {
		int[] result = new int[2];
		int firstpos = firstPosition(nums, target);
		int lastpos = lastPosition(nums, target);
		result[0] = firstpos;
		result[1] = lastpos;

		return result;
	}

	public int firstPosition(int[] input, int target) {
		int low = 0;
		int high = input.length - 1;
		int result = -1;

		while (low <= high) {
			int mid = (low + high) / 2;
			if (input[mid] == target) {
				result = mid;
				high = mid - 1;
			} else if (target <= input[mid]) {
				high = mid - 1;
			} else if (target >= input[mid]) {
				low = mid + 1;
			}
		}
		return result;
	}

	public int lastPosition(int[] input, int target) {
		int low = 0;
		int high = input.length - 1;
		int result = -1;

		while (low <= high) {
			int mid = (low + high) / 2;
			if (input[mid] == target) {
				result = mid;
				low = mid + 1;
			} else if (target <= input[mid]) {
				high = mid - 1;
			} else if (target >= input[mid]) {
				low = mid + 1;
			}
		}
		return result;
	}
}
