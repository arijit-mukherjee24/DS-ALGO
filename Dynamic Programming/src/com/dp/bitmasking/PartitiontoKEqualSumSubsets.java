package com.dp.bitmasking;
//TC- o(n*2^n)
import java.util.Arrays;

//Pre Requisite: https://youtu.be/xFWgZ5DTjFo Techdose Concept of DP Bitmasking
//Class Discussion
//Ref: Assignment Problem (Similar Pattern)
//DP+Bitmasking

// 698. Partition to K Equal Sum Subsets
public class PartitiontoKEqualSumSubsets {

	public static void main(String[] args) {
		int[] nums = {4,3,2,3,5,2,1};
		int k = 4;
		boolean ans = canPartitionKSubsets(nums, k);
		System.out.println(ans);
	}
	
	public static boolean canPartitionKSubsets(int[] nums, int k) {
        int n = nums.length;
        int sum = 0, mx = Integer.MIN_VALUE;
        
        for(int i = 0; i<n; i++) {
            sum += nums[i];
            mx = Math.max(mx, nums[i]);
        }
        
        // initial checks (generic)
        if( (sum%k != 0) || (mx > sum/k))
            return false;
        
        int target = sum/k;
        
        int[] dp = new int[1<<n];
		Arrays.fill(dp, -1);  // Size -> 2^n
        dp[0] = 0;  // Start Point
        
        // Try all combinations
        for(int mask = 0; mask< (1<<n); mask++) {
            if(dp[mask] == -1) // Invalid Combinations
                continue;
            
            for(int j =0; j<n; j++) {
                // Check if the current jth element can be picked and sum within the limit
                if((mask&(1<<j)) == 0 && dp[mask]+nums[j] <= target)
                    dp[mask|(1<<j)] = (dp[mask]+nums[j])%target;   
            }
            
            
        }
        return dp[(1<<n) - 1]==0?true:false;     
    }

}
