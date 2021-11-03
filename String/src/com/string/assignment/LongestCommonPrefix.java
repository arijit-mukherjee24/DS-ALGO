package com.string.assignment;

//Ref: https://www.youtube.com/watch?v=TNEpFdG7Rss 2nd Approach

// 14. Longest Common Prefix
public class LongestCommonPrefix {

	public static void main(String[] args) {

	}

	public String longestCommonPrefix(String[] strs) {
		/*************************************************************/
		// Start with first string as the prefix
		// Now keep matching the prefix with each string
		// and keep reducing the prefix length if they dont match with other strings
		/*************************************************************/

		String prefix = strs[0];
		for (int i = 1; i < strs.length; i++) {
			while (strs[i].indexOf(prefix) != 0)
				prefix = prefix.substring(0, prefix.length() - 1);

			if (prefix.length() == 0)
				return "";
		}
		return prefix;
	}

}
