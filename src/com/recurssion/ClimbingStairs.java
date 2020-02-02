package com.recurssion;

import java.util.Arrays;

public class ClimbingStairs {

	int[] memo;

	public int climbStairs(int n) {
		if (n == 1)
			return 1;
		memo = new int[n + 1];
		Arrays.fill(memo, -1);
		memo[0] = 0;
		memo[1] = 1;
		memo[2] = 2;
		helper(n);
		return memo[n];
	}

	public int helper(int n) {

		if (memo[n] != -1)
			return memo[n];
		else {
			memo[n] = helper(n - 1) + helper(n - 2);

		}
		return memo[n];
	}

}
