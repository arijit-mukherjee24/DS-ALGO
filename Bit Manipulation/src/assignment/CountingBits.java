package assignment;

public class CountingBits {

	public static void main(String[] args) {
		int n = 8;
		int[] ans = countBits(n);
		System.out.println("The set bits from 0 to " + n + " are ");
		for (int i : ans) {
			System.out.print(i + " ");
		}
	}

	private static int[] countBits(int n) {
		int[] result = new int[n + 1];
		result[0] = 0;

		for (int i = 1; i <= n; i++) {
			result[i] = result[i / 2] + i % 2;
		}
		return result;
	}

}
