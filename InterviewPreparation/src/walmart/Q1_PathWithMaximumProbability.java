package walmart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

//1514. Path with Maximum Probability
//Self Dijkstra Algo
//Leetcode 1514. Path with Maximum Probability

public class Q1_PathWithMaximumProbability {

	public static void main(String[] args) {

	}

	public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {

		Map<Integer, List<Nod>> neighbors = new HashMap<>();

		for (int i = 0; i < n; i++) {
			neighbors.put(i, new ArrayList<>());
		}

		for (int i = 0; i < edges.length; i++) {

			int a = edges[i][0], b = edges[i][1];
			double p = succProb[i];
			// undirected graph
			neighbors.get(a).add(new Nod(b, p));
			neighbors.get(b).add(new Nod(a, p));
		}

		// For storing the result for the output
		Map<Integer, Double> res = new HashMap<>();

		// For checking the visited Nod
		boolean[] visited = new boolean[n];

		PriorityQueue<Nod> heap = new PriorityQueue<>((n1, n2) -> Double.compare(n2.prob, n1.prob));
		// The shortest path finds the nearest (smaller) point each time,
		// then the maximum prob is to find the largest value each time as the
		// confirmation (transit) point
		heap.add(new Nod(start, 1.0));
		while (!heap.isEmpty()) {
			Nod curr = heap.poll();
			// Ignoring if the Nod is already visited
			if (visited[curr.id]) {
				continue;
			}
			// Marking the Nod as visited
			visited[curr.id] = true;
			// Updating the res map
			res.put(curr.id, curr.prob);

			for (Nod next : neighbors.get(curr.id)) {
				double newProb = curr.prob * next.prob;
				if (newProb > res.getOrDefault(next.id, 0.0)) {
					res.put(next.id, newProb);
					heap.add(new Nod(next.id, newProb));
				}
			}

		}
		return res.getOrDefault(end, 0.0);
	}

}

class Nod {
	public int id;
	public double prob;

	public Nod(int id, double prob) {
		this.id = id;
		this.prob = prob;
	}
}