package microsoft;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Leetcode 17. Letter Combinations of a Phone Number
//Ref: https://www.youtube.com/watch?v=0snEunUacZY Neetcode
//TC = O(n.4^n)  n = number of digits in the string

public class Q6_LetterCombinationsPhoneNumber {

	public static void main(String[] args) {
		String digits = "23";
		List<String> res = letterCombinations(digits);
		System.out.println(res);
	}

	public static List<String> letterCombinations(String digits) {
		List<String> res = new ArrayList<String>();

		if (digits == null || digits.length() == 0)
			return res;

		Map<Character, String> map = new HashMap<Character, String>();
		map.put('2', "abc");
		map.put('3', "def");
		map.put('4', "ghi");
		map.put('5', "jkl");
		map.put('6', "mno");
		map.put('7', "pqrs");
		map.put('8', "tuv");
		map.put('9', "wxyz");

		int i = 0;
		String currStr = "";
		solve(i, currStr, map, digits, res);

		return res;
	}

	private static void solve(int i, String currStr, Map<Character, String> map, String digits, List<String> res) {
		if (digits.length() == currStr.length()) {
			res.add(currStr);
			return;
		}

		String letters = map.get(digits.charAt(i));
		for (int j = 0; j < letters.length(); j++) {
			solve(i + 1, currStr + letters.charAt(j), map, digits, res);
		}
	}

}
