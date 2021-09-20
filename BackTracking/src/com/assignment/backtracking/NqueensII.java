package com.assignment.backtracking;

//Leetcode 52. N-Queens II
//Ref: https://www.youtube.com/watch?v=i05Ju7AftcM Take u forward
//https://github.com/striver79/SDESheet/blob/main/NQueenEfficientJava Efficient solution

public class NqueensII {

	public static void main(String[] args) {
		int n = 4;
		int res = totalNQueens(n);
		System.out.println(res);
	}

	static int count = 0;

	public static int totalNQueens(int n) {
		char[][] board = new char[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				board[i][j] = '.';

		int leftRow[] = new int[n];
		int upperDiagonal[] = new int[2 * n - 1];
		int lowerDiagonal[] = new int[2 * n - 1];
		solve(0, board, leftRow, lowerDiagonal, upperDiagonal);
		return count;
	}

	private static void solve(int col, char[][] board, int leftRow[], int lowerDiagonal[], int upperDiagonal[]) {
		if (col == board.length) {
			count++;
			return;
		}

		for (int row = 0; row < board.length; row++) {
			// row = 0 && row+col == 0 && n-1 + col- row==0
			if (leftRow[row] == 0 && lowerDiagonal[row + col] == 0
					&& upperDiagonal[board.length - 1 + col - row] == 0) {
				board[row][col] = 'Q';
				leftRow[row] = 1;
				lowerDiagonal[row + col] = 1;
				upperDiagonal[board.length - 1 + col - row] = 1;
				solve(col + 1, board, leftRow, lowerDiagonal, upperDiagonal);
				board[row][col] = '.';
				leftRow[row] = 0;
				lowerDiagonal[row + col] = 0;
				upperDiagonal[board.length - 1 + col - row] = 0;
			}
		}
	}

}
