package com.assignment.backtracking;

import java.util.HashSet;
import java.util.Set;

// Leetcode 79. Word Search
//Ref: https://www.youtube.com/watch?v=pfiQ_PS1g8E NeetCode
//TC: O(n . m . 4^(len of word)

public class WordSearch {

	public static void main(String[] args) {
		char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
		String word = "ABCCED";
		boolean isPresent = exist(board, word);
		System.out.println(isPresent);
	}

	public static boolean exist(char[][] board, String word) {
		int row = board.length;
		int col = board[0].length;

		Set<String> pathSet = new HashSet<>();
		int idx = 0;

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (dfs(i, j, idx, pathSet, word, board)) {
					return true;
				}
			}
		}

		return false;
	}

	private static boolean dfs(int row, int col, int idx, Set<String> pathSet, String word, char[][] board) {
		if (idx == word.length())
			return true;

		String path = "row_" + row + "col_" + col;

		if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || word.charAt(idx) != board[row][col]
				|| pathSet.contains(path)) {
			return false;
		}

		pathSet.add(path);
		boolean res = dfs(row + 1, col, idx + 1, pathSet, word, board)
				|| dfs(row - 1, col, idx + 1, pathSet, word, board) || dfs(row, col + 1, idx + 1, pathSet, word, board)
				|| dfs(row, col - 1, idx + 1, pathSet, word, board);

		pathSet.remove(path);
		return res;
	}

}
