package com.string.assignment;

import java.util.HashSet;

/*Optimization: 
We can further optimize the above code. The substr() function works in linear time. 
We can use append current character to previous substring to get the current substring. 
*/

// Another approach exist using Trie (Space Optimized)
public class CountNumberofDistinctSubstring {

	public static void main(String[] args) {
		String str = "aaabc";
		printSubStrings(str);
	}

	// Function to return the count of
	// valid sub-Strings
	static void printSubStrings(String s) {

		// To store distinct output subStrings
		HashSet<String> us = new HashSet<String>();

		// Traverse through the given String and
		// one by one generate subStrings beginning
		// from s[i].
		for (int i = 0; i < s.length(); ++i) {

			// One by one generate subStrings ending
			// with s[j]
			String ss = "";
			for (int j = i; j < s.length(); ++j) {
				ss = ss + s.charAt(j);
				us.add(ss);
			}
		}

		// Print all subStrings one by one
		for (String str : us)
			System.out.print(str + " ");
	}

}
