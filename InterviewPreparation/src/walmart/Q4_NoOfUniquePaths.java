package walmart;

// https://practice.geeksforgeeks.org/problems/number-of-unique-paths5339/1/ gfg
// Number of Unique Paths 

//https://www.youtube.com/watch?v=rBAxUTqvlQA Techdose
public class Q4_NoOfUniquePaths {

	public static void main(String[] args) {

	}

	static int[][] dp;

	// Function to find total number of unique paths.
	public static int NumberOfPath(int a, int b) {
		dp = new int[a + 1][b + 1];
		return helper(a, b);
	}

	static int helper(int a, int b) {
		if (a == 1 || b == 1)
			return 1;

		if (dp[a][b] != 0)
			return dp[a][b];

		dp[a][b] = helper(a - 1, b) + helper(a, b - 1);

		return dp[a][b];
	}

}
