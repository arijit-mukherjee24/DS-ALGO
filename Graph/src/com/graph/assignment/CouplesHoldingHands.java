package com.graph.assignment;

import java.util.HashMap;
import java.util.Map;

//Leetcode 765. Couples Holding Hands
//Ref: https://www.youtube.com/watch?v=WY6qloZPZ00 Arpan Pathak
//TC: O(n) SC: O(n)

public class CouplesHoldingHands {

	public static void main(String[] args) {

	}

	Map<Integer, Integer> map = new HashMap<Integer, Integer>();

	public int minSwapsCouples(int[] row) {
		int swaps = 0;

		// map stores id, indices
		for (int i = 0; i < row.length; i++) {
			map.put(row[i], i);
		}

		for (int i = 0; i < row.length; i = i + 2) {
			int first = row[i];
			// Doing a XOR operation means decreasing odd number by 1 & increasing even by 1
			// (2,3) is a pair so 2 is even, need to add 1 to find the pair 3
			// and 3 is odd, need to substract 1 to find the pair 2
			int second = first ^ 1;

			if (row[i + 1] != second) {
				swaps++;
				swap(row, i + 1, map.get(second));
			}
		}
		return swaps;
	}

	private void swap(int[] row, int i, int j) {
		int temp = row[i];
		row[i] = row[j];
		row[j] = temp;

		map.put(row[i], i);
		map.put(row[j], j);
	}

}
