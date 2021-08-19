package math.algorithm;

public class GCD {

	public static void main(String[] args) {
		int a = 360;
		int b = 60;
		int hcf = gcd(a, b);
		System.out.println("The G.C.D of the given input is " + hcf);

	}

	private static int gcd(int a, int b) {
		if (b == 0)
			return a;

		return gcd(b, (a % b));
	}

}
