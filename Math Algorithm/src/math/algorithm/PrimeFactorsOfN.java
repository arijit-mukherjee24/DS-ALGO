package math.algorithm;

// Print all the prime factors of a given number
public class PrimeFactorsOfN {

	public static void main(String[] args) {
		int n = 315;
		System.out.println("The prime factors of the given input are");
		primeFactors(n);
	}

	private static void primeFactors(int n) {
		while (n % 2 == 0) {
			System.out.print("2 ");
			n = n / 2;
		}

		for (int i = 3; (i * i) < n; i = i + 2) {
			while (n % i == 0) {
				System.out.print(i + " ");
				n = n / i;
			}
		}

		if (n > 2) {
			System.out.print(n + " ");
		}
	}

}
