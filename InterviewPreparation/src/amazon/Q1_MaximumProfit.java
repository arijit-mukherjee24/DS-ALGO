package amazon;

//https://www.youtube.com/watch?v=3YILP-PdEJA Pepcoding
//TC: O(K * N)      SC: O(K*N)  Effiecient Approach
//Brute Force: 32 min in the video
public class Q1_MaximumProfit {

	public static void main(String[] args) {

	}

	static int maxProfit(int K, int N, int A[]) {
		int[][] dp = new int[K + 1][N];

		// First row (0th transaction means profit = 0 ) Entire row = 0
		// First col (first day: Buying & selling on same day, profit =0) Entire col = 0

		// row -> t - transaction
		// col -> d - day

		for (int t = 1; t <= K; t++) {
			int max = Integer.MIN_VALUE;
			for (int d = 1; d < N; d++) {
				max = Math.max(max, dp[t - 1][d - 1] - A[d - 1]);
				if (max + A[d] > dp[t][d - 1]) {
					dp[t][d] = max + A[d];
				} else {
					dp[t][d] = dp[t][d - 1];
				}
			}
		}

		/*
		 * Brute Forche O(N^3) for(int t=1; t<=K; t++) { for(int d=1; d<N; d++) { int
		 * max = dp[t][d-1]; // pd -> past days for(pd=0; pd<d; pd++) { int ptill =
		 * dp[t-1][pd]; int ptth = A[d] - A[pd];
		 * 
		 * if((ptill + ptth) > max) { max = ptill + ptth; } } dp[t][d] = max; } }
		 */

		return dp[K][N - 1];
	}

}
