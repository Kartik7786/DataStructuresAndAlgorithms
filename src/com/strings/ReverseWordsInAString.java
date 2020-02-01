package com.strings;

public class ReverseWordsInAString {

	public String reverseWords(String s) {
		String[] arr = s.split(" ");

		for (int i = 0; i < arr.length; i++) {
			String temp = arr[i];
			arr[i] = temp.trim();

		}

		StringBuilder result = new StringBuilder();

		for (int i = arr.length - 1; i >= 0; i--) {
			if (!arr[i].isEmpty()) {
				result.append(arr[i] + " ");
			}
		}
		return result.toString().trim();

	}
}