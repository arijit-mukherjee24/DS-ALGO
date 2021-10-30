package com.dp.lcs;

import java.util.Arrays;

//Ref: https://practice.geeksforgeeks.org/problems/longest-common-substring1452/1 Longest Common Substring
//Ref: Aditya Verma https://youtu.be/HrybPYpOvz0?list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go Longest Common Substring

// 718. Maximum Length of Repeated Subarray
public class MaximumLengthofRepeatedSubarray {

	public static void main(String[] args) {

	}

	public int findLength(int[] nums1, int[] nums2) {
		int maxlen = 0;
		int n = nums1.length;
		int m = nums2.length;
		// code here
		int dp[][] = new int[n + 1][m + 1];
		for (int[] row : dp)
			Arrays.fill(row, -1);

		for (int i = 0; i <= n; i++)
			dp[i][0] = 0;

		for (int j = 0; j <= m; j++)
			dp[0][j] = 0;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (nums1[i - 1] == nums2[j - 1]) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = 0;
				}

				if (maxlen < dp[i][j])
					maxlen = dp[i][j];
			}
		}

		return maxlen;
	}

}
