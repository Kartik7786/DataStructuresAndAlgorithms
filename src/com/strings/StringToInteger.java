package com.strings;

public class StringToInteger {

	boolean invalid = false;
	boolean isNegative = false;

	public int myAtoi(String str) {
		int result = 0;
		try {
			char[] input = format(str.toCharArray());
			if (invalid) {
				return 0;
			}
			for (int i = 0; i < input.length; i++) {
				if (Integer.MAX_VALUE / 10 <= result) {
					throw new NumberFormatException();
				}
				int temp = Character.digit(input[i], 10);
				result += temp * Math.pow(10, input.length - i - 1);
			}

		} catch (NumberFormatException e) {
			return isNegative == true ? Integer.MIN_VALUE : Integer.MAX_VALUE;
		}
		return isNegative == true ? result * -1 : result;
	}

	public char[] format(char[] input) {
		int i = 0;
		int start = 0;
		int end = 0;
		for (; i < input.length; i++) {
			if (input[i] == ' ') {
				continue;
			} else
				break;
		}
		if (input[i] == '-' || input[i] == '+') {
			if (input[i] == '-') {
				isNegative = true;
			}
			i++;
		} else if (!Character.isDigit(input[i])) {
			invalid = true;
			return input;
		}
		start = i;
		for (; i < input.length; i++) {
			if (Character.isDigit(input[i])) {
				end = i;
				continue;
			} else {

				break;
			}
		}

		char[] formattedArray = new char[end - start + 1];

		int k = 0;
		while (k < formattedArray.length && start <= end) {
			formattedArray[k++] = input[start++];
		}

		return formattedArray;
	}

	public static void main(String[] args) {
		StringToInteger s = new StringToInteger();
		System.out.println(s.myAtoi("   2 with words"));
		System.out.println(Integer.MIN_VALUE);
	}
}
