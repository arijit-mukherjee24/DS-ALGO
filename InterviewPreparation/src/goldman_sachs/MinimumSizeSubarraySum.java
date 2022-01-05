package goldman_sachs;
// Leetcode - 209 - https://leetcode.com/problems/minimum-size-subarray-sum/
public class MinimumSizeSubarraySum {

	public static void main(String[] args) {
		int[] nums = {2,3,1,2,4,3};
		int target = 7;
		int ans = minSubArrayLen(target, nums);
		System.out.println(ans);
	}

	public static int minSubArrayLen(int target, int[] nums) {
		int n = nums.length;

		int lengthOfSmallestSubarray = Integer.MAX_VALUE;
		int windowSum = 0;

		int windowStart = 0;
		for (int windowEnd = 0; windowEnd < n; windowEnd++) {
			windowSum += nums[windowEnd]; // Add the next element to the window

			while (windowSum >= target) { // sum is greater than or equal to target
				lengthOfSmallestSubarray = Math.min(lengthOfSmallestSubarray, windowEnd - windowStart + 1);
				windowSum -= nums[windowStart];
				windowStart++;
			}
		}

		return lengthOfSmallestSubarray == Integer.MAX_VALUE ? 0 : lengthOfSmallestSubarray;

	}

}
