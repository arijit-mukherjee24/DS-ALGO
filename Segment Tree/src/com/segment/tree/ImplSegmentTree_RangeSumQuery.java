package com.segment.tree;
// Ref: https://www.youtube.com/watch?v=2bSS8rtFym4&list=PLEJXowNB4kPxiWkLPP7b4D9761SEhyEzm + Classwork Techdose
// Construct Operation : O(n) as there are 2*N - 1 nodes (N-1 Internal Nodes and N leaf Nodes)
// Query: O(logn) as we need to traverse the height of the tree
// Update: O(logn) as we need to traverse the height of the tree

/* Segment Tree is a Full Binary Tree Internal Nodes have 0 or 2 children. & all levels till 2nd last level is completely filled)
 * It is useful only if updates are frequent, otherwise use array.
 * 
 * Comaparison:-
 * Brute Force:  Q query time: O(N.Q)			U update time: O(U)
 * 
 * Array:  		 Q query time: O(Q)				U update time: O(N.U)
 * 
 * Segment Tree: Q query time: O(QlogN)			U update time: O(UlogN)
 */

public class ImplSegmentTree_RangeSumQuery {

	public static int[] st;

	public static void main(String[] args) {
		int n = 6;
		int[] arr = { 1, 3, 2, -2, 4, 5 };

		int size = 4 * n + 1;
		st = new int[size];

		int st_idx = 1;// start Index of SegTree
		int start = 0, end = n - 1;

		// Preprocess
		buildSegTree(st_idx, arr, start, end);

		System.out.println("The segment tree is: ");
		for (int i = 0; i <= 4 * n; i++) {
			System.out.print(st[i] + " ");
		}
		System.out.println();

		System.out.println("Query is 0-based indexed");
		System.out.println("RangeSum(2,4): " + query(2, 4, st_idx, start, end));
		System.out.println("RangeSum(1,4): " + query(1, 4, st_idx, start, end));
		System.out.println("RangeSum(3,3): " + query(3, 3, st_idx, start, end));

		arr[1] = 100;
		updateNode(st_idx, start, end, 1, 100);

		System.out.println("After update, the segment tree is: ");
		for (int i = 0; i <= 4 * n; i++) {
			System.out.print(st[i] + " ");
		}
		System.out.println();

		System.out.println("Query is 0-based indexed");
		System.out.println("Updated RangeSum(2,4): " + query(2, 4, st_idx, start, end));
		System.out.println("Updated RangeSum(1,4): " + query(1, 4, st_idx, start, end));
		System.out.println("Updated RangeSum(1,1): " + query(1, 1, st_idx, start, end));
		System.out.println("Updated RangeSum(2,2): " + query(2, 2, st_idx, start, end));
		System.out.println("Updated RangeSum(3,3): " + query(3, 3, st_idx, start, end));
		System.out.println("Updated RangeSum(4,4): " + query(4, 4, st_idx, start, end));

	}

	private static void updateNode(int st_idx, int start, int end, int pos, int newValue) {
		if (start > pos || end < pos) // Invalid Case (No Overlap)
			return;
		if (start == end) {// LeafNode Case (Total Overlap)
			st[st_idx] = newValue;
			return;
		}

		// InternalNode Case (Partial Overlap)
		int middle = start + (end - start) / 2;
		updateNode(2 * st_idx, start, middle, pos, newValue);
		updateNode(2 * st_idx + 1, middle + 1, end, pos, newValue);
		st[st_idx] = st[2 * st_idx] + st[2 * st_idx + 1];
	}

	// getSum of a particular range
	private static int query(int qs, int qe, int st_idx, int start, int end) {
		if (qs > end || qe < start)// No overlap
			return 0;
		if (start >= qs && end <= qe)// Total Overlap
			return st[st_idx];

		// Partital Overlap Case
		int middle = start + (end - start) / 2;
		int leftSum = query(qs, qe, 2 * st_idx, start, middle);
		int rightSum = query(qs, qe, 2 * st_idx + 1, middle + 1, end);
		return leftSum + rightSum;
	}

	// constructing the segment tree
	private static void buildSegTree(int st_idx, int[] arr, int start, int end) {
		if (start > end)// Invalid Case
			return;
		if (start == end) {// LeafNode Case
			st[st_idx] = arr[start];
			return;
		}

		// InternalNode Case: 1 based indexing used
		int middle = start + (end - start) / 2;
		buildSegTree(2 * st_idx, arr, start, middle);
		buildSegTree(2 * st_idx + 1, arr, middle + 1, end);
		st[st_idx] = st[2 * st_idx] + st[2 * st_idx + 1];
	}

}

/* output : 
The segment tree is: 
0 13 6 7 4 2 2 5 1 3 0 0 -2 4 0 0 0 0 0 0 0 0 0 0 0 
Query is 0-based indexed
RangeSum(2,4): 4
RangeSum(1,4): 7
RangeSum(3,3): -2
After update, the segment tree is: 
0 110 103 7 101 2 2 5 1 100 0 0 -2 4 0 0 0 0 0 0 0 0 0 0 0 
Query is 0-based indexed
Updated RangeSum(2,4): 4
Updated RangeSum(1,4): 104
Updated RangeSum(1,1): 100
Updated RangeSum(2,2): 2
Updated RangeSum(3,3): -2
Updated RangeSum(4,4): 4
*/
