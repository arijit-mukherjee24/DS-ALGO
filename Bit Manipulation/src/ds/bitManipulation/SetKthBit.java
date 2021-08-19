package ds.bitManipulation;

public class SetKthBit {

	public static void main(String[] args) {
		int n = 10;
		int k = 3;
		int newNumber = setKthBit(n, k);
		System.out.println("The new number after setting the kth bit is "+ newNumber);
	}

	private static int setKthBit(int n, int k) {
		int temp = ( 1 << (k -1));
		return n | temp;
	}

}
