package com.dp.lcs;

import java.util.Arrays;

//Ref: https://www.youtube.com/watch?v=AEcRW4ylm_c&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=31 Aditya Verma
//Ref:  https://www.youtube.com/watch?v=CFwCCNbRuLY&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=27 Aditya Verma

//LCS: https://leetcode.com/problems/longest-common-subsequence/

// 1312. Minimum Insertion Steps to Make a String Palindrome
public class MinimumInsertionStepstoMakeaStringPalindrome {

	public static void main(String[] args) {

	}

	static int dp[][];

	public int minInsertions(String s) {
		int m = s.length();

		dp = new int[m + 1][m + 1];
		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}

		String rev = new StringBuffer(s).reverse().toString();

		// No of insertion = No of deletion
		return m - lcs(s, rev, m, m);
	}

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
