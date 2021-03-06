package ds.bitManipulation;

public class TurnOff {

	public static void main(String[] args) {
		int n = 15;
		int k = 4;
		System.out.println(turnOff(n, k));
	}

	// Function to return a number that has all bits sane as n,
	// except the K'th bit which is made 0
	private static int turnOff(int n, int k) {

		// k must be greater than 0
		if (k <= 0) {
			return n;
		}

		return (n & ~(1 << (k - 1)));
	}

}
