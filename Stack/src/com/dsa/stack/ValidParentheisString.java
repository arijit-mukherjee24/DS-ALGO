package com.dsa.stack;

import java.util.Stack;

public class ValidParentheisString {

	public static void main(String[] args) {
		String s = "(*))";

		// Function call
		if (checkValidString(s))
			System.out.println("Balanced ");
		else
			System.out.println("Not Balanced ");
	}

	private static boolean checkValidString(String s) {

		Stack<Integer> stack = new Stack<Integer>();
		Stack<Integer> star = new Stack<Integer>();

		for (int i = 0; i < s.length(); i++) {
			char x = s.charAt(i);
			if (x == '(') {
				stack.push(i);
				continue;
			} else if (x == '*') {
				star.push(i);
			} else {
				if (!stack.isEmpty()) {
					stack.pop();
				} else if (!star.empty()) {
					// Require for this case
					// Input: s = "(*))"
					// Output: true
					star.pop();
				} else {
					return false;
				}
			}
		}

		// Now process leftover opening brackets
		while (!stack.isEmpty()) {
			if (star.empty())
				return false;
			else if (stack.peek() < star.peek()) {
				stack.pop();
				star.pop();
			} else // CASE: stack.top() > star.top()
				return false;
		}
		return true;
	}

}
