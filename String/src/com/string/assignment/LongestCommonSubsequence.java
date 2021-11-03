package com.string.assignment;

import java.util.Arrays;

//https://www.youtube.com/watch?v=hR3s9rGlMTU&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=21 Aditya Verma

//print lcs: https://www.youtube.com/watch?v=x5hQvnUcjiM&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=23 Aditya Verma

//DP + Tabulation

// 1143. Longest Common Subsequence
public class LongestCommonSubsequence {

	public static void main(String[] args) {

	}

	static int dp[][];

	public int longestCommonSubsequence(String text1, String text2) {
		int m = text1.length();
		int n = text2.length();

		dp = new int[m + 1][n + 1];
		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}

		return lcs(text1, text2, m, n);
	}

	private static int lcs(String x, String y, int m, int n) {
		// base condition
		for (int i = 0; i < m; i++)
			dp[i][0] = 0;

		for (int j = 0; j < n; j++)
			dp[0][j] = 0;

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (x.charAt(i - 1) == y.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		// print lcs
		printLCS(x, y, m, n);

		return dp[m][n] == -1 ? 0 : dp[m][n];
	}

	// printing the lcs string
	private static void printLCS(String x, String y, int m, int n) {
		int i = m, j = n;
		String str = "";

		while (i > 0 && j > 0) {
			if (x.charAt(i - 1) == y.charAt(j - 1)) {
				str = str + x.substring(i - 1, i);
				i--;
				j--;
			} else if (dp[i][j - 1] > dp[i - 1][j])
				j--;
			else
				i--;
		}
		str = new StringBuffer(str).reverse().toString();
		System.out.println(str);
	}

}

/* Memoization
 * // https://www.youtube.com/watch?v=g_hIx4yn9zg&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=20 Aditya Verma

// DP + Memoization
class Solution {
    static int dp[][];
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        
        dp = new int[m+1][n+1];
        for(int[] row: dp) {
            Arrays.fill(row, -1);
        }
        
        return lcs(text1, text2, m, n);
    }
    
    private static int lcs(String x, String y, int m, int n)  {
        if(m==0 || n==0)
            return 0;
        
        if(dp[m][n] != -1){
            return dp[m][n];
        }  
        
        if(x.charAt(m-1) == y.charAt(n-1)) {
            dp[m][n] = 1 + lcs(x, y, m-1, n-1);
        }
        else {
            dp[m][n] = Math.max(lcs(x, y, m-1, n), lcs(x, y, m, n-1));
        }
        
        return dp[m][n];
    }
    
    
}
*/
