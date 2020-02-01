package com.strings;

import java.util.Stack;

public class RemoveKDigits {

	public static String removeKDigits(String s, int k) {
		StringBuilder result = new StringBuilder();

		Stack<Integer> stack = new Stack();
		stack.push(Character.digit(s.charAt(0), 10));

		for (int i = 1; i < s.length(); i++) {

			while (!stack.isEmpty() && k > 0 && stack.peek() > Character.digit(s.charAt(i), 10)) {
				k--;
				stack.pop();
			}
			stack.push(Character.digit(s.charAt(i), 10));
		}
		if (stack.size() == s.length())
			stack.pop();
		boolean flag = true;
		for (int i : stack) {
			if (flag && i == 0) {
				continue;
			} else
				flag = false;
			result.append(i);
		}

		return result.toString();
	}

	public static void main(String[] args) {
		removeKDigits("112", 1);
	}
}
