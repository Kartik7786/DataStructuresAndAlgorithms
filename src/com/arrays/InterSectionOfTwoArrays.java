package com.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class InterSectionOfTwoArrays {
	public static int[] intersect(int[] nums1, int[] nums2) {
		int[] result;
		ArrayList<Integer> arr = new ArrayList<>();
		Arrays.sort(nums1);
		Arrays.sort(nums2);

		if (nums1.length < nums2.length) {
			int i = 0;
			int j = 0;
			while (i < nums1.length) {
				if (nums2[i] == nums1[j]) {
					arr.add(nums2[i]);
					i++;
					j++;
				} else if (nums1[i] < nums2[j])
					i++;
				else
					j++;
			}
		} else {
			int i = 0;
			int j = 0;
			while (i < nums2.length) {
				if (nums2[i] == nums1[j]) {
					arr.add(nums2[i]);
					i++;
					j++;
				}

				else if (nums2[i] < nums1[j])
					i++;
				else
					j++;
			}
		}

		result = new int[arr.size()];

		for (int i = 0; i < result.length; i++) {
			result[i] = arr.get(i);
		}
		return result;
	}

	public static void main(String[] args) {

		int arr1[] = { 1, 2, 2, 1 };
		int arr2[] = { 2, 2 };

		intersect(arr1, arr2);
	}

}
