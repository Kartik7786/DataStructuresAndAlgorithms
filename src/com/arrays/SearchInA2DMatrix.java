package com.arrays;

public class SearchInA2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
		for (int i = 0; i < matrix.length; i++) {
			int start = 0;
			int end = matrix[i].length - 1;
			while (start <= end) {
				int mid = (start + end) / 2;
				if (target == matrix[i][mid])
					return true;
				else if (target >= matrix[i][mid])
					start = mid + 1;
				else
					end = mid - 1;
			}
		}
		return false;
	}
}
