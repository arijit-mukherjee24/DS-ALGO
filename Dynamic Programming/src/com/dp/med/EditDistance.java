package com.dp.med;

//Ref: https://www.youtube.com/watch?v=AuYujVj646Q Techdose
//DP + Tabulation

// 72. Edit Distance
public class EditDistance {

	public static void main(String[] args) {

	}

	public int minDistance(String word1, String word2) {

		int m = word1.length();
		int n = word2.length();

		// Create a table to store results of subproblems
		int[][] dp = new int[m + 1][n + 1];

		// Fill d[][] in bottom up manner
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				// If first string is empty, only option is to
				// insert all characters of second string
				if (i == 0)
					dp[i][j] = j; // Min. operations = j

				// If second string is empty, only option is to
				// remove all characters of second string
				else if (j == 0)
					dp[i][j] = i; // Min. operations = i

				// If last characters are same, ignore last char
				// and recur for remaining string
				else if (word1.charAt(i - 1) == word2.charAt(j - 1))
					dp[i][j] = dp[i - 1][j - 1];

				// If the last character is different, consider all
				// possibilities and find the minimum
				else
					dp[i][j] = 1 + min(dp[i][j - 1], // Insert
							dp[i - 1][j], // Remove
							dp[i - 1][j - 1]); // Replace
			}
		}

		return dp[m][n];
	}

	// Utility function to find the minimum of three numbers
	int min(int x, int y, int z) {
		return Math.min(Math.min(x, y), z);
	}

}

/* TLE in Leetcode
 * // Ref: https://www.youtube.com/watch?v=AuYujVj646Q Techdose
// DP + Memoization
// Classnotes
class Solution {
    
    static int dp[][];
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        
        dp = new int[m+1][n+1];
        for(int[] row: dp)
            Arrays.fill(row, -1);
        
        return med(word1, m, word2, n); 
    }
    
    private int med(String s1, int m, String s2, int n) {
        if(m==0)
            return n;
        
        if(n==0)
            return m;
        
        if(dp[m][n] != -1)
            return dp[m][n];
        
        if(s1.charAt(m-1) == s2.charAt(n-1))
            return dp[m][n] = med(s1, m-1, s2, n-1);
        
        return 1 +  min(med(s1, m, s2, n-1),      // Insert
                        med(s1, m-1, s2, n),      // Delete
                        med(s1, m-1, s2, n-1));   // Replace
        
    }
    
    // Utility function to find the minimum of three numbers 
    int min(int x, int y, int z) { 
        return Math.min(Math.min(x, y), z); 
    } 
    
}
*/
