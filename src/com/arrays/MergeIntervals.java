package com.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeIntervals {

	public static int[][] merge(int[][] intervals) {

		ArrayList<int[]> result = new ArrayList<>();

		Arrays.sort(intervals, (a, b) -> {
			if (a[0] < b[0])
				return -1;
			if (a[0] == a[0])
				if (a[1] < b[1])
					return -1;
				else
					return +1;

			return 0;
		});

		

		for (int i = 0; i < intervals.length - 1; i++) {
			if (i < result.size() && result[0] < intervals[i + 1][1]) {

				result.get(i)[1] = Math.max(result.get(i)[1], intervals[i + 1][1]);

			}

			else {

				int[] arr2 = new int[2];
				arr2[0] = intervals[i][0];
				arr2[1] = intervals[i][1];
				result.add(arr2);
			}
		}

		int[][] ans = new int[result.size()][2];
		int i = 0;
		for (int[] elements : result) {
			ans[i] = elements;
		}

		return ans;

	}

	public static void main(String[] args) {
		int[][] arr = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
		merge(arr);
	}
}