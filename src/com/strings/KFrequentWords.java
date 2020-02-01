package com.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class KFrequentWords {

	public static List<String> topKFrequent(String[] words, int k) {
		ArrayList<String> result = new ArrayList();
		HashMap<String, Integer> map = new HashMap();
		int max = 1;

		for (int i = 0; i < words.length; i++) {
			if (map.containsKey(words[i])) {
				map.put(words[i], map.get(words[i]) + 1);
				max = map.get(words[i]) > max ? map.get(words[i]) : max;
			} else
				map.put(words[i], 1);
		}

		PriorityQueue<String>[] frequency = new PriorityQueue[max + 1];

		for (String element : map.keySet()) {
			int freq = map.get(element);
			if (frequency[freq] == null)
				frequency[freq] = new PriorityQueue<String>();

			frequency[freq].add(element);
		}

		int i = frequency.length - 1;
		while (i >= 1) {
			if (result.size() < k) {
				if (frequency[i] != null) {
					int j = 0;
					while (!frequency[i].isEmpty()) {
						if (result.size() < k) {
							result.add(frequency[i].poll());
							j++;
						} else
							break;
					}

				}
			} else
				break;
			i--;
		}
		return result;
	}

	public static void main(String[] args) {

		String[] words = { "i", "love", "leetcode", "i", "love", "coding" };

		topKFrequent(words, 2);

	}

}
