package com.arrays;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

	Queue<int[]> q = new LinkedList<>();
	int freshoranges = 0;
	int row = 0;
	int col = 0;
	int timestamp = 0;
	boolean flag = false;

	public int orangesRotting(int[][] grid) {

		row = grid.length;
		col = grid[0].length;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 2) {
					int[] arr = new int[2];
					arr[0] = i;
					arr[1] = j;
					q.add(arr);
				}
				if (grid[i][j] == 1) {
					freshoranges++;
				}

			}

		}

		while (!q.isEmpty()) {
			int size = q.size();

			for (int k = 0; k < size; k++) {

				int[] arr = q.poll();
				int x = arr[0];
				int y = arr[1];
				helper(x, y, grid);

			}
			if (flag)
				timestamp++;
			flag = false;
			
			
			if (freshoranges <= 0)
				break;

		}
		if (freshoranges > 0)
			return -1;

		return timestamp;
	}

	public void helper(int x, int y, int[][] grid) {

		if (x - 1 >= 0 && y >= 0 && x - 1 < row && y < col && grid[x - 1][y] == 1) {
			flag = true;
			grid[x - 1][y] = 2;
			int rot[] = new int[2];
			rot[0] = x - 1;
			rot[1] = y;
			q.add(rot);
			freshoranges--;
		}

		if (x + 1 >= 0 && y >= 0 && x + 1 < row && y < col && grid[x + 1][y] == 1) {
			flag = true;
			grid[x + 1][y] = 2;
			int rot[] = new int[2];
			rot[0] = x + 1;
			rot[1] = y;
			q.add(rot);
			freshoranges--;
		}

		if (x >= 0 && y - 1 >= 0 && x < row && y - 1 < col && grid[x][y - 1] == 1) {
			flag = true;
			grid[x][y - 1] = 2;
			int rot[] = new int[2];
			rot[0] = x;
			rot[1] = y - 1;
			q.add(rot);
			freshoranges--;
		}

		if (x >= 0 && y + 1 >= 0 && x < row && y + 1 < col && grid[x][y + 1] == 1) {
			flag = true;
			grid[x][y + 1] = 2;
			int rot[] = new int[2];
			rot[0] = x;
			rot[1] = y + 1;
			q.add(rot);
			freshoranges--;
		}

	}
}