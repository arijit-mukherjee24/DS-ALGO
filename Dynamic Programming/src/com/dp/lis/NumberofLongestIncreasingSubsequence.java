package com.dp.lis;

import java.util.Arrays;

//Ref: https://www.youtube.com/watch?v=C1DTXdF3s14 Naresh Gupta
//Ref: Leetcode 300. Longest Increasing Subsequence

// 673. Number of Longest Increasing Subsequence
public class NumberofLongestIncreasingSubsequence {

	public static void main(String[] args) {

	}

	public int findNumberOfLIS(int[] arr) {
		int n = arr.length;
		if (n == 0)
			return 0;

		int lis[] = new int[n];
		int count[] = new int[n];
		int i, j, max = 1; // Initialize max with 1, not 0

		/* Initialize LIS values for all indexes */
		Arrays.fill(lis, 1);
		Arrays.fill(count, 1);

		/*
		 * Compute optimized LIS values in bottom up manner
		 */
		for (i = 1; i < n; i++)
			for (j = 0; j < i; j++)
				if (arr[i] > arr[j]) {
					if (lis[i] < lis[j] + 1) {
						lis[i] = lis[j] + 1;
						count[i] = count[j];
					} else if (lis[i] == lis[j] + 1) {
						count[i] += count[j];
					}

					/* Pick maximum of all LIS values */
					if (max < lis[i])
						max = lis[i];
				}

		int numLis = 0;
		for (int k = 0; k < n; k++) {
			if (lis[k] == max) {
				numLis += count[k];
			}
		}

		return numLis;
	}

}
