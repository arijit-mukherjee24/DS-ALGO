package com.dp.lcs;

import java.util.Arrays;

//Ref: https://www.youtube.com/watch?v=wuOOOATz_IA&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=26 Aditya Verma
//Refer: LCS Solution : https://leetcode.com/problems/longest-common-subsequence/ (Base Question)

// 516. Longest Palindromic Subsequence
public class LongestPalindromicSubsequence {

	public static void main(String[] args) {

	}

	static int dp[][];

	public int longestPalindromeSubseq(String s) {
		int m = s.length();

		dp = new int[m + 1][m + 1];
		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}

		String rev = new StringBuffer(s).reverse().toString();

		return lcs(s, rev, m, m);
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

		// print lcs
		printLCS(x, y, m, n);

		return dp[m][n] == -1 ? 0 : dp[m][n];
	}

	// printing the lcs string
	private static void printLCS(String x, String y, int m, int n) {
		int i = m, j = n;
		String str = "";

		while (i > 0 && j > 0) {
			if (x.charAt(i - 1) == y.charAt(j - 1)) {
				str = str + x.substring(i - 1, i);
				i--;
				j--;
			} else if (dp[i][j - 1] > dp[i - 1][j])
				j--;
			else
				i--;
		}
		str = new StringBuffer(str).reverse().toString();
		System.out.println(str);
	}

}
