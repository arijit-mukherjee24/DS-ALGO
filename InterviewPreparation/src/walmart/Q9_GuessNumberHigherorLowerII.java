package walmart;

// 375. Guess Number Higher or Lower II

/* TC: O(n^3)  SC: O(n^2)
Ref: https://www.youtube.com/watch?v=Gi-FQM3Ez84 WorkWithGoogler

DP: dp[i][j] - min amount of money needed to guarantee a win when searching within i and j
    dp[i][j] = Math.min(pivot + Math.max(dp[i][pivot-1], dp[pivot+1][j]))
    
    Target: dp[1][n]

    Corner case: dp[i][i] = 0 (because the only element must be correct)

Equation: we can choose k (i<=k<=j) as our guess, and pay price k. After our guess, the problem is divided into two subproblems. Notice we do not need to pay the money for both subproblems. We only need to pay the worst case (because the system will tell us which side we should go) to guarantee win. So dp[i][j] = min (i<=k<=j) { k + max(dp[i][k-1], dp[k+1][j]) }

Ref: https://leetcode.com/problems/guess-number-higher-or-lower-ii/discuss/84787/Java-DP-solution
*/
public class Q9_GuessNumberHigherorLowerII {

	public static void main(String[] args) {

	}

	public int getMoneyAmount(int n) {
		int[][] dp = new int[n + 2][n + 2];
		for (int len = 2; len <= n; len++) {
			for (int start = 1; start <= n - len + 1; start++) {
				int end = start + len - 1;

				int curMin = Integer.MAX_VALUE;
				for (int pivot = start; pivot <= end; pivot++) {
					curMin = Math.min(curMin, pivot + Math.max(dp[start][pivot - 1], dp[pivot + 1][end]));
				}

				dp[start][end] = curMin;
			}
		}
		// Range: 1 to n
		return dp[1][n];
	}

}
