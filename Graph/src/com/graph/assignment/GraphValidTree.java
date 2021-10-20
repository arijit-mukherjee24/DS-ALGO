package com.graph.assignment;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

// Lintcode 178 · Graph Valid Tree - LintCode
//Refer : GFG Solution + GFG Video
public class GraphValidTree {

	public static void main(String[] args) {

	}

	/**
	 * @param n:     An integer
	 * @param edges: a list of undirected edges
	 * @return: true if it's a valid tree, or false
	 */
	public boolean validTree(int n, int[][] edges) {
		LinkedList<Integer>[] adj = new LinkedList[n];

		for (int i = 0; i < n; i++) {
			adj[i] = new LinkedList<Integer>();
		}

		for (int[] edge : edges) {
			adj[edge[0]].add(edge[1]);
			adj[edge[1]].add(edge[0]);
		}

		boolean visited[] = new boolean[n];
		Arrays.fill(visited, false);

		// The call to isCyclicUtil serves multiple purposes
		// It returns true if graph reachable from vertex 0
		// is cyclcic. It also marks all vertices reachable
		// from 0.
		if (isCyclicUtil(0, adj, visited, -1))
			return false;

		// If we find a vertex which is not reachable from 0
		// (not marked by isCyclicUtil(), then we return false
		for (int u = 0; u < n; u++)
			if (!visited[u])
				return false;

		return true;
	}

	private boolean isCyclicUtil(int v, LinkedList<Integer>[] adj, boolean[] visited, int parent) {
		visited[v] = true;
		Integer i;
		// Recur for all the vertices adjacent to this vertex
		Iterator<Integer> it = adj[v].iterator();
		while (it.hasNext()) {
			i = it.next();
			// If an adjacent is not visited, then recur for
			// that adjacent
			if (!visited[i]) {
				if (isCyclicUtil(i, adj, visited, v))
					return true;
			}
			// If an adjacent is visited and not parent of
			// current vertex, then there is a cycle.
			else if (i != parent)
				return true;
		}
		return false;
	}

}
