package ds.bitManipulation;

public class PowerOfTwo2 {

	public static void main(String[] args) {
		System.out.println(isPowerOfTwo(31) ? "Yes" : "No");
		System.out.println(isPowerOfTwo(64) ? "Yes" : "No");
		System.out.println(isPowerOfTwo(0) ? "Yes" : "No");
		System.out.println(isPowerOfTwo(1) ? "Yes" : "No");
	}

	private static boolean isPowerOfTwo(int x) {
		if (x == 0)
			return false;

		while (x != 1) {
			if (x % 2 != 0) {
				return false;
			}
			x = x / 2;
		}
		return true;
	}

}
