package com.assignment.backtracking;

import java.util.Arrays;

// Leetcode 44. Wildcard Matching
//Ref: https://www.youtube.com/watch?v=7SHV_QfVROE Keerti Purswani
//GFG: https://www.geeksforgeeks.org/wildcard-pattern-matching/

public class WildcardMatching {

	public static void main(String[] args) {
		String s = "acdcb";
		String p = "a*c?b";
		
		boolean matched = isMatch(s, p);
		System.out.println(matched);
	}

	public static boolean isMatch(String s, String p) {
		int n = s.length();
		int m = p.length();

		if (m == 0)
			return (n == 0);

		boolean[][] lookup = new boolean[n + 1][m + 1];

		// initialize lookup table to false
		for (int i = 0; i < n + 1; i++)
			Arrays.fill(lookup[i], false);

		// empty pattern can match with empty string
		lookup[0][0] = true;

		// Only '*' can match with empty string
		for (int j = 1; j <= m; j++)
			if (p.charAt(j - 1) == '*')
				lookup[0][j] = lookup[0][j - 1];

		// fill the table in bottom-up fashion
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				// Two cases if we see a '*'
				// a) We ignore '*'' character and move
				// to next character in the pattern,
				// i.e., '*' indicates an empty
				// sequence.
				// b) '*' character matches with ith
				// character in input
				if (p.charAt(j - 1) == '*')
					lookup[i][j] = lookup[i][j - 1] || lookup[i - 1][j];

				// Current characters are considered as
				// matching in two cases
				// (a) current character of pattern is '?'
				// (b) characters actually match
				else if (p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1))
					lookup[i][j] = lookup[i - 1][j - 1];

				// If characters don't match
				else
					lookup[i][j] = false;
			}
		}

		return lookup[n][m];
	}

}
