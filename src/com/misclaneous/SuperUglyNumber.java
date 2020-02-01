package com.misclaneous;

import java.util.PriorityQueue;

public class SuperUglyNumber {

	public static  int nthSuperUglyNumber(int n, int[] primes) {
		PriorityQueue<Integer> q = new PriorityQueue<Integer>((a, b) -> {
			if (a > b)
				return -1;
			else
				return 0;
		});

		int k = 2;
		q.add(1);
		while (q.size() < n) {
			for (Integer i : primes) {
				if (k % i == 0) {
					q.add(k);
					break;
				}
			}
			k++;
		}

		return q.poll();
	}
	public static void main(String[] args) {
		int [] primes = {2,7,13,19};
		nthSuperUglyNumber(12, primes);
	}

}
