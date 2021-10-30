package com.dp.mcm;

import java.util.Arrays;

//https://www.youtube.com/watch?v=jkygQmOiCCI&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=44 Aditya Verma

// 1884. Egg Drop With 2 Eggs and N Floors
public class EggDropWith2EggsandNFloors {

	public static void main(String[] args) {

	}

	static int[][] dp;

	public int twoEggDrop(int n) {
		dp = new int[2 + 1][n + 1];

		for (int[] row : dp)
			Arrays.fill(row, -1);

		int res = solve(2, n);
		return res;
	}

	private static int solve(int e, int f) {
		if (e == 1 || f == 0 || f == 1)
			return f;

		if (dp[e][f] != -1)
			return dp[e][f];

		int min = Integer.MAX_VALUE;
		for (int k = 1; k <= f; k++) {
			int temp_ans = 1 + Math.max(solve(e - 1, k - 1), solve(e, f - k));
			if (temp_ans < min)
				min = temp_ans;
		}
		return dp[e][f] = min;

	}

}
