package com.strings;

import java.util.HashMap;

public class VerifyingAlienDictonary {
	public static boolean isAlienSorted(String[] words, String order) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < order.length(); i++)
			map.put(order.charAt(i), i);

		for (int i = 0; i < words.length - 1; i++) {

			String s1 = words[i];
			String s2 = words[i + 1];
			int k = 0;
			int j = 0;
			while (k < s1.length() && j < s2.length()) {
				if (map.get(s1.charAt(k)) < map.get(s2.charAt(j)))
					break;
				else {
					if (s1.charAt(k) == s2.charAt(j)) {
						j++;
						k++;
					} else
						return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String[] arr = { "word", "world", "row" };
		String s = "worldabcefghijkmnpqstuvxyz";
		isAlienSorted(arr, s);
	}
}
