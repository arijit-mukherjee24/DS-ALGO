package walmart;

/*
Property 1:
(m * n) % p has a very interesting property:
(m * n) % p =((m % p) * (n % p)) % p

Property 2:
if b is even:
(a ^ b) % c = ((a ^ b/2) * (a ^ b/2))%c ? this suggests divide and conquer
if b is odd:
(a ^ b) % c = (a * (a ^( b-1))%c

Property 3:
If we have to return the mod of a negative number x whose absolute value is less than y:
then (x + y) % y will do the trick

Note:
Also as the product of (a ^ b/2) * (a ^ b/2) and a * (a ^( b-1) may cause overflow, hence we must be careful about those scenarios
*/
public class Q6_PowersOfNumbers {

	public static void main(String[] args) {

	}

	// driver fnc
	long power(int N, int R) {
		return modfun(N, R) % 1000000007;

	}

	public long modfun(long n, long R) {
		// Base cases
		if (n == 0)
			return 0;
		// power zero mean answer is 1
		if (R == 0)
			return 1;
		// If R is even
		long y;
		if (R % 2 == 0) {
			// finding r/2 power as power is even then storing answer in y and if power is
			// even like 2^4 we can simply do (2^2)*(2^2)
			y = modfun(n, R / 2);
			y = (y * y) % 1000000007;
		}

		// If R is odd
		else {
			y = n % 1000000007;
			// reduce the power by 1 to make it even. The reducing power by one can be done
			// if we take one n out. Like 2^3 can be written as 2*(2^2)
			y = (y * modfun(n, R - 1) % 1000000007) % 1000000007;
		}
		// finally return the answer (y+mod)%mod = (y%mod+mod%mod)%mod = (y%mod)%mod
		return ((y + 1000000007) % 1000000007);
	}

}
