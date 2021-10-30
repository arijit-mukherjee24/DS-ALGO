package com.dp.grid;

//Ref: https://www.youtube.com/watch?v=t1shZ8_s6jc Techdose
//Tabulation Approach

// 64. Minimum Path Sum
public class MinimumPathSum {

	public static void main(String[] args) {

	}

	public int minPathSum(int[][] grid) {
		int rows = grid.length;
		if (rows == 0)
			return 0;

		int cols = grid[0].length;
		int[][] dp = new int[rows][cols];
		int i, j;

		dp[0][0] = grid[0][0]; // 1st element is starting point

		// Fill 1st row
		for (i = 1; i < cols; i++)
			dp[0][i] = dp[0][i - 1] + grid[0][i];

		// Fill 1st Col
		for (i = 1; i < rows; i++)
			dp[i][0] = dp[i - 1][0] + grid[i][0];

		// Now fill the rest of the cell
		for (i = 1; i < rows; i++) {
			for (j = 1; j < cols; j++)
				dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
		}
		return dp[rows - 1][cols - 1];
	}

}
