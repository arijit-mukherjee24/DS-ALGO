package com.string.assignment;

import java.util.List;

//https://www.geeksforgeeks.org/find-largest-word-dictionary-deleting-characters-given-string/

// https://practice.geeksforgeeks.org/viewSol.php?subId=6a540b44fc60570726283038a1d71dd9&pid=703678&user=arijitcode10
/*
Time Complexity: O(N*(K+n)) Here N is the length of dictionary and n is the length of given string ‘str’ and K – maximum length of words in the dictionary.
Auxiliary Space: O(1)  
*/
public class LargestWordInDictionary {

	public static void main(String[] args) {
		
	}
	
	static String findLongestWord(String str, List<String> dict) {
        String max_str = "";
 
        // Traverse through all words of dictionary
        for (String word : dict)
        {
            // If current word is subsequence of str
            // and is largest such word so far.
            if (isSubSequence(word, str))
            {
                if(word.length() > max_str.length() ||
                   (word.length() == max_str.length() &&
                    word.compareTo(max_str) < 0))
                    max_str = word;
            }
        }
 
        // Return longest String
        return max_str;
    }
    
      // Returns true if str1[] is a
    // subsequence of str2[]. m is
    // length of str1 and n is length of str2
    static boolean isSubSequence(String str1,
                                String str2)
    {
        int m = str1.length(), n = str2.length();
 
        int j = 0; // For index of str1 (or subsequence)
 
        // Traverse str2 and str1, and compare current
        // character of str2 with first unmatched char
        // of str1, if matched then move ahead in str1
        for (int i = 0; i < n && j < m; i++)
        {
            if (str1.charAt(j) == str2.charAt(i))
            {
                j++;
            }
        }
 
        // If all characters of str1
        // were found in str2
        return (j == m);
    }

}
