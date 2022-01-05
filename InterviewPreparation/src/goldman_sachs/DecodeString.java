package goldman_sachs;

// 394. Decode String
// https://practice.geeksforgeeks.org/problems/decode-the-string2444/1 gfg practice

//Ref: https://www.youtube.com/watch?v=0iQqj5egK9k Nick White
import java.util.Stack;

public class DecodeString {

	public static void main(String[] args) {

	}

	public String decodeString(String s) {
		Stack<String> result = new Stack<>();
		Stack<Integer> counts = new Stack<>();
		String res = "";
		int idx = 0;

		while (idx < s.length()) {
			if (Character.isDigit(s.charAt(idx))) {
				int count = 0;
				while (Character.isDigit(s.charAt(idx))) {
					count = count * 10 + s.charAt(idx) - '0';
					idx++;
				}
				counts.push(count);
			} else if (s.charAt(idx) == '[') {
				result.push(res);
				res = "";
				idx++;
			} else if (s.charAt(idx) == ']') {
				StringBuilder sb = new StringBuilder(result.pop());
				// Automatic Implicit Type Conversion - From Integer to int (From Java 1.5)
				int c = counts.pop();
				for (int i = 0; i < c; i++) {
					sb.append(res);
				}
				res = sb.toString();
				idx++;
			} else {
				res += s.charAt(idx);
				idx++;
			}
		}

		return res;
	}

}
