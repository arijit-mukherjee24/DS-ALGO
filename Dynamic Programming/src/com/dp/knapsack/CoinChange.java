package com.dp.knapsack;

//https://www.youtube.com/watch?v=I-l6PBeERuc&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=16 Aditya Verma

//https://www.youtube.com/watch?v=ZI17bgz07EE Techdose

// 322. Coin Change
public class CoinChange {

	public static void main(String[] args) {

	}

	public int coinChange(int[] coins, int amount) {
		int[][] dp = new int[coins.length + 1][amount + 1];

		for (int j = 0; j <= amount; j++)
			dp[0][j] = Integer.MAX_VALUE - 1;

		for (int i = 1; i <= coins.length; i++)
			dp[i][0] = 0;

		// Initializing the first row, initilialization not required (optional)
		for (int j = 0; j <= amount; j++) {
			if (j % coins[0] == 0)
				dp[1][j] = j / coins[0];
			else
				dp[1][j] = Integer.MAX_VALUE - 1;
		}

		for (int i = 2; i <= coins.length; i++) {
			for (int j = 1; j <= amount; j++) {

				if (coins[i - 1] <= j) {
					dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
				} else {
					dp[i][j] = dp[i - 1][j];
				}

			}
		}
		return dp[coins.length][amount] >= Integer.MAX_VALUE - 1 ? -1 : dp[coins.length][amount];
	}

}
