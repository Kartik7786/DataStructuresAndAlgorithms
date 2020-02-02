package com.strings;

import java.util.Arrays;

public class LongestCommonPrefix {
	public static String longestCommonPrefix(String[] strs) {

		String result = "";

		Arrays.sort(strs, (a, b) -> {

			if (a.length() < b.length())

				return -1;

			else
				return 1;

		});

		for (int j = 0; j < strs[0].length(); j++) {

			for (int i = 0; i < strs.length; i++) {

				if (strs[0].charAt(j) != strs[i].charAt(j))
					return result;

			}
			result += strs[0].charAt(j);
		}
		return result;
	}

	public static void main(String[] args) {
		String[] arr = { "flower", "flow", "flight" };
		longestCommonPrefix(arr);
	}

}
