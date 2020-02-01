package com.misclaneous;

import java.util.ArrayList;

class MinStack {

	private ArrayList<Integer> stack = null;
	private ArrayList<Integer> min = null;
	private int top;
	private int size;
	private int mintop;

	public MinStack() {
		min = new ArrayList<Integer>();
		stack = new ArrayList<Integer>();
		top = -1;
		mintop = -1;
		size = 0;

	}

	public void push(int x) {
		stack.add(x);
		top++;
		size++;
		if (!min.isEmpty() && mintop != -1) {
			if (x <= (int) min.get(mintop)) {
				min.add(x);
				mintop++;
			}
		} else {
			min.add(x);
			mintop++;
		}

	}

	public void pop() {
		if (!stack.isEmpty()) {

			if (stack.get(top).equals(min.get(mintop))) {
				min.remove(mintop);
				mintop--;
			}

			stack.remove(top);

			top--;
			size--;

		}

	}

	public int top() {
		if (!stack.isEmpty())
			return stack.get(top);
		else
			return -1;

	}

	public int getMin() {
		if (!min.isEmpty())
			return min.get(mintop);
		else
			return stack.get(top);

	}

	public static void main(String[] args) {

		MinStack m = new MinStack();
		m.push(512);
		m.push(-1024);
		m.push(-1024);
		m.push(512);
		m.pop();
		m.getMin();
		m.pop();
		m.getMin();
		m.pop();
		m.getMin();

	}
}
