package adobe;

import java.util.ArrayList;
import java.util.List;

// Leetcode 22. Generate Parentheses
//Ref: https://www.youtube.com/watch?v=eyCj_u3PoJE Aditya Verma

public class Q6_GenerateParentheses {

	public static void main(String[] args) {
		int n = 3;
		List<String> res = generateParenthesis(n);
		System.out.println(res);
	}

	public static List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<String>();
		int open = n;
		int close = n;
		String op = "";

		solve(open, close, op, res);
		return res;
	}

	public static void solve(int open, int close, String op, List<String> res) {
		if (open == 0 && close == 0) {
			res.add(op);
			return;
		}

		if (open != 0) {
			String op1 = op + "(";
			solve(open - 1, close, op1, res);
		}

		if (close > open) {
			String op2 = op + ")";
			solve(open, close - 1, op2, res);
		}

	}

}
