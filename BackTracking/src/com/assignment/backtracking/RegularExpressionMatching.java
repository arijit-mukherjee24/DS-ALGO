package com.assignment.backtracking;
// Leetcode 10. Regular Expression Matching

//Ref: https://www.youtube.com/watch?v=HAA8mgxlov8  NeetCode Top down Memoization DP Recursive
//https://leetcode.com/problems/regular-expression-matching/discuss/1310332/Java-oror-DP-top-down-oror-100-faster

public class RegularExpressionMatching {

	public static void main(String[] args) {
		String s = "aab";
		String p = "c*a*b";
		boolean isMatched = isMatch(s, p);
		System.out.println(isMatched);
	}

	public static boolean isMatch(String s, String p) {
		Boolean dp[][] = new Boolean[s.length() + 1][p.length() + 1];
		return isMatch(s, p, 0, 0, dp);
	}

	public static boolean isMatch(String s, String p, int i, int j, Boolean dp[][]) {
		if (i == s.length() && j == p.length())
			return true;
		if (j == p.length())
			return false;

		if (dp[i][j] != null)
			return dp[i][j];

		boolean ans = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
		if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
			return dp[i][j] = isMatch(s, p, i, j + 2, dp) || (ans && isMatch(s, p, i + 1, j, dp));
		}
		return dp[i][j] = ans && isMatch(s, p, i + 1, j + 1, dp);
	}

}
