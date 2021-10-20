package com.graph.assignment;

import java.util.LinkedList;
import java.util.Queue;

// Leetcode 1730 (Subscribed)
// https://leetcode.ca/all/1730.html
// https://www.programmerall.com/article/86062239766
// Concept for direction : https://www.youtube.com/watch?v=KiCBXu4P-2Y William fiset
public class ShortestPathToGetFood {

	public static void main(String[] args) {

	}

	int[][] dirs = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

	public int getFood(char[][] grid) {

		int m = grid.length;
		int n = grid[0].length;

		Queue<int[]> q = new LinkedList<>();
		q.add(findStart(grid));

		boolean[][] visited = new boolean[m][n];

		int step = 0;
		while (!q.isEmpty()) {
			int len = q.size();
			for (int i = 0; i < len; i++) {
				int[] pos = q.poll();

				int x = pos[0];
				int y = pos[1];

				if (grid[x][y] == '#')
					return step;

				for (int[] dir : dirs) {
					int newX = x + dir[0];
					int newY = y + dir[1];

					if (isValid(grid, newX, newY) && !visited[newX][newY]) {
						visited[newX][newY] = true;
						q.offer(new int[] { newX, newY });
					}
				}
			}
			step++;
		}

		return -1;
	}

	private int[] findStart(char[][] grid) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '*') {
					return new int[] { i, j };
				}
			}
		}
		throw new RuntimeException();
	}

	private boolean isValid(char[][] grid, int i, int j) {
		return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] != 'X';
	}

}
