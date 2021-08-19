package ds.bitManipulation;

public class RightMostSetBit {

	public static void main(String[] args) {
		int n = 10;
		rightMostSetBit(n);
	}

	private static void rightMostSetBit(int n) {
		int temp = n & (n-1);
		System.out.println( n ^ temp);
	}

}
