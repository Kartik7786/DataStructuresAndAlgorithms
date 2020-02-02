package com.heap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TopKFrequentElements {
	public List<Integer> topKFrequent(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap();
		int max = 0;
		ArrayList<Integer> result = new ArrayList();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				map.put(nums[i], map.get(nums[i]) + 1);
				max = map.get(nums[i]) > max ? map.get(nums[i]) : max;
			} else
				map.put(nums[i], 1);
		}

		List<Integer>[] frequency = new ArrayList[max + 1];

		for (Integer element : map.keySet()) {
			if (frequency[map.get(element)] == null) {
				frequency[map.get(element)] = new ArrayList<Integer>();

			}
			frequency[map.get(element)].add(element);
		}
		int i = frequency.length;
		while (i >= 0 && result.size() <= k) {
			if (frequency[i] != null)
				result.addAll(frequency[i]);
		}
		return result;
	}

}