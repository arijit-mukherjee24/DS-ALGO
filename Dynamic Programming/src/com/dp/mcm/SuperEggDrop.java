package com.dp.mcm;

//https://www.youtube.com/watch?v=jkygQmOiCCI&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=44 Aditya Verma

// 887. Super Egg Drop
// Binary Tree Approach  + MCM
public class SuperEggDrop {

	// TLE - Time Limit Exceeded (82 passed/ 121 test cases)
	public static void main(String[] args) {

	}

	static Integer[][] dp;

	public int superEggDrop(int k, int n) {
		dp = new Integer[k + 1][n + 1];

		/*
		 * for(int[] row: dp) Arrays.fill(row, -1);
		 */

		int res = solve(k, n);
		return res;
	}

	private static int solve(int e, int f) {
		if (e == 1 || f == 0 || f == 1)
			return f;

		if (dp[e][f] != null)
			return dp[e][f];

		/*int min = Integer.MAX_VALUE;
        int low, high;
        for(int k=1; k<=f; k++) {
            if(dp[e-1][k-1] != null) {
                low = dp[e-1][k-1];
            }
            else {
                low = solve(e-1, k-1);
                dp[e-1][k-1] = low;
            }
            if(dp[e][f-k] != null) {
                high = dp[e][f-k];
            }
            else {
                high = solve(e, f-k);
                dp[e][f-k] = high;
            }
            int temp_ans = 1 + Math.max(low, high);
            
            if(temp_ans < min)
                min = temp_ans;
        }
        */

		// there is no critical floor, from whichever floor the egg does not break,
		// in the worst case with min no of attempts is the critical floor
		int min = Integer.MAX_VALUE;
		int low = 1;
		int high = f;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			int left = solve(e - 1, mid - 1);
			int right = solve(e, f - mid);
			int temp = 1 + Math.max(left, right);
			if (left < right) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
			min = Math.min(min, temp);
		}

		return dp[e][f] = min;
	}

}
