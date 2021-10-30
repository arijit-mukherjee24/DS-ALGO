package com.dp.mcm;

import java.util.Arrays;

//Ref: https://leetcode.com/problems/burst-balloons/discuss/76228/Share-some-analysis-and-explanations
//https://www.youtube.com/watch?v=uG_MtaCJIrM Techdose

// 312. Burst Balloons
public class BurstBalloons {

	public static void main(String[] args) {

	}

	// 1 nums... 1
	static int[][] dp;

	public int maxCoins(int[] iNums) {
		int[] nums = new int[iNums.length + 2];

		// appending two 1 at the start and the end of the array
		int n = 1;
		for (int x : iNums)
			if (x > 0)
				nums[n++] = x;

		nums[0] = nums[n++] = 1;

		dp = new int[n][n];
		for (int[] row : dp)
			Arrays.fill(row, -1);

		return solve(nums, 0, n - 1);
	}

	private static int solve(int[] nums, int i, int j) {
		if (i + 1 == j)
			return 0;

		if (dp[i][j] != -1)
			return dp[i][j];

		int ans = 0;

		for (int k = i + 1; k < j; k++) {
			int temp_ans = nums[i] * nums[k] * nums[j] + solve(nums, i, k) + solve(nums, k, j);

			if (ans < temp_ans)
				ans = temp_ans;
		}

		dp[i][j] = ans;
		return ans;
	}

}
