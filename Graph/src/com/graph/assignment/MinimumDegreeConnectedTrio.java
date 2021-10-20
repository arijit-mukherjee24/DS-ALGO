package com.graph.assignment;
// Ref: https://leetcode.com/problems/minimum-degree-of-a-connected-trio-in-a-graph/discuss/1064628/Java-Short-O(N3)-Solution

// Leetcode 1761. Minimum Degree of a Connected Trio in a Graph
// Ref : https://www.youtube.com/watch?v=EFTl6gLvaNs  Cherry  Coding       -- Concept Understading

public class MinimumDegreeConnectedTrio {

	public static void main(String[] args) {
		int[][] edges = {{1,2},{1,3},{3,2},{4,1},{5,2},{3,6}};
		int n = 6;
		int ans = minTrioDegree(n, edges);
		System.out.println(ans);
	}

	public static int minTrioDegree(int n, int[][] edges) {
		int min = Integer.MAX_VALUE;
		// Map<Integer, Integer> degrees = new HashMap<>(); // vertex, degree
		int[] degrees = new int[n + 1];
		boolean[][] isEdge = new boolean[n + 1][n + 1]; // node staring at 1

		for (int[] edge : edges) {
			// degrees.put(edge[0], degrees.getOrDefault(edge[0], 0) + 1);
			// degrees.put(edge[1], degrees.getOrDefault(edge[1], 0) + 1);
			degrees[edge[0]]++;
			degrees[edge[1]]++;
			isEdge[edge[0]][edge[1]] = true;
			isEdge[edge[1]][edge[0]] = true;
		}

		for (int[] edge : edges) {
			for (int i = 1; i <= n; i++) {
				if (isEdge[i][edge[0]] && isEdge[i][edge[1]]) {
					// subtract 6 because we do not count inner edges of a trio
					// int degree = degrees.get(i) + degrees.get(edge[0]) + degrees.get(edge[1]) -
					// 6;
					int degree = degrees[i] + degrees[edge[0]] + degrees[edge[1]] - 6;
					min = Math.min(min, degree);
				}
			}
		}

		if (min == Integer.MAX_VALUE)
			return -1;
		return min;
	}

}
