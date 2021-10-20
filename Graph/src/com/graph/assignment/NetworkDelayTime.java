package com.graph.assignment;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

//Ref: https://www.youtube.com/watch?v=YHx6r9pM5e0 Techdose
//Take U forward Impl of Dijkstra's Algo: https://github.com/striver79/StriversGraphSeries/blob/main/djisktraJava
// Leetcode 743. Network Delay Time

public class NetworkDelayTime {

	public static void main(String[] args) {

	}

	int[] dist;

	// driver function
	public int networkDelayTime(int[][] times, int n, int k) {
		int max = 0;
		ArrayList<ArrayList<Nodeco>> adj = new ArrayList<ArrayList<Nodeco>>();

		for (int i = 0; i <= n; i++)
			adj.add(new ArrayList<Nodeco>());

		for (int[] time : times) {
			adj.get(time[0]).add(new Nodeco(time[1], time[2]));
		}

		shortestPath(k, adj, n);
		for (int i = 1; i <= n; i++) {
			if (dist[i] == Integer.MAX_VALUE)
				return -1;
			else if (max < dist[i])
				max = dist[i];
		}

		return max;
	}

	private void shortestPath(int s, ArrayList<ArrayList<Nodeco>> adj, int N) {
		dist = new int[N + 1];

		for (int i = 0; i <= N; i++)
			dist[i] = Integer.MAX_VALUE;

		dist[s] = 0;

		PriorityQueue<Nodeco> pq = new PriorityQueue<Nodeco>(N + 1, new Nodeco());
		pq.add(new Nodeco(s, 0));

		while (pq.size() > 0) {
			Nodeco Nodeco = pq.poll();

			for (Nodeco it : adj.get(Nodeco.getV())) {
				if (dist[Nodeco.getV()] + it.getWeight() < dist[it.getV()]) {
					dist[it.getV()] = dist[Nodeco.getV()] + it.getWeight();
					pq.add(new Nodeco(it.getV(), dist[it.getV()]));
				}
			}
		}

		System.out.print("Distance Array ");
		for (int i = 1; i <= N; i++) {
			System.out.print(dist[i] + " ");
		}
	}

}

// Change Nodeco to Node ^-^
class Nodeco implements Comparator<Nodeco> {
	private int v;
	private int weight;

	Nodeco(int _v, int _w) {
		v = _v;
		weight = _w;
	}

	Nodeco() {
	}

	int getV() {
		return v;
	}

	int getWeight() {
		return weight;
	}

	@Override
	public int compare(Nodeco Nodeco1, Nodeco Nodeco2) {
		if (Nodeco1.weight < Nodeco2.weight)
			return -1;
		if (Nodeco1.weight > Nodeco2.weight)
			return 1;
		return 0;
	}
}
