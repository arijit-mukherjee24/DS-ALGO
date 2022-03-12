package adobe;

// https://practice.geeksforgeeks.org/problems/express-as-sum-of-power-of-natural-numbers5647/1 gfg practice

//Ref: https://www.youtube.com/watch?v=VqvLWIRat0s Recursive soln
//GFG: https://www.geeksforgeeks.org/find-ways-integer-can-expressed-sum-n-th-power-unique-natural-numbers/
//(3rd soln)

// Time Limit Exceeded (TLE) in gfg practice
public class Q5_ExpressSumPower {

	public static void main(String[] args) {

	}

	static int numOfWays(int n, int x) {
		int MOD = 1000000007;
		return numOfWaysHelper(n, x, 1) % MOD;
	}

	// Helper function
	static int numOfWaysHelper(int remainingSum, int power, int base) {
		int MOD = 1000000007;
		remainingSum %= MOD;

		// calculate power
		int result = power(base, power, MOD);
		result %= MOD;

		if (remainingSum == result)
			return 1;
		if (remainingSum < result)
			return 0;
		// Two recursive calls one to include current base's power in sum another to
		// exclude
		int x = numOfWaysHelper(remainingSum - result, power, base + 1);
		x %= MOD;
		int y = numOfWaysHelper(remainingSum, power, base + 1);
		y %= MOD;
		return (x + y) % MOD;
	}

	// x^y
	static int power(int x, int y, int p) {
		int res = 1;
		x = x % p;

		if (x == 0)
			return 0;

		while (y > 0) {
			if ((y & 1) != 0)
				res = (res * x) % p;

			y = y >> 1;
			x = (x * x) % p;
		}
		return res;
	}

}
