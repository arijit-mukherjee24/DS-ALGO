package com.dp.mcm;

//Ref: DP + Memoization
//Palindrome Partioning by Aditya Verma

// Time Limit Eceeded: 32 passed out of 33
// Passed all test cases with optimization
// 132. Palindrome Partitioning II
import java.util.Arrays;

public class PalindromePartitioningII {

	public static void main(String[] args) {

	}

	/*static int[][] dp;

	public int minCut(String s) {
		int n = s.length();

		if (isPalindrome(s, 0, n - 1))
			return 0;

		dp = new int[n][n];
		for (int row[] : dp)
			Arrays.fill(row, -1);

		int res = solve(s, 0, n - 1);
		return res;
	}

	private static int solve(String s, int i, int j) {
		if (i >= j || isPalindrome(s, i, j))
			return 0;

		if (dp[i][j] != -1)
			return dp[i][j];

		dp[i][j] = Integer.MAX_VALUE;
		for (int k = i; k <= j - 1; k++) {
			// int temp_ans = 1 + solve(s, i, k) + solve(s, k+1, j);
			int left, right;
			if (dp[i][k] != -1) {
				left = dp[i][k];
			} else {
				left = solve(s, i, k);
				dp[i][k] = left;
			}
			if (dp[k + 1][j] != -1) {
				right = dp[k + 1][j];
			} else {
				right = solve(s, k + 1, j);
				dp[k + 1][j] = right;
			}

			int temp_ans = 1 + left + right;

			dp[i][j] = Math.min(dp[i][j], temp_ans);
		}

		return dp[i][j];
	}

	private static boolean isPalindrome(String s, int i, int j) {
		if (i >= j)
			return true;

		while (i < j) {
			if (s.charAt(i) != s.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}*/
	
	static int[][] dp;
    
	public int minCut(String s) {
		int n = s.length();

		dp = new int[n][n];
		for (int row[] : dp)
			Arrays.fill(row, -1);

		int res = solve(s, 0, n - 1);
		return res;
	}
    
	private static int solve(String s, int i, int j) {
		if (i >= j || isPalindrome(s, i, j))
			return 0;

		if (dp[i][j] != -1)
			return dp[i][j];

		int min = Integer.MAX_VALUE;
		for (int k = i; k <= j - 1; k++) {
			// int temp_ans = 1 + solve(s, i, k) + solve(s, k+1, j);
			if (isPalindrome(s, i, k)) {
				int temp_ans = 1 + solve(s, k + 1, j);
				if (temp_ans < min)
					min = temp_ans;
			}
		}

		return dp[i][j] = min;
	}
    
	private static boolean isPalindrome(String s, int i, int j) {
		if (i >= j)
			return true;

		while (i < j) {
			if (s.charAt(i) != s.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}

}
