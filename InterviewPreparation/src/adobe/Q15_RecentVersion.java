package adobe;

/*
Given two library versions of an executable: 
for example, "10.1.1.3" and "10.1.1.9" or "10" and "10.1". 
Find out which one is more recent? Strings can be empty also.
*/
public class Q15_RecentVersion {

	public static void main(String[] args) {
		String s1 = "10.1.1.3";
		String s2 = "10.1.1.9";

		// String s1 = "10.3.12";
		// String s2 = "10.4";

		// String s1 = "10";
		// String s2 = "10.1";

		String ans = findRecentVersion(s1, s2);
		System.out.println("answer :" + ans);

	}

	public static String findRecentVersion(String s1, String s2) {

		String[] arrS1 = s1.split("\\.");
		String[] arrS2 = s2.split("\\.");

		int m = arrS1.length;
		int n = arrS2.length;

		int i = 0, j = 0;
		while (i < m && j < n) {
			int val1 = Integer.parseInt(arrS1[i]);
			int val2 = Integer.parseInt(arrS2[j]);

			if (val1 > val2) {
				return s1;
			} else if (val2 > val1) {
				return s2;
			} else {
				i++;
				j++;
			}
		}
		return m > n ? s1 : s2;

	}
}