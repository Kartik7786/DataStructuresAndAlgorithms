package com.strings;

public class ValidPalindromeTwo {
	public static boolean validPalindrome(String s) {
		int start = 0;

		int end = s.length() - 1;
		boolean flag = false;
		boolean sflag = false;
		boolean eflag = false;

		while (start < end) {
			if (s.charAt(start) != s.charAt(end)) {
				if (flag)
					return false;
				else if (!flag && s.charAt(1 + start) == s.charAt(end)) {
					start++;
					flag = true;
					sflag = true;
				} else if (!flag && s.charAt(start) == s.charAt(end - 1)) {
					end--;
					flag = true;
					eflag = true;
				} else
					return false;

			}

			if (!sflag)
				start++;
			if (!eflag)
				end--;

			sflag = false;
			eflag = true;

		}
		return true;
	}

	public static void main(String[] args) {

		validPalindrome(
				"aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga");

		String s = "aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga";
		int i = 0;
		for (char c : s.toCharArray()) {
			System.out.println(c + " ->" + i++);
		}
	}
}

// eedede

// "aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"
