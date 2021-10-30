package com.dp.lps;

//Ref: https://www.youtube.com/watch?v=UflHuQj6MVA Techdose Tabulation 
//GFG Tabulation : https://www.geeksforgeeks.org/longest-palindrome-substring-set-1/?ref=lbp
//TC: O(n^2)

//Ref: Leetcode - https://leetcode.com/problems/longest-palindromic-substring/submissions/
// 647. Palindromic Substrings
public class PalindromicSubstrings {

	public static void main(String[] args) {

	}

	public int countSubstrings(String str) {
		// get length of input string
		int n = str.length();
		int count = 0;

		// table[i][j] will be false if
		// substring str[i..j] is not palindrome.
		// Else table[i][j] will be true
		boolean table[][] = new boolean[n][n];

		// All substrings of length 1 are palindromes
		for (int i = 0; i < n; ++i) {
			table[i][i] = true;
			count++;
		}

		// check for sub-string of length 2.
		for (int i = 0; i < n - 1; ++i) {
			if (str.charAt(i) == str.charAt(i + 1)) {
				table[i][i + 1] = true;
				count++;
			}
		}

		// Check for lengths greater than 2.
		// k is length of substring
		for (int k = 3; k <= n; ++k) {

			// Fix the starting index
			for (int i = 0; i < n - k + 1; ++i) {
				// Get the ending index of substring from
				// starting index i and length k
				int j = i + k - 1;

				// checking for sub-string from ith index to
				// jth index iff str.charAt(i+1) to
				// str.charAt(j-1) is a palindrome
				if (table[i + 1][j - 1] && str.charAt(i) == str.charAt(j)) {
					table[i][j] = true;
					count++;
				}
			}
		}

		return count;
	}

}
