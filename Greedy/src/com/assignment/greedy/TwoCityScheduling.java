package com.assignment.greedy;

import java.util.Arrays;

// Leetcode 1029 Two City Scheduling

//Ref: https://www.youtube.com/watch?v=cevaICIEyjs Knowledge Center
// Check the explanation

public class TwoCityScheduling {

	public static void main(String[] args) {

	}

	public int twoCitySchedCost(int[][] costs) {
		Arrays.sort(costs, (a, b) -> (a[0] - a[1]) - (b[0] - b[1]));

		int out = 0;
		for (int i = 0; i < costs.length / 2; i++)
			out += costs[i][0];

		for (int i = costs.length / 2; i < costs.length; i++)
			out += costs[i][1];

		return out;
	}

}
