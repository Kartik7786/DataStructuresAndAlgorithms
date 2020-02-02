package com.strings;

import java.util.HashMap;
import java.util.HashSet;

public class MostCommonWord {

	public String mostCommonWord(String paragraph, String[] banned) {

		int max = 0;
		String result = "";
		HashSet<String> set = new HashSet<String>();

		HashMap<String, Integer> map = new HashMap<String, Integer>();

		String[] words = paragraph.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");

		for (String s : banned)
			set.add(s);

		for (String s : words) {
			map.put(s, map.getOrDefault(s, 0) + 1);
		}

		for (String s : map.keySet())
			if (!set.contains(s)) {
				if (map.get(s) > max)
					result = s;
			}
		return result;
	}
}
