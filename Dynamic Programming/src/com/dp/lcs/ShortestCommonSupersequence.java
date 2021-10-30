package com.dp.lcs;

import java.util.Arrays;

//Ref: https://www.youtube.com/watch?v=823Grn4_dCQ&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=24 SCSS Aditya Verma
//Print Scss: https://www.youtube.com/watch?v=VDhRg-ZJTuc&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=28 Aditya Verma

// 1092. Shortest Common Supersequence (Tabulation Approach)
public class ShortestCommonSupersequence {

	public static void main(String[] args) {

	}

	static int dp[][];

	public String shortestCommonSupersequence(String str1, String str2) {
		int m = str1.length();
		int n = str2.length();

		dp = new int[m + 1][n + 1];
		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}

		return lcs(str1, str2, m, n);
	}

	private static String lcs(String x, String y, int m, int n) {
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
		int scssLen = m + n - ((dp[m][n] == -1) ? 0 : dp[m][n]);
		System.out.print("Shortest commom super sequence length is " + scssLen);

		// print lcs
		return printSCSS(x, y, m, n);
	}

	// printing the lcs string
	private static String printSCSS(String x, String y, int m, int n) {
		int i = m, j = n;
		String str = "";

		while (i > 0 && j > 0) {
			if (x.charAt(i - 1) == y.charAt(j - 1)) {
				str += x.substring(i - 1, i);
				i--;
				j--;
			} else if (dp[i][j - 1] > dp[i - 1][j]) {
				str += y.substring(j - 1, j);
				j--;
			} else {
				str += x.substring(i - 1, i);
				i--;
			}
		}

		// left over part of x if any
		while (i > 0) {
			str += x.substring(i - 1, i);
			i--;
		}

		// left over part of y if any
		while (j > 0) {
			str += y.substring(j - 1, j);
			j--;
		}

		str = new StringBuffer(str).reverse().toString();
		return str;
	}

}
