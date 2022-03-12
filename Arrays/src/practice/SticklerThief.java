package practice;

//198. House Robber
//Tabluation + Space Optimization Striver
public class SticklerThief {

	public static void main(String[] args) {
		
	}
	
	//Function to find the maximum money the thief can get.
  public int FindMaxSum(int arr[], int n)
  {
     int prev = arr[0], prev2 = 0;
     int cur_i = 0;
      
     for(int i=1; i<n; i++) {
          int pick = arr[i] + prev2;
          int nonPick = 0 + prev;
          cur_i = Math.max(pick, nonPick);
         
          prev2 = prev;
          prev = cur_i;
      }
      
      return prev;
  }

}


/*
198. House Robber
// Ref: https://www.youtube.com/watch?v=GrMBfJNk_NY&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=6 Striver
//https://takeuforward.org/data-structure/maximum-sum-of-non-adjacent-elements-dp-5/
===============================================
//Tabulation - With Space Optimization
class Solution {
  public int rob(int[] nums) {
     int prev = nums[0], prev2 = 0;
     int cur_i = 0;
      
     for(int i=1; i<nums.length; i++) {
          int pick = nums[i] + prev2;
          int nonPick = 0 + prev;
          cur_i = Math.max(pick, nonPick);
         
          prev2 = prev;
          prev = cur_i;
      }
      
      return prev;
  }
  
} 
===============================================
//Tabulation - Without Space Optimization
class Solution {
  public int rob(int[] nums) {
      int n = nums.length;
      
      int[] dp = new int[n];
      Arrays.fill(dp, -1);
      
      int idx = n-1;
      return solveUtil(idx, nums, dp);
  }
  
  private static int solveUtil(int idx, int[] nums, int[] dp) {
      dp[0] = nums[0];  int n = nums.length;
      
      for(int i=1; i<n; i++) {
          int pick = nums[i];
          if(i>1) 
              pick += dp[i-2];
          int nonPick = 0 + dp[i-1];
          
          dp[i] = Math.max(pick, nonPick);
      }
      
      return dp[n-1];
  }
===============================================

//Memoization
	public int rob(int[] nums) {
      int n = nums.length;
      
      int[] dp = new int[n];
      Arrays.fill(dp, -1);
      
      int idx = n-1;
      return solveUtil(idx, nums, dp);
  }
  
  private static int solveUtil(int idx, int[] nums, int[] dp) {
      if(idx < 0) return 0;
      if(idx == 0) return nums[idx];
      
      if(dp[idx] != -1) return dp[idx];
      
      int pick = nums[idx] + solveUtil(idx-2, nums, dp);
      int nonPick = 0 + solveUtil(idx-1, nums, dp);
      
      return dp[idx] = Math.max(pick, nonPick);
  }
===============================================

213. House Robber II

//Ref: https://www.youtube.com/watch?v=3WaxQMELSkw&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=7 Striver
//Using House Robber 1 (Tabulation + Space Optimization Approach)
class Solution {
  public int rob(int[] nums) {
      int n = nums.length;
      if(n == 1) return nums[0];
      
      List<Integer> temp1 = new ArrayList<>();
      List<Integer> temp2 = new ArrayList<>();
      
      for(int i=0; i<n; i++) {
          if(i!=0) temp1.add(nums[i]);
          if(i!=n-1) temp2.add(nums[i]);
      }
      
      int max = Math.max(robUtil(temp1), robUtil(temp2));
      return max;
  }
  
  public int robUtil(List<Integer> nums) {
     int prev = nums.get(0), prev2 = 0;
     int cur_i = 0;
      
     for(int i=1; i<nums.size(); i++) {
          int pick = nums.get(i) + prev2;
          int nonPick = 0 + prev;
          cur_i = Math.max(pick, nonPick);
         
          prev2 = prev;
          prev = cur_i;
      }
      
      return prev;
  }
}
*/
