package com.graph.assignment;
// Leetcode 1102 Path With Maximum Minimum Value (Subscribed)

import java.util.PriorityQueue;

// https://leetcode.ca/all/1102.html
// https://www.programmerall.com/article/5591728512/

// Time: O(M * N * log(M * N)) BFS
public class PathWithMaximumMinimumValue {

	public static void main(String[] args) {

	}

	int[][] directions = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	int ROW;
	int COL;

	public int maximumMinimumPath(int[][] A) {
		ROW = A.length;
		COL = A[0].length;
		boolean[][] visited = new boolean[ROW][COL];
		int minValue = A[0][0];
		// find the max value for the nearby cells
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[2] - a[2]);
		pq.offer(new int[] { 0, 0, A[0][0] });
		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			int curRow = cur[0];
			int curCol = cur[1];
			minValue = Math.min(minValue, cur[2]);
			if (curRow == ROW - 1 && curCol == COL - 1) {
				break;
			}
			for (int[] dir : directions) {
				int nextRow = curRow + dir[0];
				int nextCol = curCol + dir[1];
				if (nextRow < 0 || nextRow >= ROW || nextCol < 0 || nextCol >= COL || visited[nextRow][nextCol]) {
					continue;
				}
				pq.offer(new int[] { nextRow, nextCol, A[nextRow][nextCol] });
				visited[nextRow][nextCol] = true;
			}
		}
		return minValue;
	}

}
