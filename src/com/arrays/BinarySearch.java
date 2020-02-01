package com.arrays;

public class BinarySearch {

	public static int binarySearch(int[] input, int target) {

		int low = 0;
		int high = input.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (input[mid] == target) {
				return mid;
			} else if (target < input[mid]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] arr = { 2, 3, 4, 5, 6, 7, 8, 9 };
		System.out.println(binarySearch(arr, 0));
	}
}
