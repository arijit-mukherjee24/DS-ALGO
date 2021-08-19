package ds.bitManipulation;

public class KthBitSet {

	public static void main(String[] args) {
		int i = 10, k = 2;

		String isSet = isKthBitSet(i, k) ? "set" : "unset";
		System.out.println("Kth Bit is " + isSet);
	}

	private static boolean isKthBitSet(int i, int k) {
		int temp = 1 << (k - 1);

		return ((i & temp) > 0);
	}

}
