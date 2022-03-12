package adobe;

import java.util.Arrays;

// https://practice.geeksforgeeks.org/problems/minimum-insertions-to-make-two-arrays-equal/1/
// Runtime Memory Error

// Aditya Verma Soln DP
public class Q13_MinInsDelOps {

	public static void main(String[] args) {

	}

	static int dp[][];

	static int minInsAndDel(int[] A, int[] B, int N, int M) {

		dp = new int[N + 1][M + 1];
		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}
		int lcs = lcs(A, B, N, M);

		return N + M - 2 * lcs;

	}

	private static int lcs(int[] x, int[] y, int m, int n) {
		// base condition
		for (int i = 0; i < m; i++)
			dp[i][0] = 0;

		for (int j = 0; j < n; j++)
			dp[0][j] = 0;

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (x[i - 1] == y[j - 1]) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		return dp[m][n] == -1 ? 0 : dp[m][n];
	}

}
