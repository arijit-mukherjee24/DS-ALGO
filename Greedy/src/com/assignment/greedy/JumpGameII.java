package com.assignment.greedy;
// Leetcode 45. Jump Game II

//Ref: https://www.youtube.com/watch?v=Pk128gC_sdw Same as leetcode 1326 
//same concept

//Ref: https://www.youtube.com/watch?v=Yrw3MNh_368 Prakash Shukla
//TC: O(n) SC: O(1)
class JumpGameII {
	public int jump(int[] nums) {
		int des = 0;
		int jumps = 0;
		int pos = 0;

		// We will not jump anywhere from the last index,
		// as we need to calculate the number of jump to reach last index,
		// so we are looping till (num.length - 1)
		for (int i = 0; i < nums.length - 1; i++) {

			// We calculating the max destination from each possible position
			des = Math.max(des, nums[i] + i);

			// we are updating the position with the max possible destination,
			// and incraese the jump count
			if (pos == i) {
				pos = des;
				jumps++;
			}
		}
		return jumps;
	}
}

/*
 * //Ref: https://www.youtube.com/watch?v=Pk128gC_sdw Same as leetcode 1326
 * 
 * //same concept public class JumpGameII {
 * 
 * public static void main(String[] args) {
 * 
 * }
 * 
 * public int jump(int[] nums) { int min = 0; int max = 0; int jumps = 0;
 * 
 * while (max < (nums.length - 1)) {
 * 
 * for (int i = 0; i < nums.length; i++) { if (i <= min && (nums[i] + i) > max)
 * { max = nums[i] + i; } } jumps++;
 * 
 * min = max; } return jumps; }
 * 
 * }
 * 
 */
