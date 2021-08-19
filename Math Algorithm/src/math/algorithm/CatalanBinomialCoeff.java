package math.algorithm;
// https://www.geeksforgeeks.org/program-nth-catalan-number/

// Application : https://www.geeksforgeeks.org/applications-of-catalan-numbers/
public class CatalanBinomialCoeff {

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.print(catalanDP(i) + " ");
		}
	}

	private static long catalanDP(int n) {

		// Calculate value of 2nCn
		long c = binomialCoeff(2 * n, n);

		// return C(n) = 2nCn/(n+1)
		return c / (n + 1);
	}

	// Returns value of Binomial Coefficient C(n, k)
	private static long binomialCoeff(int n, int k) {
		long res = 1;

		// Since C(n, k) = C(n, n-k)
		if (k > n - k) {
			k = n - k;
		}

		// Calculate value of [n*(n-1)*---*(n-k+1)] /
		// [k*(k-1)*---*1]
		for (int i = 0; i < k; ++i) {
			res *= (n - i);
			res /= (i + 1);
		}

		return res;
	}

}
// output : 1 1 2 5 14 42 132 429 1430 4862 
