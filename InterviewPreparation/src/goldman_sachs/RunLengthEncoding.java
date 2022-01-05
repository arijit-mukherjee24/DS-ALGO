package goldman_sachs;

//Ref: Techdelight : https://www.techiedelight.com/run-length-encoding-rle-data-compression-algorithm/
//TC:  O(n) SC: O(1)
// https://practice.geeksforgeeks.org/problems/run-length-encoding/1/ gfg practice
public class RunLengthEncoding {

	public static void main(String[] args) {

	}

	static String encode(String str) {
		String encode = "";
		if (str == null) {
			return encode;
		}

		for (int i = 0; i < str.length(); i++) {
			int count = 1;
			while (i + 1 < str.length() && str.charAt(i) == str.charAt(i + 1)) {
				count++;
				i++;
			}

			encode += str.charAt(i) + String.valueOf(count);
		}

		return encode;
	}

}
