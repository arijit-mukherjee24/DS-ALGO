package goldman_sachs;

// 263. Ugly Number
public class UglyNumber {

	public static void main(String[] args) {

	}

	static boolean isUgly(int n) {
		if (n < 1)
			return false;

		while (n % 2 == 0)
			n /= 2;
		while (n % 3 == 0)
			n /= 3;
		while (n % 5 == 0)
			n /= 5;

		return n == 1;

	}

}
