package ds.bitManipulation;

public class PowerOfTwo {

	public static void main(String[] args) {
		System.out.println(isPowerOfTwo(31) ? "Yes" : "No");
		System.out.println(isPowerOfTwo(64) ? "Yes" : "No");
		System.out.println(isPowerOfTwo(0) ? "Yes" : "No");
	}

	private static boolean isPowerOfTwo(int x) {
		return (((x & (x - 1)) == 0) && x != 0) ? true : false;
	}

}
