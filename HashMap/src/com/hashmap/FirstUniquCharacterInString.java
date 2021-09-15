package com.hashmap;
// Leetcode First unique character in string (387)
public class FirstUniquCharacterInString {

	public static void main(String[] args) {
		String s = "loveleetcode"; // return index of the first unique character
		int ans = firstUniqChar(s);
		System.out.println(ans);
	}

	public static int firstUniqChar(String s) {
		int[] dp = new int[26];
		for (int i = 0; i < s.length(); i++) {
			int x = s.charAt(i) - 'a';
			dp[x]++;
		}
		for (int i = 0; i < s.length(); i++) {
			int x = s.charAt(i) - 'a';
			if (dp[x] == 1)
				return i;
		}
		return -1;
	}

}
