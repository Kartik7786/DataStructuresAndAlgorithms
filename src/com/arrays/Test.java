package com.arrays;

import java.util.Stack;

class Test {
	public static boolean solution(String S) {
		if (S == null || S.length() == 0)
			return true;
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < S.length(); i++) {
			if (S.charAt(i) == ' ')
				continue;
			if (S.charAt(i) == '(') {
				stack.push(')');
			} else if (S.charAt(i) == '{') {
				stack.push('}');
			} else if (S.charAt(i) == '[') {
				stack.push(']');
			} else {
				System.out.println(stack.peek() + "   " + S.charAt(i));
				if (stack.peek() != S.charAt(i)) {
					return false;
				} else {
					stack.pop();
				}
			}
		}
		if (!stack.isEmpty()) {
			return false;
		}
		return true;

	}

	public static void main(String[] args) {
		String S = "{([()])}";
		solution(S);
	}
}
