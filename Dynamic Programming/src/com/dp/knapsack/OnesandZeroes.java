package com.dp.knapsack;

//https://leetcode.com/problems/ones-and-zeroes/discuss/95807/0-1-knapsack-detailed-explanation.

//Ref: https://www.youtube.com/watch?v=qkUZ87NCYSw Algorithms Made Easy
//TC: O(len * m * n)  SC: O(n * m)

// 474. Ones and Zeroes
public class OnesandZeroes {

	public static void main(String[] args) {

	}

	public int findMaxForm(String[] strs, int m, int n) {
		int[][] dp = new int[m + 1][n + 1];
		for (String str : strs) {
			int one = 0;
			int zero = 0;
			for (char c : str.toCharArray()) {
				if (c == '1')
					one++;
				else
					zero++;
			}
			for (int i = m; i >= zero; i--) {
				for (int j = n; j >= one; j--) {
					if (one <= j && zero <= i)
						dp[i][j] = Math.max(dp[i][j], dp[i - zero][j - one] + 1);
				}
			}
		}
		return dp[m][n];
	}

}

/*
 * // Arpan's Soln : DP + Memoization
class Solution {
	private int solve(String[] s, int m, int n, int len, int[][][] dp) {
		if (m == 0 && n == 0) {
			return 0;
		}
		if (len == 0) {
			return 0;
		}
		if (dp[m][n][len] != -1) {
			return dp[m][n][len];
		}
		int ones = 0;
		int zeros = 0;
		for (char ch : s[len - 1].toCharArray()) {
			if (ch == '0')
				zeros++;
			if (ch == '1')
				ones++;
		}
		if (ones > n || zeros > m) {
			return dp[m][n][len] = solve(s, m, n, len - 1, dp);
		} else {
			return dp[m][n][len] = Math.max(solve(s, m, n, len - 1, dp),
					1 + solve(s, m - zeros, n - ones, len - 1, dp));
		}
	}

	public int findMaxForm(String[] strs, int m, int n) {
		int len = strs.length;
		int[][][] dp = new int[m + 1][n + 1][len + 1];
		for (int i = 0; i < m + 1; i++) {
			for (int j = 0; j < n + 1; j++) {
				for (int k = 0; k < len + 1; k++) {
					dp[i][j][k] = -1;
				}
			}
		}
		return solve(strs, m, n, len, dp);
	}
}
 */


