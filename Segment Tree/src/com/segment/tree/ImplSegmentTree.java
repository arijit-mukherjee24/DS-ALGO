package com.segment.tree;

public class ImplSegmentTree {

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

	private static void buildSegTree(int st_idx, int[] arr, int start, int end) {
		if (start > end)// Invalid Case
			return;
		if (start == end) {// LeafNode Case
			st[st_idx] = arr[start];
			return;
		}

		// InternalNode Case
		int middle = start + (end - start) / 2;
		buildSegTree(2 * st_idx, arr, start, middle);
		buildSegTree(2 * st_idx + 1, arr, middle + 1, end);
		st[st_idx] = st[2 * st_idx] + st[2 * st_idx + 1];
	}

}
