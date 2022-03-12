package adobe;

// https://practice.geeksforgeeks.org/problems/amend-the-sentence3235/1 gfg practice
public class Q11_AmendTheSentence {

	public static void main(String[] args) {

	}

	public String amendSentence(String s) {
		char[] arr = s.toCharArray();
		StringBuilder sb = new StringBuilder();

		int count = 0;
		for (char ch : arr) {
			count++;
			if (Character.isUpperCase(ch) && count != 1) {
				sb.append(" ").append(Character.toLowerCase(ch));
			} else if (count == 1) {
				sb.append(Character.toLowerCase(ch));
			} else {
				sb.append(ch);
			}
		}

		return sb.toString();
	}

}
