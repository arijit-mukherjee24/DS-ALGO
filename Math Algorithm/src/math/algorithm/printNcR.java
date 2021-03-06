package math.algorithm;

public class printNcR {

	// NcR = Nc(N-R)
	public static void main(String[] args) {
		int n = 50;
		int r = 25;
		System.out.println("The value of " + n + "c" + r + " = ");
		printNcR(n, r);
	}

	private static void printNcR(int n, int r) {
		long p = 1;
		long k = 1;

		if (n - r < r)
			r = n - r;

		if (r != 0) {
			while(r > 0) {
				p *= n;
				k *= r;
				
				long gcd = hcf(p, k);
				p = p/gcd;
				k =k/gcd;
				
				n--;
				r--;
			}
		} 
		else {
			p = 1;
		}
		System.out.print(p);
	}
	
	private static long hcf(long a, long b) {
		if (b == 0)
			return a;

		return hcf(b, a % b);
	}

}
