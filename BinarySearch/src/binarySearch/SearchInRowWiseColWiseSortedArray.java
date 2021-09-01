package binarySearch;
// https://www.callicoder.com/binary-search-row-wise-column-wise-sorted-matrix/
class SearchInRowWiseColWiseSortedArray {
	private static int[] search(int[][] matrix, int target) {
		if (matrix.length == 0) {
			return new int[] { -1, -1 };
		}

		int numRows = matrix.length;
		int numCols = matrix[0].length;

		int i = 0;
		int j = numCols - 1;

		while (i >= 0 && i < numRows && j >= 0 && j < numCols) {
			if (target == matrix[i][j]) {
				return new int[] { i, j };
			} else if (target < matrix[i][j]) {
				j--;
			} else {
				i++;
			}
		}

		return new int[] { -1, -1 };
	}

    public static void main(String[] args) {
        int[][] matrix = { 
            { 10, 20, 30, 40 }, 
            { 15, 25, 35, 45 }, 
            { 27, 29, 37, 48 }, 
            { 32, 33, 39, 50 } 
        };

		int target = 29;

		int[] result = search(matrix, target);

		if (result[0] != -1 && result[1] != -1) {
			System.out.printf("%d is found at (%d, %d)%n", target, result[0], result[1]);
		} else {
			System.out.printf("Element not found");
		}
    }
}