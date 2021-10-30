package com.dp.bitmasking;

//TC- o(n*2^n)
//Ref: 698. Partition to K Equal Sum Subsets
//DP + Bitmasking Techdose Classwork

// 473. Matchsticks to Square
import java.util.Arrays;


public class MatchstickstoSquare {

	public static void main(String[] args) {
		int[] matchsticks = {1,1,2,2,2};
		boolean ans = makesquare(matchsticks);
		System.out.println(ans);
	}

	public static boolean makesquare(int[] matchsticks) {
		// here k=4
		int k = 4;
		// Square all four sides are equal. So, we need to
		// partition to 4(=k) Equal Sum Subsets
		// of all the matchsticks length.

		int n = matchsticks.length;
		int sum = 0, mx = Integer.MIN_VALUE;

		for (int i = 0; i < n; i++) {
			sum += matchsticks[i];
			mx = Math.max(mx, matchsticks[i]);
		}

		// initial checks (generic)
		if ((sum % k != 0) || (mx > sum / k))
			return false;

		int target = sum / k;

		int[] dp = new int[1 << n];
		Arrays.fill(dp, -1); // Size -> 2^n
		dp[0] = 0; // Start Point

		// Try all combinations
		for (int mask = 0; mask < (1 << n); mask++) {
			if (dp[mask] == -1) // Invalid Combinations
				continue;

			for (int j = 0; j < n; j++) {
				// Check if the current jth element can be picked and sum within the limit
				if ((mask & (1 << j)) == 0 && dp[mask] + matchsticks[j] <= target)
					dp[mask | (1 << j)] = (dp[mask] + matchsticks[j]) % target;
			}

		}
		return dp[(1 << n) - 1] == 0 ? true : false;
	}

}
