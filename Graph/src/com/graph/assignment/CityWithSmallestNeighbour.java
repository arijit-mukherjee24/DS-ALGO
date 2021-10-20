package com.graph.assignment;
// Leetcode 1334. Find the City With the Smallest Number of Neighbors at a Threshold Distance

import java.util.Arrays;

//Ref: Floyd Warshal Algo - Techdose / Abdul Bari
//https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/discuss/491446/JavaC%2B%2B-Floyd-Warshall's-shortest-path-algorithm-Clean-code

public class CityWithSmallestNeighbour {

	public static void main(String[] args) {
		
	}

	public int findTheCity(int n, int[][] edges, int distanceThreshold) {
		int INF = (int) 1e6; // INF = n * maxWeight = 100 * 10^4 = 10^6

		int dist[][] = new int[n][n]; // dist[i][j] is the minimum distance from i to j

		// initialization
		for (int i = 0; i < n; i++) {
			Arrays.fill(dist[i], INF);
			dist[i][i] = 0; // self loop is initialized as 0
		}

		for (int[] edge : edges) {
			int u = edge[0], v = edge[1], w = edge[2];
			dist[u][v] = dist[v][u] = w;
		}

		// Floyd Warshall's shortest path algorithm
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (dist[i][k] == INF || dist[k][j] == INF)
						continue;

					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}

		int minReachable = n, ans = 0;
		for (int i = 0; i < n; i++) {
			int reachable = 0;
			for (int j = 0; j < n; j++) {
				if (dist[i][j] <= distanceThreshold)
					reachable++;
			}
			if (reachable <= minReachable) {
				minReachable = reachable;
				ans = i;
			}
		}

		return ans;
	}

}
