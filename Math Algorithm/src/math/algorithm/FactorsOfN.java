package math.algorithm;

public class FactorsOfN {

	public static void main(String[] args) {
		int n = 100;
		System.out.println("The factors of the given input are");
		factors(n);
	}

	private static void factors(int n) {
		for (int i = 1; (i * i) <= n; i++)
			if (n % i == 0) {
				System.out.print(i + " ");
				if (i != (n / i)) {
					System.out.print((n / i) + " ");
				}
			}

	}

}
