package com.arrays;

import java.util.Arrays;

public class KClosestPointsToOrigin {
	public int[][] kClosest(int[][] points, int K) {
		int[][] result = new int[K][2];

		Arrays.sort(points, (a, b) -> {
			float distance1 = (float) Math.sqrt((a[0] * a[0]) + (a[1] * a[1]));
			float distance2 = (float) Math.sqrt((b[0] * b[0]) + (b[1] * b[1]));
			if (distance1 < distance2)
				return -1;
			return 1;

		});

		for (int i = 0; i < K; i++) {

			int[] arr = new int[2];
			arr = points[i];

			result[i][0] = arr[0];
			result[i][1] = arr[1];
		}
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println("a".compareTo("b"));
	}
}