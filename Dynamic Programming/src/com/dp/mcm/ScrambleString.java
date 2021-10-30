package com.dp.mcm;

import java.util.HashMap;

// https://www.youtube.com/watch?v=SqA0o-DGmEw&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=40 Aditya Verma

//Ref: https://www.geeksforgeeks.org/check-if-a-string-is-a-scrambled-form-of-another-string/ GFG
//REF: https://www.youtube.com/watch?v=SqA0o-DGmEw Aditya Vermahttps://leetcode.com/problems/scramble-string/discuss/29387/Accepted-Java-solution
//Ref: https://leetcode.com/problems/scramble-string/discuss/29387/Accepted-Java-solution

// 87. Scramble String
public class ScrambleString {
	HashMap<String, Boolean> mp = new HashMap<String, Boolean>();

	public boolean isScramble(String s1, String s2) {
		if (s1.equals(s2))
			return true;
		if (s1.length() != s2.length())
			return false;
		String key = (s1 + " " + s2);
		if (mp.containsKey(key)) {
			return mp.get(key);
		}
		boolean flag = false;

		int[] letters = new int[26];
		for (int i = 0; i < s1.length(); i++) {
			letters[s1.charAt(i) - 'a']++;
			letters[s2.charAt(i) - 'a']--;
		}
		for (int i = 0; i < 26; i++)
			if (letters[i] != 0)
				return false;

		for (int i = 1; i < s1.length(); i++) {
			if (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i))) {
				flag = true;
				return true;
			}
			if (isScramble(s1.substring(0, i), s2.substring(s2.length() - i))
					&& isScramble(s1.substring(i), s2.substring(0, s2.length() - i))) {
				flag = true;
				return true;
			}
			mp.put(key, flag);
		}

		return false;
	}
}
