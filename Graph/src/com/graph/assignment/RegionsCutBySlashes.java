package com.graph.assignment;
// Ref: https://www.youtube.com/watch?v=Wafu5vOxPRE Pepcoding

// Leetcode 959. Regions Cut By Slashes

public class RegionsCutBySlashes {
	int[] parent;
	int[] rank;
	int count;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// driver function
	public int regionsBySlashes(String[] grid) {
		int n = grid.length;
		int dots = n + 1;

		parent = new int[dots * dots];
		rank = new int[dots * dots];
		count = 1;

		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
			rank[i] = 0;
		}

		for (int i = 0; i < dots; i++) {
			for (int j = 0; j < dots; j++) {
				if (i == 0 || j == 0 || i == dots - 1 || j == dots - 1) {
					int ceilno = i * dots + j;
					// making boundary set just like connecting
					// the boundary in dots*dots matrix with 0
					if (ceilno != 0) // neglecting union with 0, otherwise count will be extra
						union(0, ceilno);
				}
			}
		}

		for (int i = 0; i < grid.length; i++) {
			char[] ch = grid[i].toCharArray();
			for (int j = 0; j < ch.length; j++) {
				if (ch[j] == '/') {
					int ceilno1 = i * dots + (j + 1);
					int ceilno2 = (i + 1) * dots + j;

					union(ceilno1, ceilno2);

				} else if (ch[j] == '\\') {
					int ceilno1 = i * dots + j;
					int ceilno2 = (i + 1) * dots + (j + 1);

					union(ceilno1, ceilno2);
				}
			}
		}

		return count;
	}

	// for finding the parent of the given point
	private int find(int x) {
		if (parent[x] == x)
			return x;

		// here, we are doing path compression for optimization
		return parent[x] = find(parent[x]);
	}

	// for the union of two points
	private void union(int x, int y) {
		int lx = find(x);
		int ly = find(y);

		if (lx != ly) {
			if (lx < ly) {
				parent[lx] = ly;
			} else if (ly < lx) {
				parent[ly] = lx;
			} else {
				parent[lx] = ly;
				rank[ly]++;
			}
		} else {
			// If both the points belong to the same set, then the union
			// o/p will formed a cycle, thus adding a new region, as adding
			// new cycle contribute to addition of a new region. So the count
			// increases by 1 with each cycle formation.
			count++;
		}
	}

}
