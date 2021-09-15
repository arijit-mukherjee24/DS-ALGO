package com.hashmap;
// ref: Techdose
// Sliding Window Technique
// Leetcode 525. Contiguous Array
public class ContiguousArray {

	public static void main(String[] args) {
		int[] nums = { 0, 1 };
		int ans = findMaxLength(nums);
		System.out.println(ans);
	}

	public static int findMaxLength(int[] nums) {
		int n = nums.length;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				nums[i] = -1;
			}
		}
		int K = 0; // the required sum in combination of 1, -1

		int lengthOfSmallestSubarray = Integer.MIN_VALUE;
		int windowSum = 0;

		int windowStart = 0;
		for (int windowEnd = 0; windowEnd < n; windowEnd++) {
			windowSum += nums[windowEnd];

			while (windowSum > K) {
				windowSum -= nums[windowStart];
				windowStart++;
			}

			if (windowSum == K) {
				lengthOfSmallestSubarray = Math.max(lengthOfSmallestSubarray, windowEnd - windowStart + 1);
			}
		}

		return lengthOfSmallestSubarray;
	}

}
