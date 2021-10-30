package com.dp.lps;

//Ref: https://www.youtube.com/watch?v=UflHuQj6MVA Techdose Tabulation 
//GFG Tabulation : https://www.geeksforgeeks.org/longest-palindrome-substring-set-1/?ref=lbp
//TC: O(n^2)

// 5. Longest Palindromic Substring
public class LongestPalindromicSubstring {

	public static void main(String[] args) {

	}

	public String longestPalindrome(String str) {
		// get length of input string
		int n = str.length();

		// table[i][j] will be false if
		// substring str[i..j] is not palindrome.
		// Else table[i][j] will be true
		boolean table[][] = new boolean[n][n];

		// All substrings of length 1 are palindromes
		int maxLength = 1;
		for (int i = 0; i < n; ++i)
			table[i][i] = true;

		// check for sub-string of length 2.
		int start = 0;
		for (int i = 0; i < n - 1; ++i) {
			if (str.charAt(i) == str.charAt(i + 1)) {
				table[i][i + 1] = true;
				start = i;
				maxLength = 2;
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

					if (k > maxLength) {
						start = i;
						maxLength = k;
					}
				}
			}
		}

		return str.substring(start, start + maxLength);
	}

}
