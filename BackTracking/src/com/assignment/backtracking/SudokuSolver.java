package com.assignment.backtracking;
//Leetcode 37. Sudoku Solver

import java.util.ArrayList;
import java.util.List;

// Ref: https://www.youtube.com/watch?v=FWAIf_EVUKE Take u forward

public class SudokuSolver {

	public static void main(String[] args) {
		char[][] board = new char[][] { { '.', '.', '.', '1', '.', '.', '8', '.', '7' },
				{ '.', '9', '.', '3', '.', '4', '6', '.', '.' }, { '.', '.', '.', '.', '8', '.', '.', '9', '3' },
				{ '5', '3', '.', '7', '.', '.', '.', '2', '.' }, { '.', '.', '2', '.', '6', '.', '9', '.', '.' },
				{ '.', '8', '.', '.', '.', '5', '.', '6', '4' }, { '6', '1', '.', '.', '7', '.', '.', '.', '.' },
				{ '.', '.', '3', '9', '.', '8', '.', '7', '.' }, { '8', '.', '7', '.', '.', '2', '.', '.', '.' } };

		solveSudoku(board);
		print(board, board.length);
	}

	public static void solveSudoku(char[][] board) {
		if (board == null || board.length == 0)
			return;
		solve(board);
	}

	public static boolean solve(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == '.') {
					for (char c = '1'; c <= '9'; c++) {// trial. Try 1 through 9
						if (isValid(board, i, j, c)) {
							board[i][j] = c; // Put c for this cell

							if (solve(board))
								return true; // If it's the solution return true
							else
								board[i][j] = '.'; // Otherwise go back
						}
					}

					return false;
				}
			}
		}
		return true;
	}

	private static boolean isValid(char[][] board, int row, int col, char c) {
		for (int i = 0; i < 9; i++) {
			if (board[i][col] != '.' && board[i][col] == c)
				return false; // check row
			if (board[row][i] != '.' && board[row][i] == c)
				return false; // check column
			if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] != '.'
					&& board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c)
				return false; // check 3*3 block
		}
		return true;
	}

	public static List<List<Character>> print(char[][] board, int n) {
		List<List<Character>> res = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			List<Character> list = new ArrayList<>();
			for (int j = 0; j < n; j++) {
				list.add(board[i][j]);
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
			res.add(list);
		}
		return res;
	}

}
