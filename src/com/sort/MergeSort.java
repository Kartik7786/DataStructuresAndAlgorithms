package com.sort;

public class MergeSort {

	public static void mergesort(int[] arr, int low, int high) {

		if (low < high) {
			int mid = (low + high) / 2;

			mergesort(arr, low, mid);
			mergesort(arr, mid + 1, high);
			merge(arr, low, mid, high);
		}

	}

	public static void merge(int[] arr, int low, int mid, int high) {
		int k = 0;
		int[] merge = new int[high - low + 1];
		int[] l1 = new int[mid - low + 1];
		int[] l2 = new int[high - mid];
		int m = 0;
		for (int i = low; i <= mid; i++) {
			l1[m++] = arr[i];
		}
		int n = 0;
		for (int i = mid + 1; i <= high; i++) {
			l2[n++] = arr[i];
		}

		int x = 0, y = 0;

		while (x < l1.length && y < l2.length) {

			if (l1[x] < l2[y]) {
				merge[k++] = l1[x++];
			} else {
				merge[k++] = l2[y++];
			}
		}

		while (x < l1.length) {

			merge[k++] = l1[x++];

		}

		while (y < l2.length) {

			merge[k++] = l2[y++];

		}
		int z = 0;

		for (int i = low; i <= high; i++) {
			arr[i] = merge[z++];
		}

	}

	public static void main(String[] args) {

		int[] arr = { 2, 4, 1, 5, 6, 8, 3, 0, 9 };
		mergesort(arr, 0, arr.length - 1);
	}
}
