package com.string.kmp;

// Leetcode 459. Repeated Substring Pattern
//https://www.youtube.com/watch?v=p92_kEjyJAo Knowledge Centre
public class RepeatedSubstringPattern {

	public static void main(String[] args) {
		String s = "abab";
		boolean ans = repeatedSubstringPattern(s);
		System.out.println(ans);
	}

	public static boolean repeatedSubstringPattern(String s) {
		int n = s.length();
		int[] lps = new int[n];
		int l = computeLPS(s, lps, n);

		return ((l != 0) && (l % (n - l)) == 0);

	}

	// compute LPS using kmp
	public static int computeLPS(String s, int[] lps, int n) {
		lps[0] = 0;

		for (int i = 1; i < n; i++) {
			int x = lps[i - 1];
			while (s.charAt(x) != s.charAt(i)) {
				if (x == 0) {
					x = -1;
					break;
				}
				x = lps[x - 1];
			}
			lps[i] = x + 1;
		}
		return lps[n - 1];
	}

}
