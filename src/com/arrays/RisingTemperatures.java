package com.arrays;

import java.util.Stack;

public class RisingTemperatures {

	public static int[] dailyTemperatures(int[] T) {
		int[] result = new int[T.length];
		
		Stack<Integer> s = new Stack<>();

		for (int i = T.length-1; i >=0; i--) {
			if (!s.isEmpty() && T[i] < T[s.peek()]) {
				while (!s.isEmpty() && T[i] > T[s.peek()]) {
					int k = s.pop();
					result[k] = i - k;
					s.push(i);
				}
			} else
				s.push(i);
		}

		return result;
	}

	public static void main(String[] args) {
		int[] arr = { 73, 74, 75, 71, 69, 72, 76, 73 };
		dailyTemperatures(arr);
	}
}
