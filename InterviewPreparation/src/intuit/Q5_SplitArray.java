package intuit;

// https://leetcode.com/problems/split-array-largest-sum/
// Leetcode 410
// https://www.youtube.com/watch?v=W9QJ8HaRvJQ
public class Q5_SplitArray {
	public static void main(String[] args) {
		int nums[] = { 7, 2, 5, 10, 8 };
		int m = 2;
		int ans = splitArray(nums, m);
		System.out.println(ans);
	}

	public static int splitArray(int[] nums, int m) {
		int start = 0;
		int end = 0;

		for (int i = 0; i < nums.length; i++) {
			start = Math.max(start, nums[i]); // in the end of the loop this will contain the max item fro the array
			end += nums[i];
		}

		// binary search
		while (start < end) {
			// try for the middle as potential ans
			int mid = start + (end - start) / 2;

			// calculate how many pieces you can divide this in with this max sum
			int sum = 0;
			int pieces = 1;
			for (int num : nums) {
				if (sum + num > mid) {
					// you cannot add this in this subarray, make new one
					// say you add this num in new subarray, then sum = num
					sum = num;
					pieces++;
				} else {
					sum += num;
				}
			}

			if (pieces > m) {
				start = mid + 1;  // here we need to increase the sum
			} else {
				end = mid; // here we need to reduce the sum
			}

		}
		return end; // here start == end
	}
}