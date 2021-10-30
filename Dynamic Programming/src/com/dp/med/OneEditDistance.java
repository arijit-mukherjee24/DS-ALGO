package com.dp.med;

//Ref: https://www.youtube.com/watch?v=CsP1an6DDzo

// Lintcode 640 · One Edit Distance
public class OneEditDistance {

	public static void main(String[] args) {

	}

	public boolean isOneEditDistance(String s, String t) {
		int n1 = s.length();
		int n2 = t.length();

		if (n1 > n2)
			return isOneEditDistance(t, s);

		for (int i = 0; i < n1; i++) {
			if (s.charAt(i) != t.charAt(i)) {

				if (n1 == n2)
					return s.substring(i + 1).equals(t.substring(i + 1));
				else
					return s.substring(i).equals(t.substring(i + 1));
			}
		}

		return (n1 + 1 == n2);
	}

}


/* Memory Limit Exceeded : From Edit Distance Soln

public boolean isOneEditDistance(String word1, String word2) {
int m = word1.length();
 int n = word2.length();

 if(Math.abs(m-n) > 1)
     return false;
 
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

 return (dp[m][n]==1?true:false); 
}

// Utility function to find the minimum of three numbers 
int min(int x, int y, int z) { 
 return Math.min(Math.min(x, y), z); 
} 

*/