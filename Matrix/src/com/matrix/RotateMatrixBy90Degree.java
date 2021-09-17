package com.matrix;
//Ref: https://www.youtube.com/watch?v=Y72QeX0Efxw Take u forward
//https://www.techiedelight.com/place-rotate-matrix-90-degrees-clock-wise-direction/

// Leetcode 48. Rotate Image

public class RotateMatrixBy90Degree {

	public static void main(String[] args) {
		int matrix[][]= { {1,2,3}, {4,5,6}, {7,8,9} };
		rotate(matrix);
	}

	public static void rotate(int[][] matrix) {

		// base case
		if (matrix == null || matrix.length == 0)
			return;

		int row = matrix.length;
		int col = matrix[0].length;

		// transpose
		for (int i = 0; i < row; i++) {
			// here j starts with same value as i, as transpose is a diagonal flip of the
			// matrix
			for (int j = i; j < col; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}

		// swap columns
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length / 2; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[i][matrix[0].length - 1 - j];
				matrix[i][matrix[0].length - 1 - j] = temp;
			}
		}

	}

}
