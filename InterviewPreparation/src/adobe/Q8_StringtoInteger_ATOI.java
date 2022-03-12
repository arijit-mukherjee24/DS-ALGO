package adobe;
// 8. String to Integer (atoi)

//Ref: https://www.programcreek.com/2012/12/leetcode-string-to-integer-atoi/
public class Q8_StringtoInteger_ATOI {

	public static void main(String[] args) {

	}

	public int myAtoi(String str) {
		// trim white spaces
		str = str.trim();

		if (str == null || str.length() < 1)
			return 0;

		char flag = '+';

		// check negative or positive
		int i = 0;
		if (str.charAt(0) == '-') {
			flag = '-';
			i++;
		} else if (str.charAt(0) == '+') {
			i++;
		}
		// use double to store result
		double result = 0;

		// calculate value
		while (str.length() > i && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
			result = result * 10 + (str.charAt(i) - '0');
			i++;
		}

		if (flag == '-')
			result = -result;

		// handle max and min
		if (result > Integer.MAX_VALUE)
			return Integer.MAX_VALUE;

		if (result < Integer.MIN_VALUE)
			return Integer.MIN_VALUE;

		return (int) result;
	}

}
