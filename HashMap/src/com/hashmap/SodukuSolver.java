package com.hashmap;

import java.util.ArrayList;
import java.util.List;

//Ref: https://www.youtube.com/watch?v=MHXR4PCY8c0 Anuj Bhaiya
// GFG: https://www.geeksforgeeks.org/sudoku-backtracking-7/
// Leetcode 37. Sudoku Solver
public class SodukuSolver {

	public static void main(String[] args) {
		/*char[][] board = new char[][] { 
			{ '5', '3', '.', '.', '7', '.', '.', '.', '.' },
			{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, 
			{ '.', '9', '8', '.', '.', '.', '.', '6', '.' },
			{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, 
			{ '4', '.', '.', '8', '.', '3', '.', '.', '1' },
			{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, 
			{ '.', '6', '.', '.', '.', '.', '2', '8', '.' },
			{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, 
			{ '.', '.', '.', '.', '8', '.', '.', '7', '9' } };*/
		
		char[][] board = new char[][] { 
			{ '.', '.', '.', '1', '.', '.', '8', '.', '7' },
			{ '.', '9', '.', '3', '.', '4', '6', '.', '.' }, 
			{ '.', '.', '.', '.', '8', '.', '.', '9', '3' },
			{ '5', '3', '.', '7', '.', '.', '.', '2', '.' }, 
			{ '.', '.', '2', '.', '6', '.', '9', '.', '.' },
			{ '.', '8', '.', '.', '.', '5', '.', '6', '4' }, 
			{ '6', '1', '.', '.', '7', '.', '.', '.', '.' },
			{ '.', '.', '3', '9', '.', '8', '.', '7', '.' }, 
			{ '8', '.', '7', '.', '.', '2', '.', '.', '.' } };
		
			
		if (solveSudoku(board)) {
			print(board, board.length);
		}
			
	}

	public static  boolean solveSudoku(char[][] board) {
		int n = board.length;
		boolean isSolved = solveSudokuBackTrack(board, n);
		return isSolved;
		 
	}

	public static boolean solveSudokuBackTrack(char[][] board, int n) {
		int row = -1;
		int column = -1;
		boolean isEmpty = true;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == '.') {
					row = i;
					column = j;
					isEmpty = false;
					break;
				}
			}
			if (!isEmpty)
				break;
		}

		// No empty space left
		if (isEmpty) {
			return true;
		}

		// Else for each-row backtrack
		for (char num = '1'; num <= '9'; num++) {
			if (isSafe(board, row, column, num)) {
				board[row][column] = num;
				if (solveSudokuBackTrack(board, n)) {
					// print(board, n);
					return true;
				} else {
					// replace it
					board[row][column] = '.';
				}
			}
		}
		return false;
	}

	public static boolean isSafe(char[][] board, int row, int col, int num) {
		// Row has the unique (row-clash)
		for (int d = 0; d < board.length; d++) {
			// Check if the number we are trying to
			// place is already present in
			// that row, return false;
			if (board[row][d] == (char) num) {
				return false;
			}
		}

		// Column has the unique numbers (column-clash)
		for (int r = 0; r < board.length; r++) {
			// Check if the number
			// we are trying to
			// place is already present in
			// that column, return false;
			if (board[r][col] == (char) num) {
				return false;
			}
		}

		// Corresponding square has
		// unique number (box-clash)
		int sqrt = (int) Math.sqrt(board.length);
		int boxRowStart = row - row % sqrt;
		int boxColStart = col - col % sqrt;

		for (int r = boxRowStart; r < boxRowStart + sqrt; r++) {
			for (int d = boxColStart; d < boxColStart + sqrt; d++) {
				if (board[r][d] == (char) num) {
					return false;
				}
			}
		}

		// if there is no clash, it's safe
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
