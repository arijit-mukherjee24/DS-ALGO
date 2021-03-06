package math.algorithm;

import java.util.Arrays;

// Find all the prime number upto N
public class SieveOfEratosthenes {

	public static void main(String[] args) {
		int n = 12;
		System.out.println("Following are the prime numbers " + "smaller than or equal to " + n);
		sieveOfEratosthenes(n);
	}

	private static void sieveOfEratosthenes(int n) {
		boolean[] prime = new boolean[n + 1];
		Arrays.fill(prime, true);

		prime[0] = false;
		prime[1] = false;

		for (int i = 2; (i * i) <= n; i++) {
			if (prime[i] == true) {
				for (int j = 2 * i; j <= n; j = j + i) {
					prime[j] = false;
				}

			}
		}

		for (int i = 2; i <= n; i++) {
			if (prime[i] == true) {
				System.out.print(i + " ");
			}
		}
	}

}
