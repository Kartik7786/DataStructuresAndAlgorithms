package com.misclaneous;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationsOfPhoneNumber {

	public static List<String> letterCombinations(String digits) {

		ArrayList<String> result = new ArrayList<String>();

		HashMap<Integer, ArrayList<Character>> map = new HashMap<Integer, ArrayList<Character>>();

		int j = 2;
		for (int i = 97; i <= 122; i++) {
			ArrayList<Character> list = new ArrayList<Character>();
			for (int k = i; k < i + 3 && k < 123; k++) {
				list.add((char) (k));
			}
			if (j == 7 || j == 9) {
				list.add((char) (i + 3));
				i = i + 1;
			}
			i = i + 2;

			map.put((j), list);
			j++;
		}

		char[] arr = digits.toCharArray();
		if (arr.length == 1) {
			Character c1 = arr[0];
			int v1 = Character.getNumericValue(c1);
			ArrayList<Character> arr1 = map.get(v1);
			for (int n = 0; n < arr1.size(); n++) {
				StringBuilder s = new StringBuilder();
				s.append(arr1.get(n));
				result.add(s.toString());

			}
			return result;
		}

		for (int i = 0; i <= arr.length - 1; i++) {
			Character c1 = arr[i];
			Character c2 = arr[i + 1];
			int v1 = Character.getNumericValue(c1);
			int v2 = Character.getNumericValue(c2);

			ArrayList<Character> arr1 = map.get(v1);
			ArrayList<Character> arr2 = map.get(v2);
			if (arr2.size() == 0) {
				for (int n = 0; n < arr1.size(); n++) {
					StringBuilder s = new StringBuilder();

					s.append(arr1.get(n));
					result.add(s.toString());

				}

			}

			for (int m = 0; m < arr1.size(); m++) {
				for (int n = 0; n < arr2.size(); n++) {
					StringBuilder s = new StringBuilder();
					s.append(arr1.get(m));
					s.append(arr2.get(n));
					result.add(s.toString());

				}
			}

		}

		return result;

	}

	public static void main(String[] args) {

		letterCombinations("2");

	}

}
