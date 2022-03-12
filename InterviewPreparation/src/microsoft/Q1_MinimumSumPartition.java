package microsoft;

//Tab: https://github.com/arpan-banerjee7/DS_ALGO/blob/master/DP/src/dp/knapsack/MinSubsetSumDiffTab.java
//Mem: https://github.com/arpan-banerjee7/DS_ALGO/blob/master/DP/src/dp/knapsack/SubsetSumMem.java

//https://www.youtube.com/watch?v=tRpkluGqINc Pepcoding: Target Sum
//https://www.youtube.com/watch?v=_gPcYovP7wc Aditya: Subset Sum
//https://www.youtube.com/watch?v=-GtpxG6l_Mc Aditya: Minimum Subset Sum Difference 
public class Q1_MinimumSumPartition {

	public static void main(String[] args) {

	}

	public int minDifference(int arr[], int n) {
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += arr[i];
		}

		boolean[][] dp = new boolean[n + 1][sum + 1];
		// when sum is 0 always true
		for (int i = 0; i <= n; i++) {
			dp[i][0] = true;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= sum; j++) {
				if (arr[i - 1] > j)
					dp[i][j] = dp[i - 1][j];
				else
					dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
			}
		}

		int currMin = 0;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i <= sum / 2; i++) {
			if (dp[n][i]) {
				currMin = sum - 2 * i;
				min = Math.min(min, currMin);
			}
		}

		return min;
	}

}
