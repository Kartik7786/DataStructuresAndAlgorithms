package com.graphs;

import java.util.ArrayList;

public class FindTheCelebrity {

	public boolean knows(int i, int j) {
		// Helper Function to Know if One Person Knows Another
		return true;
	}

	public int findCelebrity(int n) {
		ArrayList<int[]> list = new ArrayList<>();
		int[] result = new int[n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (knows(i, j)) {
					int[] arr = new int[2];
					arr[0] = i;
					arr[1] = j;
					list.add(arr);

				}
			}
		}
		for (int[] elements : list)
			System.out.println(elements[0] + " " + elements[1]);
		for (int i = 0; i < list.size(); i++) {
			result[list.get(i)[0]] -= 1;
			result[list.get(i)[1]] += 1;
		}
		for (int i = 0; i < result.length; i++) {
			if (result[i] == n - 1)
				return i;
		}
		return -1;
	}

}
