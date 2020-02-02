package com.arrays;

import java.util.Arrays;

public class ClimbingStairs {

	int[] memo;

	public int climbStairs(int n) {
		if (n < 0) {
			return n;
		}
		memo = new int[n + 1];
		Arrays.fill(memo, -1);
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		memo[0] = 0;
		memo[1] = 1;
		memo[2] = 2;
		count(n);

		return memo[n];

	}

	public int count(int n) {

		if (memo[n] != -1) {
			return memo[n];
		} else {
			return memo[n] = count(n - 1) + count(n - 2);
		}

	}

	public int iterativeClimb(int n) {
		memo = new int[n + 1];
		memo[0] = 0;
		memo[1] = 1;
		memo[2] = 2;

		for (int i = 3; i <= n; i++) {
			memo[i] = memo[i - 1] + memo[i - 2];
		}

		return memo[n];
	}

}
