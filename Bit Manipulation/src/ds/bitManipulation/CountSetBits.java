package ds.bitManipulation;

public class CountSetBits {

	public static void main(String[] args) {
		int i = 15;
		System.out.println("Np of set bits = " + countSetBits(i));
	}

	private static int countSetBits(int n) {
		if (n == 0)
			return 0;

		int count = 0;
		while (n > 0) {
			count += n & 1;
			n >>= 1;
		}
		
		return count;
	}

}
