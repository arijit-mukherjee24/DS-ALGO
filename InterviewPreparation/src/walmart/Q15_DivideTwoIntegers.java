package walmart;
// 29. Divide Two Integers

//Ref: https://www.youtube.com/watch?v=m4L_5qG4vG8 Algorithm Made Easy
//TC: O(logN^2) SC: O(1)
public class Q15_DivideTwoIntegers {

	public static void main(String[] args) {

	}

	public int divide(int dividend, int divisor) {
		if (dividend == 1 << 31 && divisor == -1)
			return Integer.MAX_VALUE;

		boolean sign = (dividend >= 0) == (divisor >= 0) ? true : false;

		dividend = Math.abs(dividend);
		divisor = Math.abs(divisor);
		int result = 0;
		while (dividend - divisor >= 0) {
			int count = 0;
			while (dividend - (divisor << 1 << count) >= 0) {
				count++;
			}

			result += 1 << count;
			dividend -= divisor << count;
		}

		return sign ? result : -result;
	}

}
