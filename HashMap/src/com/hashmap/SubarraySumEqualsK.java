package com.hashmap;
// Leetcode 560 560. Subarray Sum Equals K
public class SubarraySumEqualsK {

	public static void main(String[] args) {
		int[] nums = { 1,1,1 };
		int k = 2;
		int ans = subarraySum(nums, k);
		System.out.println(ans);
	}

	public static int subarraySum(int[] nums, int k) {
		int n = nums.length;

		if (n == 1 && nums[0] != k)
			return 0;

		int count = 0;
		int windowSum = 0;

		int windowStart = 0;
		for (int windowEnd = 0; windowEnd < n; windowEnd++) {
			windowSum += nums[windowEnd];

			while (windowSum > k) {
				windowSum -= nums[windowStart];
				windowStart++; // Shrink the window
			}

			if (windowSum == k) {
				count++;
			}
		}

		return count;
	}

}
