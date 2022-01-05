package goldman_sachs;

// 1071. Greatest Common Divisor of Strings
//Ref: https://leetcode.com/problems/greatest-common-divisor-of-strings/discuss/1659680/C%2B%2B-1-Liner-faster-than-76-with-easy-explanation leetcode discussion
public class GreatestCommonDivisorofStrings {

	public static void main(String[] args) {

	}

	public String gcdOfStrings(String a, String b) {
		return ((a + b).equals(b + a)) ? a.substring(0, gcd(a.length(), b.length())) : "";
	}

	private static int gcd(int a, int b) {
		if (b == 0)
			return a;
		if (a == 0)
			return b;
		return gcd(b, a % b);
	}

}
