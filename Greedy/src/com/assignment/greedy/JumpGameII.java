package com.assignment.greedy;
// Leetcode 45. Jump Game II

//Ref: https://www.youtube.com/watch?v=Pk128gC_sdw Same as leetcode 1326 
//same concept
public class JumpGameII {

	public static void main(String[] args) {

	}

	public int jump(int[] nums) {
		int min = 0;
		int max = 0;
		int jumps = 0;

		while (max < (nums.length - 1)) {

			for (int i = 0; i < nums.length; i++) {
				if (i <= min && (nums[i] + i) > max) {
					max = nums[i] + i;
				}
			}
			jumps++;

			min = max;
		}
		return jumps;
	}

}
