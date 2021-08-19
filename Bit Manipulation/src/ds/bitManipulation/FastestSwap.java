package ds.bitManipulation;

public class FastestSwap {

	static int a = 10;
	static int b = 7;

	public static void main(String[] args) {
		System.out.println("a before = " + a);
		System.out.println("b before = " + b);
		swap(a, b);
		System.out.println("a after = " + a);
		System.out.println("b after = " + b);

	}

	private static void swap(int a2, int b2) {
		a = a ^ b;
		b = b ^ a;
		a = a ^ b;
	}

}
