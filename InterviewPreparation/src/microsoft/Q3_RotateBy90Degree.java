package microsoft;

// https://practice.geeksforgeeks.org/problems/rotate-by-90-degree0356/1/

// Rotate by 90 degree
public class Q3_RotateBy90Degree {

	public static void main(String[] args) {

	}

	static void rotate(int matrix[][]) {
		// base case
		if (matrix == null || matrix.length == 0)
			return;

		int row = matrix.length;
		int col = matrix[0].length;

		// transpose of the matrix - rows and cols get interchanged
		for (int i = 0; i < row; i++) {
			for (int j = i; j < col; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}

		// swap rows
		for (int i = 0; i < row / 2; i++) {
			for (int j = 0; j < col; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[row - 1 - i][j];
				matrix[row - 1 - i][j] = temp;
			}
		}

	}

}
