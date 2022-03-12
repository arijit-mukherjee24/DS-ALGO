package adobe;

// https://practice.geeksforgeeks.org/problems/7b9d245852bd8caf8a27d6d3961429f0a2b245f1/1/ gfg practice
//Time Complexity: O(N×K)
//Auxiliary Space: O(N×K)

//https://www.geeksforgeeks.org/number-of-distinct-words-of-size-n-with-at-most-k-contiguous-vowels/ gfg
//https://www.youtube.com/watch?v=KyHYIxtwh9A
public class Q3_kvowelwords {

	public static void main(String[] args) {

	}

	public int kvowelwords(int N, int K) {
		// code here
		double[][] dp = new double[N + 1][K + 1];
		double MOD = 1e9;
		MOD = MOD + 7;
		for (int i = 0; i <= N; i++) {

			for (int j = 0; j <= K; j++) {
				if (i == 0) {
					dp[i][j] = 1;
				} else {
					dp[i][j] = dp[i - 1][K] * 21 % MOD;

					if (j > 0) {
						dp[i][j] = (dp[i][j] + dp[i - 1][j - 1] * 5 % MOD) % MOD;
					}
				}

			}

		}

		return (int) dp[N][K];
	}

}
