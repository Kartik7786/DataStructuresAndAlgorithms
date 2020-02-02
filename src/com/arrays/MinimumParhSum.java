package com.arrays;

public class MinimumParhSum {

	public static int minPathSum(int[][] grid) {
		for (int i = 1; i < grid.length; i++) {
			grid[i][0] += grid[i - 1][0];
		}
		for (int i = 1; i < grid[0].length; i++) {
			grid[0][i] += grid[0][i - 1];
		}

		for (int i = 1; i < grid.length; i++) {
			for (int j = 1; j < grid[i].length; j++) {

				grid[i][j] += Math.min(grid[i][j - 1], grid[i - 1][j]);
			}
		}
		return grid[grid.length - 1][grid[0].length - 1];
	}

	public static void main(String[] args) {
		int[][] arr = { { 1, 2, 5 }, { 3, 2, 1 } };
		System.out.println(minPathSum(arr));
	}
}
