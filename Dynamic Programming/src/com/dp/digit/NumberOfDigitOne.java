package com.dp.digit;

// 233. Number of Digit One
// Digit DP: Techdose Class 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberOfDigitOne {

	int dp[][];// pos...sum

	public static void main(String[] args) {
		
	}

	public int countDigitOne(int n) {
		List<Integer> digits = new ArrayList<>();
		while (n > 0) {
			digits.add(n % 10);
			n /= 10;
		}
		dp = new int[10][10];
		for (int[] r : dp)
			Arrays.fill(r, -1);
		return count(digits, digits.size() - 1, true, 0);
	}

	int count(List<Integer> digits, int pos, boolean restricted, int sum) {
		if (pos == -1)
			return sum;
		if (dp[pos][sum] != -1 && !restricted)
			return dp[pos][sum];

		int ans = 0;
		int limit = restricted ? digits.get(pos) : 9;
		for (int i = 0; i <= limit; ++i) {
			boolean newRestricted = (i == digits.get(pos)) ? restricted : false;
			int is1 = (i == 1) ? 1 : 0;
			ans += count(digits, pos - 1, newRestricted, sum + is1);
		}
		if (!restricted)
			dp[pos][sum] = ans;
		return ans;
	}

}
