package com.dsa.stack;

import java.util.ArrayDeque;
import java.util.Deque;
//https://www.geeksforgeeks.org/check-for-balanced-parentheses-in-an-expression/
// https://www.youtube.com/watch?v=FPvAfpSXjRw&list=PLEJXowNB4kPzEvxN8ed6T13Meet7HP3h0&index=4 Techdose
public class BalancedBracket {

	public static void main(String[] args) {
		String expr = "([{}])";

		// Function call
		if (areBracketsBalanced(expr))
			System.out.println("Balanced ");
		else
			System.out.println("Not Balanced ");
	}

	private static boolean areBracketsBalanced(String expr) {

		// Deque is faster than stack
		Deque<Character> stack = new ArrayDeque<Character>();

		for (int i = 0; i < expr.length(); i++) {
			char x = expr.charAt(i);
			if (x == '{' || x == '(' || x == '[') {
				stack.push(x);
				continue;
			}
			
			// If current character is not opening
            // bracket, then it must be closing. So stack
            // cannot be empty at this point.
            if (stack.isEmpty())
                return false;
            
            char check;
            switch(x) {
            case ')':
            	check = stack.pop();
            	if(check == '{' || check == '[')
            		return false;
            	break;
            case '}':
            	check = stack.pop();
            	if(check == '(' || check == '[')
            		return false;
            	break;
            case ']':
            	check = stack.pop();
            	if(check == '{' || check == '(')
            		return false;
            	break;
            }
			
		}

		return (stack.isEmpty());
	}

}
