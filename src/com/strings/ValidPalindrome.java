package com.strings;

public class ValidPalindrome {

	public static boolean isPalindrome(String s) {
		if (s.isEmpty())
			return true;

		String result = s.toLowerCase();
		StringBuilder string = new StringBuilder();
		StringBuilder reverse = null;

		for (int i = 0; i < result.length(); i++) {
			if ((int) result.charAt(i) > 47 && (int) result.charAt(i) < 59 && result.charAt(i) != ' ')
				string.append(result.charAt(i));
			
			if ((int) result.charAt(i) > 96 && (int) result.charAt(i) < 123 && result.charAt(i) != ' ')
				string.append(result.charAt(i));
		}

		reverse = new StringBuilder(string).reverse();

		if (reverse != null && string.toString().equals(reverse.toString()))
			return true;
		return false;
	}

	public static void main(String[] args) {
		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
	}
}
