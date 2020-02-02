package com.strings;

import java.util.HashSet;

public class LongestSubStringWithoutRepeatingCharacters {

	public static int lengthOfLongestSubstring(String s) {

		int max = 1;
		if (s.isEmpty() || s == null)
			return 0;

		for (int i = 0; i < s.length() - 1; i++) {
			int temp = helper(s, i, i);

			max = temp > max ? temp : max;

		}
		return max;
	}

	public static int helper(String s, int start, int end) {

		HashSet<Character> set = new HashSet<Character>();
		while (!set.contains(s.charAt(end)) && end < s.length()) {

			set.add(s.charAt(end));

			end++;
		}
		return end - start;
	}

	public static void main(String[] args) {
		lengthOfLongestSubstring("pwwkew");
	}

}
