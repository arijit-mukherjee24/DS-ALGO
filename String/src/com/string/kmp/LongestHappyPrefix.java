package com.string.kmp;
//Leetcode 1392. Longest Happy Prefix

// KMP for finding LPS array
// Scalar video

public class LongestHappyPrefix {

	public static void main(String[] args) {
		String s = "ababab";
		String ans = longestPrefix(s);
		System.out.println(ans);
	}

	public static String longestPrefix(String s) {
		int len = s.length();

		int[] lps = new int[len]; // longest prefix with same suffix array
		lps[0] = 0;
		int x;

		for (int i = 1; i < len; i++) {
			x = lps[i - 1];

			while (s.charAt(x) != s.charAt(i)) {
				if (x == 0) {
					x = -1;
					break;
				}
				x = lps[x - 1];
			}
			lps[i] = x + 1;
		}
		return s.substring(0, lps[len - 1]);

	}

}
