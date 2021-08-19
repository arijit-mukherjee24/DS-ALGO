package ds.bitManipulation;

public class UnsetKthBit {

	public static void main(String[] args) {
		int n = 10;
		int k = 2;
		int newNumber = unsetKthBit(n, k);
		System.out.println("The new number after setting the kth bit is " + newNumber);
	}

	private static int unsetKthBit(int n, int k) {
		int temp = (1 << (k - 1));
		// ~temp
		return (n & ~temp);
	}

}
