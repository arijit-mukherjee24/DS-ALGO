package com.graph.assignment;

import java.util.ArrayList;
import java.util.Arrays;

// Leetcode 886. Possible Bipartition
// Ref: https://www.youtube.com/watch?v=hWFqtlbnQV8 Knowledge Center
public class PossibleBipartition {

	public static void main(String[] args) {
		int n = 4;
		int[][] dislikes = { { 1, 2 }, { 1, 3 }, { 2, 4 } };
		System.out.println(possibleBipartition(n, dislikes));
	}

	public static boolean possibleBipartition(int n, int[][] dislikes) {
		int[] groups = new int[n];
		Arrays.fill(groups, -1);

		ArrayList<Integer>[] adj = new ArrayList[n];

		for (int i = 0; i < n; i++)
			adj[i] = new ArrayList();

		for (int[] p : dislikes) {
			adj[p[0] - 1].add(p[1] - 1);
			adj[p[1] - 1].add(p[0] - 1);
		}

		for (int i = 0; i < n; i++) {
			if (groups[i] == -1 && !dfs(adj, groups, i, 0))
				return false;
		}
		return true;
	}

	private static boolean dfs(ArrayList<Integer>[] adj, int[] groups, int v, int grp) {
		if (groups[v] == -1)
			groups[v] = grp;
		else
			return groups[v] == grp;

		for (int n : adj[v]) {
			if (!dfs(adj, groups, n, 1 - grp))
				return false;
		}
		return true;
	}

}
