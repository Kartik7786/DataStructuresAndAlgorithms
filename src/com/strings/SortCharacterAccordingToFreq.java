package com.strings;

import java.util.Arrays;
import java.util.HashMap;

public class SortCharacterAccordingToFreq {

	public String frequencySort(String s) {

		HashMap<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i)))
				map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
			else
				map.put(s.charAt(i), 1);
		}
		Character[] arr = new Character[s.length()];
		for (int i = 0; i < s.length(); i++) {

			arr[i] = s.charAt(i);
		}
		Arrays.sort(arr);
		Arrays.sort(arr, (a, b) -> {
			if (map.get(a) > map.get(b))
				return -1;
			else if (map.get(a) == map.get(b))
				return 0;

			return 1;
		});

		StringBuilder result = new StringBuilder();
		for (int i = 0; i < arr.length; i++)
			result.append(arr[i]);
		return result.toString();

	}

}
