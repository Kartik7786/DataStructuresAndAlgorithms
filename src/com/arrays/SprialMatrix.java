package com.arrays;

import java.util.ArrayList;
import java.util.List;

public class SprialMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> result = new ArrayList<>();
		if (matrix == null || matrix.length == 0)
			return result;
		int row = 0;
		int col = 0;
		int rowlen = matrix.length - 1;
		int collen = matrix[0].length - 1;
		while (row <= rowlen && col <= collen) {
			for (int i = col; i <= collen; i++) {
				result.add(matrix[row][i]);
			}
			row++;
			for (int j = row; j <= rowlen; j++) {
				result.add(matrix[j][collen]);
			}
			collen--;
			if (rowlen >= row) {
				for (int j = collen; j >= col; j--) {
					result.add(matrix[rowlen][j]);
				}
				rowlen--;
			}
			if (collen >= col) {
				for (int j = rowlen; j >= row; j--) {
					result.add(matrix[j][col]);
				}
				col++;
			}

		}
		return result;
	}
}
