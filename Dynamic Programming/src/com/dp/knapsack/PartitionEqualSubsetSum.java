package com.dp.knapsack;
//https://www.youtube.com/watch?v=UmMh7xp07kY&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=8 Aditya Verma

//https://www.techiedelight.com/subset-sum-problem/ Techiedelight


// 416. Partition Equal Subset Sum
public class PartitionEqualSubsetSum {

	public static void main(String[] args) {

	}

	public boolean canPartition(int[] nums) {
		int sum = 0;
		for (int x : nums)
			sum += x;

		if (sum % 2 != 0)
			return false;

		sum = sum / 2;
		return subsetSum(nums, sum);
	}

	// Returns true if there exists a subsequence of array `A` with the given sum
	public static boolean subsetSum(int[] A, int k) {
		int n = A.length;

		// `T[i][j]` stores true if subset with sum `j` can be attained
		// using items up to first `i` items
		boolean[][] T = new boolean[n + 1][k + 1];

		// if the sum is zero
		for (int i = 0; i <= n; i++) {
			T[i][0] = true;
		}

		// do for i'th item
		for (int i = 1; i <= n; i++) {
			// consider all sum from 1 to sum
			for (int j = 1; j <= k; j++) {
				// don't include the i'th element if `j-A[i-1]` is negative
				if (A[i - 1] > j) {
					T[i][j] = T[i - 1][j];
				} else {
					// find the subset with sum `j` by excluding or including
					// the i'th item
					T[i][j] = T[i - 1][j] || T[i - 1][j - A[i - 1]];
				}
			}
		}

		// return maximum value
		return T[n][k];
	}

}

/* DP + Memoization
 * // https://www.youtube.com/watch?v=UmMh7xp07kY&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=8 Aditya Verma

// https://www.techiedelight.com/subset-sum-problem/ Techiedelight
// Arpan's Solution - DP + Memoization
class Solution {
    private boolean check(int[] nums,Boolean[][] dp,int sum,int n){
        if(sum==0){
            return true;
        }
        if(n==0){
            return false;
        }
        
        if(dp[n][sum]!=null){
             return dp[n][sum];
        }
        if(nums[n-1]>sum){
            dp[n][sum] = check(nums, dp, sum, n - 1);
            return dp[n][sum];
        }
        return dp[n][sum]=(check(nums,dp,sum-nums[n-1],n-1) || check(nums,dp,sum,n-1));
    }
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i:nums){
            sum+=i;
        }
        // Declare the table dynamically
        Boolean dp[][] = new Boolean[nums.length + 1][(sum/2) + 1]; 
        if(sum%2==0){
            return check(nums,dp,sum/2,nums.length);
        }
        return false;
    }
}
*/
