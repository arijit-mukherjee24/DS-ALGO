package intuit;

//https://www.geeksforgeeks.org/find-missing-number-string-numbers-no-separator/ gfg

// https://practice.geeksforgeeks.org/problems/find-the-missing-no-in-string/1/ gfg practice
public class Q3_MissingNumberInString {

	public static void main(String[] args) {

	}

	public int missingNumber(String s) {

		for (int m = 1; m <= 6; m++) {
			int n = getValue(s, 0, m);
			if (n == -1)
				break;

			int missingNo = -1;
			boolean fail = false;

			for (int i = m; i != s.length(); i += 1 + Math.log10(n)) {
				int next2 = getValue(s, i, (int) (1 + Math.log10(n + 2)));
				int next1 = getValue(s, i, (int) (1 + Math.log10(n + 1)));

				if (missingNo == -1 && (next2 == n + 2)) {
					missingNo = n + 1;
					n += 2;
				} else if (next1 == n + 1) {
					n++;
				} else {
					fail = true;
					break;
				}
			}

			if (!fail) {
				return missingNo;
			}
		}

		return -1;
	}

	private static int getValue(String str, int i, int m) {
		if (i + m > str.length())
			return -1;

		int value = 0;
		for (int j = 0; j < m; j++) {
			int c = str.charAt(i + j) - '0';
			if (c < 0 || c > 9) {
				return -1;
			}
			value = value * 10 + c;
		}
		return value;
	}

}
