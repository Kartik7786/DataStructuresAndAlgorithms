package com.heap;

import java.util.ArrayList;

public class MaxHeap {

	ArrayList<Integer> heap;

	MaxHeap() {
		heap = new ArrayList<Integer>();
	}

	public void insert(int val) {
		heap.add(val);
		int temp = heap.size() - 1;

		while (temp > 0) {
			if (heap.get(temp) > heap.get((temp - 1) / 2)) {
				int childelement = heap.get(temp);
				int parentelement = heap.get((temp - 1) / 2);
				heap.set(temp, parentelement);
				heap.set((temp - 1) / 2, childelement);
				temp = (temp - 1) / 2;
			} else
				break;

		}

	}

	public int delete() {
		if (heap.size() > 0) {
			int top = heap.get(0);
			int size = heap.size();
			int bottom = heap.get(size - 1);

			heap.set(0, bottom);
			heap.remove(size - 1);
			size = heap.size();

			int i = 0;
			while (i < heap.size()) {
				int left = 2 * i + 1;
				int right = 2 * i + 2;

				if (left < size && right < size && heap.get(left) > heap.get(right) && heap.get(i) < heap.get(left)) {

					int temp = heap.get(i);
					heap.set(i, heap.get(left));
					heap.set(left, temp);
					i = left;

				} else if (left < size && right < size && heap.get(right) > heap.get(left)
						&& heap.get(i) < heap.get(right)) {
					int temp = heap.get(i);
					heap.set(i, heap.get(right));
					heap.set(right, temp);
					i = right;
				} else if (left < size && heap.get(i) < heap.get(left)) {
					int temp = heap.get(i);
					heap.set(i, heap.get(left));
					heap.set(left, temp);
					i = left;
				} else
					break;
			}

			return top;
		}

		else
			return Integer.MIN_VALUE;
	}

	public void getHeap() {
		for (int i : heap)
			System.out.print(i + " ->");
	}

	public static void main(String[] args) {
		MaxHeap h = new MaxHeap();

		h.insert(30);
		h.insert(20);
		h.insert(15);
		h.insert(5);
		h.insert(10);
		h.insert(12);
		h.insert(6);
		h.insert(40);
		h.getHeap();
		h.delete();
		h.getHeap();
	}
}
