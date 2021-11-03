package com.string.assignment;

import java.util.Stack;

//https://www.youtube.com/watch?v=wkDfsKijrZ8 Take u forward

// 20. Valid Parentheses
public class ValidParentheses {

	public static void main(String[] args) {

	}

	public boolean isValid(String s) {
		Stack<Character> st = new Stack<Character>();
		for (char it : s.toCharArray()) {
			if (it == '(' || it == '[' || it == '{')
				st.push(it);
			else {
				if (st.isEmpty())
					return false;
				char ch = st.pop();
				if ((it == ')' && ch == '(') || (it == ']' && ch == '[') || (it == '}' && ch == '{'))
					continue;
				else
					return false;
			}
		}
		return st.isEmpty();
	}

}
