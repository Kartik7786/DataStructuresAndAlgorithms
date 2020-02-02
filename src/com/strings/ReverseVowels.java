package com.strings;

import java.util.HashSet;

public class ReverseVowels {
	public String reverseVowels(String s) {

		StringBuilder result = new StringBuilder();

		char[] arr = new char[s.length()];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = s.charAt(i);

		}

		HashSet<Character> set = new HashSet<>();
		set.add('a');
		set.add('e');
		set.add('i');
		set.add('o');
		set.add('u');
		set.add('A');
		set.add('E');
		set.add('U');
		set.add('I');
		set.add('O');
		int low = 0;
		int high = s.length() - 1;

		while (low < high) {
			if (!set.contains(arr[low]))
				low++;
			if (!set.contains(arr[high]))
				high--;
			if (set.contains(arr[low]) && set.contains(arr[high])) {

				char temp = arr[low];
				arr[low] = arr[high];
				arr[high] = temp;
				low++;
				high--;
			}
		}

		for (char c : arr)
			result.append(c);
		return result.toString();
	}
}
