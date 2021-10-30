package com.dp.lcs;

import java.util.Arrays;

//https://leetcode.com/problems/is-subsequence/discuss/87254/Straight-forward-Java-simple-solution
//https://www.youtube.com/watch?v=QVntmksK2es&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=30 Using_LCS Aditya Verma

// 392. Is Subsequence
public class IsSubsequence {

	public static void main(String[] args) {

	}

	/*
	 * public boolean isSubsequence(String s, String t) { if (s.length() == 0)
	 * return true; int indexS = 0, indexT = 0; while (indexT < t.length()) { if
	 * (t.charAt(indexT) == s.charAt(indexS)) { indexS++; if (indexS == s.length())
	 * return true; } indexT++; } return false; }
	 */

	static int dp[][];

	public boolean isSubsequence(String s, String t) {
		int m = s.length();
		int n = t.length();

		if (n == 0 && m != 0)
			return false;

		dp = new int[m + 1][n + 1];
		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}

		return lcs(s, t, m, n) == Math.min(m, n) ? true : false;
	}

// 
	private static int lcs(String x, String y, int m, int n) {
		// base condition
		for (int i = 0; i < m; i++)
			dp[i][0] = 0;

		for (int j = 0; j < n; j++)
			dp[0][j] = 0;

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (x.charAt(i - 1) == y.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		return dp[m][n] == -1 ? 0 : dp[m][n];
	}

}
