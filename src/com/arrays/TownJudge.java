package com.arrays;

import java.util.ArrayList;
import java.util.HashMap;

public class TownJudge {

	public int findJudge(int N, int[][] trust) {

		HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		int potentialcandidate = -1;
		int prevpotentialcandiadate = -1;
		ArrayList<Integer> arr = null;
		for (int i = 0; i < trust.length; i++) {

			if (!map.containsKey(trust[i][0]))
				arr = new ArrayList<Integer>();
			arr.add(trust[i][1]);
			map.put(trust[i][0], arr);

		}

		for (int i = 0; i < trust.length; i++) {

			if (!map.containsKey(trust[i][1]))

				potentialcandidate = trust[i][1];

			if (prevpotentialcandiadate != potentialcandidate)
				prevpotentialcandiadate = potentialcandidate;
			else
				return -1;

		}

		for (Integer element : map.keySet()) {
			boolean flag = false;
			for (int i = 0; i < map.get(element).size(); i++) {
				if (map.get(element).get(i) == potentialcandidate)
					flag = true;

			}
			if (flag)
				return potentialcandidate;
			else
				return -1;
		}

		return -1;

	}

	public static void main(String[] args) {

		TownJudge T = new TownJudge();
		int[][] trust = { { 1, 3 }, { 2, 3 } };
		System.out.println(T.findJudge(3, trust));
	}

	/*
	 * { 1, 8 }, { 1, 3 }, { 2, 8 }, { 2, 3 }, { 4, 8 }, { 4, 3 }, { 5, 8 }, { 5, 3
	 * }, { 6, 8 }, { 6, 3 }, { 7, 8 }, { 7, 3 }, { 9, 8 }, { 9, 3 }, { 11, 8 }, {
	 * 11, 3 }
	 */

}
