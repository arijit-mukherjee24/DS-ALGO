package com.dp.knapsack;

// Aditya VermA
// Techdose

// 494. Target Sum
public class TargetSum {

	public static void main(String[] args) {
		
	}

	public int findTargetSumWays(int[] nums, int target) {

		int sum = 0;
		for (int i = 0; i < nums.length; i++)
			sum += nums[i];

		// special test to deal with -ve input Test case: [100] -200
		if (Math.abs(target) > sum)
			return 0;

		if ((target + sum) % 2 != 0)
			return 0;

		int reqSum = (target + sum) / 2;
		return subsetSum(nums, nums.length, reqSum);
	}

	int subsetSum(int a[], int n, int sum) {
		// Initializing the matrix
		int dp[][] = new int[n + 1][sum + 1];
		// Initializing the first value of matrix
		dp[0][0] = 1;
		for (int i = 1; i <= sum; i++)
			dp[0][i] = 0;
		for (int i = 1; i <= n; i++)
			dp[i][0] = 1;

		for (int i = 1; i <= n; i++) {
			// start with zero, if array contains zero 0 Test case : [0, 0, 0, 1] target: 1
			for (int j = 0; j <= sum; j++) {
				// if the value is greater than the sum
				if (a[i - 1] <= j)
					dp[i][j] = dp[i - 1][j] + dp[i - 1][j - a[i - 1]];
				else
					dp[i][j] = dp[i - 1][j];
			}
		}

		return dp[n][sum];
	}

}
