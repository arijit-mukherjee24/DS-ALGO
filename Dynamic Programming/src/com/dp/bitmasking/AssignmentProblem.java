package com.dp.bitmasking;
//TC- o(n*2^n)
// Pre Requisite: https://youtu.be/xFWgZ5DTjFo Techdose Concept of DP Bitmasking
// Class Discussion
import java.util.Arrays;

// Discussed Asssignment Problem: https://www.geeksforgeeks.org/job-assignment-problem-using-branch-and-bound/

/*
 * There are N persons and N tasks. Each task is to be alloted to a single person. We are given cost matrix of size (N*N),
 * where cost[i][j] denotes how much person 'i' is going to charge for task 'j'. Now, we need to assign each task to a person 
 * in such a way that the total cost is minimum.
 * 
 * Note: Each task alloted to a single person and each person will be alloted one task.
 * 
 */

// DP + Bitmasking
public class AssignmentProblem {

	public static void main(String[] args) {
		
		// x-coordinate represents a Worker
	    // y-coordinate represents a Job
		int[][] cost = {
				{3, 4, 1},
				{3, 6, 5},
				{4, 5, 6}
		};
		
		/*int[][] cost = {
			 	{9, 2, 7, 8},
		        {6, 4, 3, 7},
		        {5, 8, 1, 8},
		        {7, 6, 9, 4}
		};*/
		int n = cost.length;
		
		int minTotalCost = minTotalCost(cost, n);
		System.out.println("Min Total Cost is "+minTotalCost);
	}

	private static int minTotalCost(int[][] cost, int n) {
		int[] dp = new int[1<<n];
		Arrays.fill(dp, Integer.MAX_VALUE);
		
		// No assignment: If nothing is assigned, then cost will be 0
		dp[0] = 0;  
		
		for(int mask =0; mask < (1<<n); mask++) {
			int x = Integer.bitCount(mask); // Returns the number of set bit i.e indirectly the next person to be set.
			for(int j=0; j<n; j++) {
				if((mask&(1<<j)) == 0)   // Checking whether the current task is unassigned
					// min(already memoized value, prev value + current cost)
					dp[mask|(1<<j)] = Math.min((dp[mask|(1<<j)]), dp[mask] + cost[x][j]);
			}
		}
		
		return dp[(1<<n) - 1];
	}

}
