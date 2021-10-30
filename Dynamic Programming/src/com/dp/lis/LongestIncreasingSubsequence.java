package com.dp.lis;

//Ref: https://www.youtube.com/watch?v=mouCn3CFpgg Techdose DP Approach 
//TC: O(n^2)  SC: O(n)

//Ref: https://www.geeksforgeeks.org/longest-increasing-subsequence-dp-3/  DP Approach

//01:40:38 DP + Bitmasking (DP Recursion)
// 300. Longest Increasing Subsequence
public class LongestIncreasingSubsequence {

	public static void main(String[] args) {

	}

	public int lengthOfLIS(int[] arr) {
		int n = arr.length;
		int lis[] = new int[n];
		int i, j, max = 1; // Initialize max with 1, not 0

		/* Initialize LIS values for all indexes */
		for (i = 0; i < n; i++) {
			lis[i] = 1;
		}

		/*
		 * Compute optimized LIS values in bottom up manner
		 */
		for (i = 1; i < n; i++)
			for (j = 0; j < i; j++)
				if (arr[i] > arr[j] && lis[i] < lis[j] + 1) {
					lis[i] = lis[j] + 1;

					/* Pick maximum of all LIS values */
					if (max < lis[i])
						max = lis[i];
				}

		return max;
	}

}
