package com.misclaneous;

public class ReverseInteger {

	public static int reverse(int x) {

		boolean flag = false;
		if (x < 0) {
			x *= -1;
			flag = true;
		}
		try {
			String s = new String(Integer.toString(x));
			StringBuilder result = new StringBuilder(s);

			String reverse = result.reverse().toString();

			if (flag)
				return -1 * Integer.parseInt(reverse);

			return Integer.parseInt(reverse);

		} catch (NumberFormatException e) {
			return 0;
		}
	}

	public static void main(String[] args) {

		System.out.println(reverse(-321));

	}
}
