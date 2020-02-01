package com.misclaneous;

import java.util.HashSet;

public class HappyNumber {

	public static boolean isHappy(int n) {
		HashSet<Integer> set = new HashSet<Integer>();

		while (n != 1) {
			int num = 0;

			while (n != 0) {
				num += ((n % 10) * (n % 10));
				n = n / 10;
				
			}
			if (set.contains(n))
				return false;
			n = num;
			set.add(n);

		}

		return true;
	}

	public static void main(String[] args) {
		isHappy(19);
	}

}
