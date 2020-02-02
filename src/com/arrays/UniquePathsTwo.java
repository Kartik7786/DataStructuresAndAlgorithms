package com.arrays;

public class UniquePathsTwo {

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
		if (obstacleGrid[0][0] == 1) {
			return 0;
		}
		if (obstacleGrid[0][0] == 0) {
			dp[0][0] = 1;
		}
		boolean flag = false;

		for (int i = 1; i < obstacleGrid.length; i++) {
			if (flag) {
				dp[i][0] = 0;
			} else if (obstacleGrid[i][0] == 1 && !flag) {
				flag = true;
			} else {
				dp[i][0] = 1;
			}
		}
		flag = false;
		for (int j = 1; j < obstacleGrid[0].length; j++) {
			if (flag) {
				dp[0][j] = 0;
			} else if (obstacleGrid[0][j] == 1 && !flag) {
				flag = true;
			} else {
				dp[0][j] = 1;
			}
		}

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (obstacleGrid[i][j] == 0) {
					dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
				}
			}
		}

		return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
	}
}
