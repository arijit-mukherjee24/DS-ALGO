package com.dp.grid;

//Techdose: https://www.youtube.com/watch?v=rBAxUTqvlQA
//Dp + Memoization

// 62. Unique Paths
public class UniquePaths {

	public static void main(String[] args) {

	}

	static int[][] dp;

	public int uniquePaths(int m, int n) {
		dp = new int[m + 1][n + 1];
		return helper(m, n);
	}

	private static int helper(int m, int n) {
		if (m == 1 || n == 1) // base condition
			return 1;

		if (dp[m][n] != 0) // memoization
			return dp[m][n];

		dp[m][n] = helper(m - 1, n) + helper(m, n - 1);

		return dp[m][n];
	}

}


// Tabulation:
/*
//https://www.youtube.com/watch?v=rBAxUTqvlQA Techdose
//DP + Tabulation

//Here, the number of unique path from start to finish and finish to start is same.
//So, we are assuming we are moving from finish to start.
//And the direction of movement possible also reverse.
//Allowed movement now possible are top, and left.

class Solution {
 public int uniquePaths(int m, int n) {
     int[][] dp = new int[m][n];
     
     for(int i=0; i<m; i++) 
         dp[i][0] = 1;
     
     for(int j=0; j<n; j++) 
         dp[0][j] = 1;
     
     for(int i=1; i<m; i++)
         for(int j=1; j<n; j++)
             dp[i][j] = dp[i-1][j] + dp[i][j-1];
     
     return dp[m-1][n-1];
     
 }
}*/