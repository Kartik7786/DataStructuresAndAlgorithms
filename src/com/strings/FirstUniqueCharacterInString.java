package com.strings;

import java.util.HashMap;

public class FirstUniqueCharacterInString {
	public static int firstUniqueChar(String s) {
		HashMap<Character, Integer> map = new HashMap<>();
		for (char c : s.toCharArray()) {
			if (map.containsKey(c))
				map.put(c, map.get(c) + 1);
			else
				map.put(c, 1);
		}

		for (int i = 0; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) == 1)
				return i;
		}
		return -1;
	}

	public static void main(String[] args) {
		firstUniqueChar("loveleetcode");
	}
}
