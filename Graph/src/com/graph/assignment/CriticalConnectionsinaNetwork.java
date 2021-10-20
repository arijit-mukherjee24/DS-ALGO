package com.graph.assignment;
// Leetcode 1192. Critical Connections in a Network

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Techdose : https://www.youtube.com/watch?v=Rhxs4k6DyMM Find Bridges in a graph using Tarjans Algorithm | Cut Edge
//Ref: https://www.youtube.com/watch?v=HsBefuOqkd4
//https://gist.github.com/SuryaPratapK/36ae25dfb8a43af1834435486784520d
public class CriticalConnectionsinaNetwork {

	public static void main(String[] args) {

	}

	List<List<Integer>> adj;
	int time = 0; // timestamp

	void DFS(int u, int[] disc, int[] low, int[] parent, List<List<Integer>> bridges) {
		disc[u] = low[u] = time;
		time += 1;

		for (int v : adj.get(u)) {
			if (disc[v] == -1) // If v is not visited
			{
				parent[v] = u;
				DFS(v, disc, low, parent, bridges);
				low[u] = Math.min(low[u], low[v]);

				if (low[v] > disc[u])
					bridges.add(Arrays.asList(u, v));
			} else if (v != parent[u]) // Check for back edge as well as cross edges
				low[u] = Math.min(low[u], disc[v]);
		}
	}

	// Find bridges using Tarjan's Algorithm
	private void findBridges_Tarjan(int V, List<List<Integer>> bridges) {
		int[] parent = new int[V];
		int[] disc = new int[V];
		int[] low = new int[V];

		Arrays.fill(parent, -1);
		Arrays.fill(disc, -1);
		Arrays.fill(low, -1);

		// Apply DFS for each component
		for (int i = 0; i < V; i++)
			if (disc[i] == -1)
				DFS(i, disc, low, parent, bridges);
	}

	// driver function
	public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
		adj = new ArrayList<List<Integer>>(n);

		List<List<Integer>> bridges = new ArrayList<List<Integer>>(); // Store all the bridges

		for (int i = 0; i < n; i++) { // Make Adj list
			adj.add(new ArrayList());
		}

		for (int i = 0; i < connections.size(); i++) {
			List<Integer> connection = connections.get(i);
			adj.get(connection.get(0)).add(connection.get(1)); // undirected nodes
			adj.get(connection.get(1)).add(connection.get(0));
		}

		findBridges_Tarjan(n, bridges);

		return bridges;
	}

}
