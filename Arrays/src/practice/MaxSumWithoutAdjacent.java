package practice;

import java.util.Arrays;

// https://practice.geeksforgeeks.org/problems/max-sum-without-adjacents2430/1/?page=1&company[]=Walmart&category[]=Arrays&sortBy=submissions

//// Ref: https://www.youtube.com/watch?v=GrMBfJNk_NY&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=6
//https://takeuforward.org/data-structure/maximum-sum-of-non-adjacent-elements-dp-5/
//Memoization

//198. House Robber
public class MaxSumWithoutAdjacent {

	public static void main(String[] args) {

	}
	
	int findMaxSum(int arr[], int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        int idx = n-1;
        int max = solveUtil(idx, arr, dp);
        
        return max;
    }
    
    static int solveUtil(int idx, int[] arr, int[] dp) {
        if(idx < 0) return 0;
        if(idx == 0) return arr[idx];
        
        if(dp[idx] != -1) return dp[idx];
        
        int pick = arr[idx];
        if(idx > 1) 
            pick += solveUtil(idx-2, arr, dp);
            
        int nonPick = 0 + solveUtil(idx-1, arr, dp);
        
        return dp[idx] = Math.max(pick, nonPick);
    }

}
