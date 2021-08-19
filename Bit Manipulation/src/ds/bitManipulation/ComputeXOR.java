package ds.bitManipulation;

public class ComputeXOR {

	public static void main(String[] args) {
		int n = 8;
		int ans = computeXOR1toN(n);
		System.out.println("The XOR of 1 to " + n + " is " + ans);
	}

	private static int computeXOR1toN(int n) {
		if (n % 4 == 0)
			return n;
		else if (n % 4 == 1)
			return 1;
		else if (n % 4 == 2)
			return (n + 1);
		else
			return 0;
	}

}
