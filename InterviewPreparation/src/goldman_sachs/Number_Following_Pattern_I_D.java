package goldman_sachs;

import java.util.Stack;

// https://practice.geeksforgeeks.org/problems/number-following-a-pattern3126/1 gfg practice

//Ref: https://www.youtube.com/watch?v=GOCbsY7Arw4 Pepcoding 
public class Number_Following_Pattern_I_D {

	public static void main(String[] args) {

	}

	static String printMinNumberForPattern(String S) {
		int num = 1;
		Stack<Integer> st = new Stack<>();
		String min = "";

		for (int i = 0; i < S.length(); i++) {
			if (S.charAt(i) == 'D') {
				st.push(num);
				num++;

			} else {
				st.push(num);
				num++;

				while (st.size() > 0) {
					min += String.valueOf(st.pop());
				}
			}
		}

		st.push(num);
		while (st.size() > 0) {
			min += String.valueOf(st.pop());
		}

		return min;
	}

}
