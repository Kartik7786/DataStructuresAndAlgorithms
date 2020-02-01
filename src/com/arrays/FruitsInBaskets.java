package com.arrays;

import java.util.HashSet;

public class FruitsInBaskets {

	public static int totalFruit(int[] tree) {

		if (tree.length == 0 || tree == null)
			return 0;
		int max = 1;
		HashSet<Integer> set = new HashSet<>();

		int i = 0;

		while (i < tree.length) {
			int j = i;
			while (j < tree.length && set.size() < 3) {
				j++;
				if (!set.contains(tree[j]))
					set.add(tree[j]);

				if (set.size() < 3)
					max = Math.max(j - i + 1, max);

			}
			set = new HashSet<Integer>();
			i++;
		}
		return max;
	}

	public static void main(String[] args) {

		int[] a = { 3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4 };
		totalFruit(a);

	}

}
