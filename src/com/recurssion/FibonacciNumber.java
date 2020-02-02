package com.recurssion;

import java.util.Arrays;

public class FibonacciNumber {

	int[] memo;

	public int fib(int N) {
		if (N == 1)
			return 1;
		if (N == 0)
			return 0;
		memo = new int[N + 1];
		Arrays.fill(memo, -1);
		memo[0] = 0;
		memo[1] = 1;
		memo[2] = 1;
		helper(N);
		return memo[N];
	}

	public int helper(int N) {

		if (memo[N] != -1)
			return memo[N];
		else {
			memo[N] = helper(N - 1) + helper(N - 2);

		}
		return memo[N];
	}
}
