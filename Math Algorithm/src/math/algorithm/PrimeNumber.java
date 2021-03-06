package math.algorithm;

public class PrimeNumber {

	public static void main(String[] args) {
		int n = 11;
		String isPrime = isPrime(n) ? "Prime" : "Not Prime";
		System.out.println("The given input is " + isPrime);
	}

	private static boolean isPrime(int n) {
		for (int i = 2; (i * i) <= n; i++)
			if (n % i == 0) {
				return false;
			}
		return true;
	}

}
