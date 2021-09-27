package com.assignment.greedy;
// Leetcode 55. Jump Game

//Ref: https://www.youtube.com/watch?v=Pk128gC_sdw Same as leetcode 1326 
//same concept 
// Same as Jump Game II
public class JumpGame {

	public static void main(String[] args) {

	}

	public boolean canJump(int[] nums) {
        int min = 0;
        int max = 0;
        int jumps = 0;
        
        while(max < (nums.length - 1)) {
            
            for(int i = 0; i<nums.length; i++) {
                if(i<= min && (nums[i] + i ) > max) {
                    max = nums[i] + i;
                }
            }
            jumps = jumps + 1;
            if(min == max) return false;
            min = max;
        }
        return true;
    }

}
