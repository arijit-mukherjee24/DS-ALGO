package com.assignment.greedy;
// Leetcode 134. Gas Station : https://leetcode.com/problems/gas-station/

// Ref: https://www.youtube.com/watch?v=xmJZSYSvgfE Knowledge Center

public class GasStation {

	public static void main(String[] args) {

	}

	public int canCompleteCircuit(int[] gas, int[] cost) {
		int n = gas.length;

		int curr_surplus = 0; // for the current surplus
		int total_surplus = 0; // for the total surplus
		int startingPoint = 0; // to capture the starting point

		for (int i = 0; i < n; i++) {
			total_surplus += gas[i] - cost[i];
			curr_surplus += gas[i] - cost[i];

			if (curr_surplus < 0) {
				curr_surplus = 0;
				startingPoint = i + 1;
			}
		}

		return (total_surplus < 0) ? -1 : startingPoint;
	}

}
