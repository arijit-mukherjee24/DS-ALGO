package math.algorithm;

public class TrailingZerosinFactorial {
	public static void main(String[] args) {
		int n = 100;
		System.out.print("Trailing zeroes in the factorial of the given input is " + power(n));
	}

	private static int power(int n) {
		int res = 0;
		for(int i = 5; i<=n; i=i*5) {
			res = res + n/i;
		}
		return res;
	}
}
