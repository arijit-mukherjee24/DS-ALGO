package com.dp.knapsack;

//Ref: https://leetcode.com/problems/coin-change-2/discuss/99212/Knapsack-problem-Java-solution-with-thinking-process-O(nm)-Time-and-O(m)-Space

//https://www.youtube.com/watch?v=I4UR2T6Ro3w&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=15 Aditya Verma

//Unbounded Knapsack in Tabulation Approach

// 518. Coin Change 2
public class CoinChange2 {

	public static void main(String[] args) {

	}

	public int change(int amount, int[] coins) {
		int[][] dp = new int[coins.length + 1][amount + 1];
		dp[0][0] = 1;

		for (int i = 1; i <= coins.length; i++) {
			dp[i][0] = 1;
			for (int j = 1; j <= amount; j++) {

				if (coins[i - 1] <= j) {
					dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
				} else {
					dp[i][j] = dp[i - 1][j];
				}

			}
		}
		return dp[coins.length][amount];
	}

}
